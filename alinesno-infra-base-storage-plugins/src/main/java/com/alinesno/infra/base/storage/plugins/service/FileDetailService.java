package com.alinesno.infra.base.storage.plugins.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import cn.xuyanwu.spring.file.storage.FileInfo;
import cn.xuyanwu.spring.file.storage.recorder.FileRecorder;
import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.base.storage.entity.StorageFileEntity;
import com.alinesno.infra.base.storage.entity.StorageFileHistoryEntity;
import com.alinesno.infra.base.storage.service.IStorageFileService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.javassist.compiler.ast.FieldDecl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用来将文件上传记录保存到数据库
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Service
public class FileDetailService implements FileRecorder {

   private static final Logger log = LoggerFactory.getLogger(FileDetailService.class) ;

   @Autowired
   private IStorageFileService storageFileService ;

    /**
     * 保存文件信息到数据库
     */
    @Override
    public boolean save(FileInfo info) {

        log.debug("info = " + info.toString());

        StorageFileEntity e = new StorageFileEntity() ;
        BeanUtils.copyProperties(info , e);

        e.setFileUrl(info.getUrl());
        e.setFileName(info.getFilename());
        e.setFileSize(info.getSize());
        e.setSaveType(info.getExt());
        e.setAddTime(info.getCreateTime());

        //这是手动获 取附加属性字典 并转成 json 字符串，方便存储在数据库中
        if (info.getAttr() != null) {
            e.setAttr(JSONObject.toJSONString(info.getAttr())) ;
        }

        boolean b = storageFileService.save(e);
        if (b) {
            info.setId(e.getId().toString());
        }
        return b ;
    }

   /**
     * 根据 url 查询文件信息
     */
    @Override
    public FileInfo getByUrl(String url) {
        log.debug("getByUrl url = " + url);

        LambdaQueryWrapper<StorageFileEntity> queryWrapper = new LambdaQueryWrapper<>() ;
        queryWrapper.eq(StorageFileEntity::getFileUrl, url) ;

        StorageFileEntity e = storageFileService.getOne(queryWrapper) ;

        return BeanUtil.copyProperties(e,FileInfo.class,"attr");
    }

    @Override
    public boolean delete(String url) {
        log.debug("delete url = " + url);
        return storageFileService.remove(new LambdaQueryWrapper<StorageFileEntity>()
                .eq(StorageFileEntity::getFileUrl,url));
    }

}
