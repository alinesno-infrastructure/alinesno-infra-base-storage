package com.alinesno.infra.base.storage.api.dto;

import cn.hutool.core.lang.Dict;
import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * 重写了spring-file-storage的FileInfo，添加自定义和避免强依赖的问题
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Data
public class InfraFileInfoDto {

    private String id;
    private String url;
    private Long size;
    private String filename;
    private String originalFilename;
    private String basePath;
    private String path;
    private String ext;
    private String contentType;
    private String platform;
    private String thUrl;
    private String thFilename;
    private Long thSize;
    private String thContentType;
    private String objectId;
    private String objectType;
    private Map<String, String> metadata;
    private Map<String, String> userMetadata;
    private Map<String, String> thMetadata;
    private Map<String, String> thUserMetadata;
    private Dict attr;
    private Object fileAcl;
    private Object thFileAcl;
    private Date createTime;

}
