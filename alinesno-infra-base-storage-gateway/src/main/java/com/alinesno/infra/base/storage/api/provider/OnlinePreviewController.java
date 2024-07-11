package com.alinesno.infra.base.storage.api.provider;

import com.alinesno.infra.base.storage.core.model.FileAttribute;
import com.alinesno.infra.base.storage.core.service.CacheService;
import com.alinesno.infra.base.storage.core.service.FileHandlerService;
import com.alinesno.infra.base.storage.core.service.FilePreview;
import com.alinesno.infra.base.storage.core.service.FilePreviewFactory;
import com.alinesno.infra.base.storage.core.service.impl.OtherFilePreviewImpl;
import com.alinesno.infra.base.storage.core.utils.KkFileUtils;
import com.alinesno.infra.base.storage.core.utils.WebUtils;
import com.alinesno.infra.base.storage.api.utils.FileParser;
import com.alinesno.infra.base.storage.entity.DocumentInfoEntity;
import com.alinesno.infra.base.storage.service.IDocumentInfoService;
import com.alinesno.infra.common.web.log.annotation.Log;
import com.alinesno.infra.common.web.log.enums.BusinessType;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.opensagres.xdocreport.core.io.IOUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.DefaultRedirectStrategy;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author yudian-it
 * @author luoxiaodong
 */
@Slf4j
@Controller
public class OnlinePreviewController {

    public static final String BASE64_DECODE_ERROR_MSG = "Base64解码失败，请检查你的 %s 是否采用 Base64 + urlEncode 双重编码了！";

    @Autowired
    private IDocumentInfoService documentInfoService ;
    private final FilePreviewFactory previewFactory;
    private final CacheService cacheService;
    private final FileHandlerService fileHandlerService;
    private final OtherFilePreviewImpl otherFilePreview;
    private static final RestTemplate restTemplate = new RestTemplate();
    private static  final HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
    private static final ObjectMapper mapper = new ObjectMapper();

    public OnlinePreviewController(FilePreviewFactory filePreviewFactory, FileHandlerService fileHandlerService, CacheService cacheService, OtherFilePreviewImpl otherFilePreview) {
        this.previewFactory = filePreviewFactory;
        this.fileHandlerService = fileHandlerService;
        this.cacheService = cacheService;
        this.otherFilePreview = otherFilePreview;
    }

    @Log(title = "文档预览", businessType = BusinessType.OTHER)
    @GetMapping( "/onlinePreview")
    public String onlinePreview(String url, Model model, HttpServletRequest req) {

        String fileUrl;
        try {
            fileUrl = WebUtils.decodeUrl(url);
        } catch (Exception ex) {
            String errorMsg = String.format(BASE64_DECODE_ERROR_MSG, "url");
            return otherFilePreview.notSupportedFile(model, errorMsg);
        }

        FileAttribute fileAttribute = fileHandlerService.getFileAttribute(fileUrl, req);  //这里不在进行URL 处理了
        model.addAttribute("file", fileAttribute);
        FilePreview filePreview = previewFactory.get(fileAttribute);

        // 判断是否开通这个接口服务的权限
        String projectCode = req.getParameter("projectCode") ;
        boolean checkServiceOpen = documentInfoService.checkAccountService(projectCode , fileAttribute.getSuffix()) ;
        if(!checkServiceOpen){
            String errorMsg = "appId文档权限不足，请配置查看权限." ;
            return otherFilePreview.notSupportedFile(model, errorMsg);
        }

        // 保存文件到数据库中
        DocumentInfoEntity documentInfoEntity = FileParser.parseFileAttribute(fileAttribute , filePreview) ;
        documentInfoService.saveDocument(documentInfoEntity) ;
        
        log.info("预览文件url：{}，previewType：{}", fileUrl, fileAttribute.getType());

        return filePreview.filePreviewHandle(WebUtils.urlEncoderencode(fileUrl), model, fileAttribute);  //统一在这里处理 url
    }

