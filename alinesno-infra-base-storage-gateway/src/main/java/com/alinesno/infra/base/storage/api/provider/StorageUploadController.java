package com.alinesno.infra.base.storage.api.provider;

import com.alinesno.infra.base.storage.api.aspect.Intercepted;
import com.alinesno.infra.base.storage.plugins.IParentFileStorageService;
import com.alinesno.infra.common.facade.response.AjaxResult;
import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 存储上传控制器
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
@Scope
@RestController
@RequestMapping("/api/base/storage")
public class StorageUploadController {

    @Value("${alinesno.storage.force:}")
    private String forceStore ;

    @Autowired
    private IParentFileStorageService fileStorageService; // 注入实例

    /**
     * 删除文件
     *
     * @param storageId 存储ID
     * @return AjaxResult 包含删除结果
     */
    @DeleteMapping("/delete")
    public AjaxResult delete(@RequestParam String storageId) {
        boolean delete = fileStorageService.delete(storageId);
        return AjaxResult.success(delete);
    }

    /**
     * 检查文件是否存在
     *
     * @param storageId 存储ID
     * @return AjaxResult 包含文件存在结果
     */
    @GetMapping("/exists")
    public AjaxResult exists(@RequestParam String storageId) {
        boolean exists = fileStorageService.exists(storageId);
        return AjaxResult.success(exists);
    }

    /**
     * 上传文件
     *
     * @param file MultipartFile 文件
     * @return AjaxResult 包含上传结果
     */
    @Intercepted
    @PostMapping("/upload")
    public AjaxResult upload(@RequestParam("file")  MultipartFile file ,
                             @RequestParam String platform) {

        Assert.isTrue(!file.isEmpty(), "上传文件为空");


        if(StringUtils.isNoneBlank(forceStore)){
            platform = forceStore ;
        }

        log.info("上传文件到存储平台：{}", platform);

        return fileStorageService.upload(file , platform);
    }

    /**
     * 上传文件并返回文件URL
     *
     * @param file MultipartFile 文件
     * @return AjaxResult 包含上传结果和文件URL
     */
    @Intercepted
    @PostMapping("/uploadCallbackUrl")
    public AjaxResult uploadCallbackUrl(MultipartFile file , String platform) {


        if(StringUtils.isNoneBlank(forceStore)){
            platform = forceStore ;
        }

        log.info("上传文件到存储平台：{}", platform);

        return fileStorageService.uploadCallbackUrl(file , platform);
    }

    /**
     * 上传图片并返回文件信息
     * 图片处理使用的是 https://github.com/coobird/thumbnailator
     *
     * @param file MultipartFile 图片文件
     * @return AjaxResult 包含上传结果和文件信息
     */
    @Intercepted
    @PostMapping("/uploadImage")
    public AjaxResult uploadImage(@RequestParam("file")  MultipartFile file ,
                                  @RequestParam String platform) {
        return fileStorageService.uploadImage(file , platform);
    }

    /**
     * 上传文件到指定存储平台并返回文件信息
     *
     * @param file MultipartFile 文件
     * @return AjaxResult 包含上传结果和文件信息
     */
    @Intercepted
    @PostMapping("/uploadPlatform")
    public AjaxResult uploadPlatform(@RequestParam("file")  MultipartFile file ,
                                     @RequestParam String platform) {
        return fileStorageService.uploadPlatform(file , platform);
    }
}
