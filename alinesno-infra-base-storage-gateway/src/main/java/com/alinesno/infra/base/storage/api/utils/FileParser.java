package com.alinesno.infra.base.storage.api.utils;

import com.alinesno.infra.base.fileshow.core.model.FileAttribute;
import com.alinesno.infra.base.fileshow.core.service.FilePreview;
import com.alinesno.infra.base.storage.entity.DocumentInfoEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * 文件解析工具类
 */
@Slf4j
public class FileParser {

    /**
     * 解析文件工具类
     * @param fileAttribute
     * @param filePreview
     * @return
     */
    public static DocumentInfoEntity parseFileAttribute(FileAttribute fileAttribute, FilePreview filePreview) {

        DocumentInfoEntity info = new DocumentInfoEntity() ;

        info.setFormat(fileAttribute.getSuffix());
        info.setTitle(fileAttribute.getName());
        info.setUrl(fileAttribute.getUrl());
        info.setViewCount(1);
        info.setHasPublic(1);

        return info ;
    }

}
