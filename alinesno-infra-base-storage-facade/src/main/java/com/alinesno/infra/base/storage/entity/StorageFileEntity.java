package com.alinesno.infra.base.storage.entity;

import java.util.Date;

import cn.hutool.core.lang.Dict;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName("storage_file")
public class StorageFileEntity extends InfraBaseEntity {

    /**
     * 文件扩展名
     */
    @TableField("file_ext")
    private String fileExt;

    /**
     * 文件标识
     */
    @TableField("file_flag")
    private String fileFlag;

    /**
     * 文件名称
     */
    @TableField("file_name")
    private String fileName;

    /**
     * 文件长度
     */
    @TableField("file_size")
    private long fileSize;

    /**
     * 地址链接
     */
    @TableField("file_url")
    private String fileUrl;

    /**
     * 是否公开
     */
    @TableField("is_public")
    private String isPublic;

    /**
     * 保存类型
     */
    @TableField("save_type")
    private String saveType;

    /**
     * 接口密钥
     */
    @TableField("api_key")
    private String apiKey;

    /**
     * 原始文件名
     */
    @TableField("originalFilename")
    private String originalFilename;

    /**
     * 基础路径
     */
    @TableField("basePath")
    private String basePath;

    /**
     * 路径
     */
    @TableField("path")
    private String path;

    /**
     * 扩展名
     */
    @TableField("ext")
    private String ext;

    /**
     * 内容类型
     */
    @TableField("contentType")
    private String contentType;

    /**
     * 平台
     */
    @TableField("platform")
    private String platform;

    /**
     * 缩略图URL
     */
    @TableField("thUrl")
    private String thUrl;

    /**
     * 缩略图文件名
     */
    @TableField("thFilename")
    private String thFilename;

    /**
     * 缩略图大小
     */
    @TableField("thSize")
    private Long thSize;

    /**
     * 缩略图内容类型
     */
    @TableField("thContentType")
    private String thContentType;

    /**
     * 对象ID
     */
    @TableField("objectId")
    private String objectId;

    /**
     * 对象类型
     */
    @TableField("objectType")
    private String objectType;

    /**
     * 属性
     */
    @TableField("attr")
    private String attr;

    /**
     * 文件ACL
     */
    @TableField("fileAcl")
    private Object fileAcl;

    /**
     * 缩略图文件ACL
     */
    @TableField("thFileAcl")
    private Object thFileAcl;


    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getFileFlag() {
        return fileFlag;
    }

    public void setFileFlag(String fileFlag) {
        this.fileFlag = fileFlag;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    public String getSaveType() {
        return saveType;
    }

    public void setSaveType(String saveType) {
        this.saveType = saveType;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getThUrl() {
        return thUrl;
    }

    public void setThUrl(String thUrl) {
        this.thUrl = thUrl;
    }

    public String getThFilename() {
        return thFilename;
    }

    public void setThFilename(String thFilename) {
        this.thFilename = thFilename;
    }

    public Long getThSize() {
        return thSize;
    }

    public void setThSize(Long thSize) {
        this.thSize = thSize;
    }

    public String getThContentType() {
        return thContentType;
    }

    public void setThContentType(String thContentType) {
        this.thContentType = thContentType;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public Object getFileAcl() {
        return fileAcl;
    }

    public void setFileAcl(Object fileAcl) {
        this.fileAcl = fileAcl;
    }

    public Object getThFileAcl() {
        return thFileAcl;
    }

    public void setThFileAcl(Object thFileAcl) {
        this.thFileAcl = thFileAcl;
    }
}