    @Log(title = "图片预览", businessType = BusinessType.OTHER)
    @GetMapping( "/picturesPreview")
    public String picturesPreview(String urls, Model model, HttpServletRequest req) {
        String fileUrls;
        try {
            fileUrls = WebUtils.decodeUrl(urls);
            // 防止XSS攻击
            fileUrls = KkFileUtils.htmlEscape(fileUrls);
        } catch (Exception ex) {
            String errorMsg = String.format(BASE64_DECODE_ERROR_MSG, "urls");
            return otherFilePreview.notSupportedFile(model, errorMsg);
        }
        log.info("预览文件url：{}，urls：{}", fileUrls, urls);
        // 抽取文件并返回文件列表
        String[] images = fileUrls.split("\\|");
        List<String> imgUrls = Arrays.asList(images);
        model.addAttribute("imgUrls", imgUrls);
        String currentUrl = req.getParameter("currentUrl");
        if (StringUtils.hasText(currentUrl)) {
            String decodedCurrentUrl = new String(Base64.decodeBase64(currentUrl));
                   decodedCurrentUrl = KkFileUtils.htmlEscape(decodedCurrentUrl);   // 防止XSS攻击
            model.addAttribute("currentUrl", decodedCurrentUrl);
        } else {
            model.addAttribute("currentUrl", imgUrls.get(0));
        }
        return FilePreview.PICTURE_FILE_PREVIEW_PAGE;
    }

    /**
     * 根据url获取文件内容
     * 当pdfjs读取存在跨域问题的文件时将通过此接口读取
     *
     * @param urlPath  url
     * @param response response
     */
    @Log(title = "跨域预览", businessType = BusinessType.OTHER)
    @GetMapping("/getCorsFile")
    public void getCorsFile(String urlPath, HttpServletResponse response, FileAttribute fileAttribute) throws IOException {
        URL url;
        try {
            urlPath = WebUtils.decodeUrl(urlPath);
            url = WebUtils.normalizedURL(urlPath);
        } catch (Exception ex) {
            log.error(String.format(BASE64_DECODE_ERROR_MSG, urlPath),ex);
            return;
        }
        assert urlPath != null;
        if (!urlPath.toLowerCase().startsWith("http") && !urlPath.toLowerCase().startsWith("https") && !urlPath.toLowerCase().startsWith("ftp")) {
            log.info("读取跨域文件异常，可能存在非法访问，urlPath：{}", urlPath);
            return;
        }
        InputStream inputStream = null;
        log.info("读取跨域pdf文件url：{}", urlPath);
        if (!urlPath.toLowerCase().startsWith("ftp:")) {
            factory.setConnectionRequestTimeout(2000);
            factory.setConnectTimeout(10000);
            factory.setConnectionRequestTimeout(72000);
            HttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new DefaultRedirectStrategy()).build();
            factory.setHttpClient(httpClient);
            restTemplate.setRequestFactory(factory);
            RequestCallback requestCallback = request -> {
                request.getHeaders().setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
                String proxyAuthorization = fileAttribute.getKkProxyAuthorization();
                if(StringUtils.hasText(proxyAuthorization)){
                    Map<String,String> proxyAuthorizationMap = mapper.readValue(proxyAuthorization, Map.class);
                    proxyAuthorizationMap.forEach((key, value) -> request.getHeaders().set(key, value));
                }
            };
            try {
                restTemplate.execute(url.toURI(), HttpMethod.GET, requestCallback, fileResponse -> {
                    IOUtils.copy(fileResponse.getBody(), response.getOutputStream());
                    return null;
                });
            }  catch (Exception e) {
                System.out.println(e);
            }
        }else{
            try {
                if(urlPath.contains(".svg")) {
                    response.setContentType("image/svg+xml");
                }
                inputStream = (url).openStream();
                IOUtils.copy(inputStream, response.getOutputStream());
            } catch (IOException e) {
                log.error("读取跨域文件异常，url：{}", urlPath);
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        }
    }

}
