package com.alinesno.infra.base.fileshow.core.filter;

import com.alinesno.infra.base.fileshow.core.config.ConfigConstants;
import com.alinesno.infra.base.fileshow.core.utils.WebUtils;
import io.mola.galimatias.GalimatiasParseException;
import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.jodconverter.core.util.OSUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * @author : kl (http://kailing.pub)
 * @author luoxiaodong
 * @since : 2022-05-25 17:45
 */
@Slf4j
public class TrustDirFilter implements Filter {

    private String notTrustDirView;


    @Override
    public void init(FilterConfig filterConfig) {
        ClassPathResource classPathResource = new ClassPathResource("pages/notTrustDir.html");
        try {
            classPathResource.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(classPathResource.getInputStream());
            this.notTrustDirView = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error("初始化异常:{}" , e.getMessage());
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String url = WebUtils.getSourceUrl(request);
        if (!allowPreview(url)) {
            response.getWriter().write(this.notTrustDirView);
            response.getWriter().close();
        } else {
            chain.doFilter(request, response);
        }
    }

    private boolean allowPreview(String urlPath) {
        //判断URL是否合法
        if(!StringUtils.hasText(urlPath) || !WebUtils.isValidUrl(urlPath)) {
            return false ;
        }
        try {
            URL url = WebUtils.normalizedURL(urlPath);
            if ("file".equals(url.getProtocol().toLowerCase(Locale.ROOT))) {
                String filePath = URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8.name());
                if (OSUtils.IS_OS_WINDOWS) {
                    filePath = filePath.replaceAll("/", "\\\\");
                }
                return filePath.startsWith(ConfigConstants.getFileDir()) || filePath.startsWith(ConfigConstants.getLocalPreviewDir());
            }
            return true;
        } catch (IOException | GalimatiasParseException e) {
            log.error("解析URL异常，url：{}", urlPath, e);
            return false;
        }
    }
}
