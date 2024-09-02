package com.alinesno.infra.base.storage.api;

import com.alinesno.infra.common.facade.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p>
 * 存储文件实体类
 * </p>
 * <p>
 * 该实体类用于存储文件的相关信息，包括DFS组名、下载次数、下载密码、过期日期、文件扩展名、文件标识、文件名称、云存储文件名称、文件长度、文件URL、文件源、是否公开、保存类型、阿里云链接、本地磁盘链接、本地磁盘地址、FastDFS链接、PaxosSURLRe链接、七牛链接、文件bucket、文件MD5、接口密钥、URLBFS和URLMongoDB等。
 * </p>
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StorageFileDto extends BaseDto {

    private String icon ;
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
    private String metadata;
    private String userMetadata;
    private String thMetadata;
    private String thUserMetadata;
    private String attr;
    private String fileAcl;
    private String thFileAcl;
    private Date createTime;
}
