package com.alinesno.infra.base.storage.plugins;

import com.alinesno.infra.base.storage.api.dto.InfraFileInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 父级文件存储服务实现类
 */
public class ParentFileStorageServiceImpl implements IParentFileStorageService {

    @Override
    public AjaxResult upload(MultipartFile file) {
        return null;
    }

    @Override
    public AjaxResult uploadCallbackUrl(MultipartFile file) {
        return null;
    }

    @Override
    public AjaxResult uploadImage(MultipartFile file) {
        return null;
    }

    @Override
    public AjaxResult uploadPlatform(MultipartFile file) {
        return null;
    }

    @Override
    public boolean exists(String storageId) {
        return false;
    }

    @Override
    public boolean delete(String storageId) {
        return false;
    }

    @Override
    public byte[] download(Long storageId) {
        return new byte[0];
    }

    @Override
    public InfraFileInfo getFileInfo(Long storageId) {
        return null;
    }

    @Override
    public String presignedUrl(Long storageId) {
        return null;
    }
}
