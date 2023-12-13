package com.alinesno.infra.base.storage.plugins;

import cn.hutool.core.bean.BeanUtil;
import com.alinesno.infra.base.storage.api.dto.InfraFileInfoDto;
import com.alinesno.infra.base.storage.plugins.entity.FileDetailEntity;
import com.alinesno.infra.base.storage.plugins.service.FileDetailService;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.dromara.x.file.storage.core.ProgressListener;
import org.dromara.x.file.storage.core.platform.FileStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

   @Autowired
    private FileDetailService fileDetailService ;

    @Override
    public AjaxResult upload(MultipartFile file, String platform) {

        handlePlatform(platform) ;

        FileInfo info = fileStorageService
                .of(file)
                .setPlatform(platform)    //使用指定的存储平台
                .upload() ;

        return AjaxResult.success("操作成功." , info.getId());
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
    public byte[] download(String storageId) {

        FileInfo fileInfo = getById(storageId) ;

        return fileStorageService.download(fileInfo).setProgressMonitor(new ProgressListener() {
            @Override
            public void start() {
                System.out.println("下载开始");
            }

            @Override
            public void progress(long progressSize,long allSize) {
                System.out.println("已下载 " + progressSize + " 总大小" + allSize);
            }

            @Override
            public void finish() {
                System.out.println("下载结束");
            }
        }).bytes() ;

    }

    @Override
    public InfraFileInfoDto getFileInfo(String storageId) {

        InfraFileInfoDto infoDto = new InfraFileInfoDto() ;
        FileInfo fileInfo = getById(storageId) ;

        BeanUtils.copyProperties(fileInfo, infoDto);

        return infoDto ;
    }

    @Override
    public String presignedUrl(String storageId) {
        return null;
    }

    public FileInfo getById(String id) {
        FileDetailEntity detail = fileDetailService.getOne(new LambdaQueryWrapper<FileDetailEntity>().eq(FileDetailEntity::getId,id));
        FileInfo info = BeanUtil.copyProperties(detail,FileInfo.class,"metadata","userMetadata","thMetadata","thUserMetadata","attr");

        try {
            //这是手动获取数据库中的 json 字符串 并转成 元数据，方便使用
            info.setMetadata(fileDetailService.jsonToMetadata(detail.getMetadata()));
            info.setUserMetadata(fileDetailService.jsonToMetadata(detail.getUserMetadata()));
            info.setThMetadata(fileDetailService.jsonToMetadata(detail.getThMetadata()));
            info.setThUserMetadata(fileDetailService.jsonToMetadata(detail.getThUserMetadata()));

            //这是手动获取数据库中的 json 字符串 并转成 附加属性字典，方便使用
            info.setAttr(fileDetailService.jsonToDict(detail.getAttr()));
        }catch (Exception e){
            log.error("转换json异常:{}" , e.getMessage());
        }

        return info;
    }
}
