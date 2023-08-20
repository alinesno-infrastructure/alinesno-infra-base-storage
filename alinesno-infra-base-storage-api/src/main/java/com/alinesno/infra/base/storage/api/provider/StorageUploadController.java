package com.alinesno.infra.base.storage.api.provider;

import com.alinesno.infra.base.storage.plugins.IParentFileStorageService;
import com.alinesno.infra.common.facade.response.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 存储上传控制器
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@RestController
public class StorageUploadController {

    @Autowired
    private IParentFileStorageService fileStorageService; // 注入实例

    /**
     * 删除文件
     *
     * @param storageId 存储ID
     * @return AjaxResult 包含删除结果
     */
    @PostMapping("/delete")
    public AjaxResult delete(String storageId) {
        boolean delete = fileStorageService.delete(storageId);
        return AjaxResult.success(delete);
    }

    /**
     * 检查文件是否存在
     *
     * @param storageId 存储ID
     * @return AjaxResult 包含文件存在结果
     */
    @PostMapping("/exists")
    public AjaxResult exists(String storageId) {
        boolean exists = fileStorageService.exists(storageId);
        return AjaxResult.success(exists);
    }

    /**
     * 上传文件
     *
     * @param file MultipartFile 文件
     * @return AjaxResult 包含上传结果
     */
    @PostMapping("/upload")
    public AjaxResult upload(MultipartFile file) {
        return fileStorageService.upload(file);
    }

    /**
     * 上传文件并返回文件URL
     *
     * @param file MultipartFile 文件
     * @return AjaxResult 包含上传结果和文件URL
     */
    @PostMapping("/upload2")
    public AjaxResult uploadCallbackUrl(MultipartFile file) {
        return fileStorageService.uploadCallbackUrl(file);
    }

    /**
     * 上传图片并返回文件信息
     * 图片处理使用的是 https://github.com/coobird/thumbnailator
     *
     * @param file MultipartFile 图片文件
     * @return AjaxResult 包含上传结果和文件信息
     */
    @PostMapping("/upload-image")
    public AjaxResult uploadImage(MultipartFile file) {
        return fileStorageService.uploadImage(file);
    }

    /**
     * 上传文件到指定存储平台并返回文件信息
     *
     * @param file MultipartFile 文件
     * @return AjaxResult 包含上传结果和文件信息
     */
    @PostMapping("/upload-platform")
    public AjaxResult uploadPlatform(MultipartFile file) {
        return fileStorageService.uploadPlatform(file);
    }
}
