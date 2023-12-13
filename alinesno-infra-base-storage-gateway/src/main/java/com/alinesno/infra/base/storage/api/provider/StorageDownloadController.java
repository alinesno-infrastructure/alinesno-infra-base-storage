package com.alinesno.infra.base.storage.api.provider;

import com.alinesno.infra.base.storage.api.aspect.Intercepted;
import com.alinesno.infra.base.storage.api.dto.InfraFileInfoDto;
import com.alinesno.infra.base.storage.plugins.IParentFileStorageService;
import com.alinesno.infra.common.facade.response.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 存储下载控制器
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Scope
@RestController
@RequestMapping("/api/base/storage")
public class StorageDownloadController {

    private static final Logger log = LoggerFactory.getLogger(StorageDownloadController.class);

    @Autowired
    private IParentFileStorageService fileStorageService; // 注入实例

    /**
     * 获取预签名 URL
     *
     * @param storageId 存储ID
     * @return AjaxResult 包含预签名 URL
     */
    @GetMapping("/presignedUrl")
    public AjaxResult presignedUrl(@RequestParam(name = "storageId") String storageId) {
        String presignedUrl = fileStorageService.presignedUrl(storageId);
        return AjaxResult.success("获取预告签名文件" , presignedUrl);
    }

    /**
     * 下载文件
     *
     * @param storageId 存储ID
     * @return ResponseEntity 包含文件内容的响应实体
     */
    @Intercepted
    @GetMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam(name = "storageId") String storageId) {

        InfraFileInfoDto fileInfo = fileStorageService.getFileInfo(storageId);
        byte[] byteBody = fileStorageService.download(storageId);

        HttpHeaders headers = new HttpHeaders();
        String fileName = fileInfo.getFilename();

        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<>(byteBody, headers, HttpStatus.OK);
    }
}
