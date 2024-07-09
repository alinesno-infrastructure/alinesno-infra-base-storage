package com.alinesno.infra.base.fileshow.core.model;

import com.alinesno.infra.base.fileshow.core.config.ConfigConstants;
import lombok.Data;

/**
 * Created by kl on 2018/1/17.
 * Content :
 */
@Data
public class FileAttribute {

    private FileType type;
    private String suffix;
    private String name;
    private String url;
    private boolean isCompressFile = false;
    private String compressFileKey;
    private String filePassword;
    private boolean usePasswordCache;
    private String officePreviewType = ConfigConstants.getOfficePreviewType();
    private String tifPreviewType;
    private Boolean skipDownLoad = false;
    private Boolean forceUpdatedCache = false;
    private String cacheName;
    private String outFilePath;
    private String originFilePath;
    private String cacheListName;
    private boolean isHtmlView = false;

    /**
     * 代理请求到文件服务器的认证请求头，格式如下：
     * {“username”:"test","password":"test"}
     * 请求文件服务器时，会将 json 直接塞到请求头里
     */
    private String kkProxyAuthorization;

    public FileAttribute() {
    }

    public FileAttribute(FileType type, String suffix, String name, String url) {
        this.type = type;
        this.suffix = suffix;
        this.name = name;
        this.url = url;
    }

    public FileAttribute(FileType type, String suffix, String name, String url, String officePreviewType) {
        this.type = type;
        this.suffix = suffix;
        this.name = name;
        this.url = url;
        this.officePreviewType = officePreviewType;
    }

    public boolean forceUpdatedCache() {
        return forceUpdatedCache ;
    }
}
