package com.alinesno.infra.base.storage.plugins;

import cn.xuyanwu.spring.file.storage.FileInfo;
import cn.xuyanwu.spring.file.storage.FileStorageService;
import cn.xuyanwu.spring.file.storage.platform.FileStorage;
import com.alinesno.infra.base.storage.api.dto.InfraFileInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 父级文件存储服务实现类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Service
public class ParentFileStorageServiceImpl implements IParentFileStorageService {

    private static final Logger log = LoggerFactory.getLogger(ParentFileStorageServiceImpl.class) ;

    @Autowired
    private FileStorageService fileStorageService;//注入实列

    @Override
    public AjaxResult upload(MultipartFile file, String platform) {

        handlePlatform(platform) ;

        FileInfo info = fileStorageService
                .of(file)
                .setPlatform(platform)    //使用指定的存储平台
                .upload() ;

        return AjaxResult.success(info.getId());
    }

    @Override
    public AjaxResult uploadCallbackUrl(MultipartFile file, String platform) {
        handlePlatform(platform) ;

        FileInfo fileInfo = fileStorageService.of(file)
                .setPlatform(platform)    //使用指定的存储平台
                .putAttr("role","admin") //保存一些属性，可以在切面、保存上传记录、自定义存储平台等地方获取使用，不需要可以不写
                .upload();  //将文件上传到对应地方

        return AjaxResult.success(fileInfo.getUrl());
    }

    @Override
    public AjaxResult uploadImage(MultipartFile file, String platform) {
        handlePlatform(platform) ;

        FileInfo info = fileStorageService.of(file)
                .setPlatform(platform)    //使用指定的存储平台
                .image(img -> img.size(1000,1000))  //将图片大小调整到 1000*1000
                .thumbnail(th -> th.size(200,200))  //再生成一张 200*200 的缩略图
                .upload();

        return AjaxResult.success(info.getId());
    }

    @Override
    public AjaxResult uploadPlatform(MultipartFile file, String platform) {
        handlePlatform(platform) ;

        FileInfo info = fileStorageService.of(file)
                .setPlatform(platform)    //使用指定的存储平台
                .upload();

        return AjaxResult.success(info.getId());
    }


    private void handlePlatform(String platform) {
        //获得存储平台 List
        CopyOnWriteArrayList<FileStorage> list = fileStorageService.getFileStorageList();

        platform = fileStorageService.getDefaultPlatform();

        for(FileStorage s : list){
            if(s.getPlatform().equals(platform)){
                platform = s.getPlatform() ;
                break ;
            }
        }
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
