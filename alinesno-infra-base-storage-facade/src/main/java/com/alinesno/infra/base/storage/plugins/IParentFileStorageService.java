package com.alinesno.infra.base.storage.plugins;

import com.alinesno.infra.base.storage.api.dto.InfraFileInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 父级文件存储服务接口
 */
public interface IParentFileStorageService {

    /**
     * 上传文件
     *
     * @param file     要上传的文件
     * @param platform
     * @return 上传结果
     */
    AjaxResult upload(MultipartFile file, String platform);

    /**
     * 上传文件并回调URL
     *
     * @param file     要上传的文件
     * @param platform
     * @return 上传结果
     */
    AjaxResult uploadCallbackUrl(MultipartFile file, String platform);

    /**
     * 上传图片文件
     *
     * @param file     要上传的图片文件
     * @param platform
     * @return 上传结果
     */
    AjaxResult uploadImage(MultipartFile file, String platform);

    /**
     * 上传平台文件
     *
     * @param file     要上传的平台文件
     * @param platform
     * @return 上传结果
     */
    AjaxResult uploadPlatform(MultipartFile file, String platform);

    /**
     * 检查存储ID是否存在
     *
     * @param storageId 存储ID
     * @return 如果存在返回true，否则返回false
     */
    boolean exists(String storageId);

    /**
     * 删除存储ID对应的文件
     *
     * @param storageId 存储ID
     * @return 删除是否成功
     */
    boolean delete(String storageId);

    /**
     * 下载存储ID对应的文件
     *
     * @param storageId 存储ID
     * @return 文件的字节数组
     */
    byte[] download(Long storageId);

    /**
     * 获取存储ID对应的文件信息
     *
     * @param storageId 存储ID
     * @return 文件信息对象
     */
    InfraFileInfo getFileInfo(Long storageId);

    /**
     * 获取存储ID对应文件的预签名URL
     *
     * @param storageId 存储ID
     * @return 预签名URL
     */
    String presignedUrl(Long storageId);
}
