package com.alinesno.infra.base.storage.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName("storage_file_history")
public class StorageHistoryFileEntity extends InfraBaseEntity {

    @TableField("dfs_group_name")
    private String dfsGroupName;

    @TableField("download_num")
    private Integer downloadNum;

    @TableField("download_pwd")
    private String downloadPwd;

    @TableField("expiration_date")
    private Date expirationDate;

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

    @TableField("cloud_file_name")
    private String cloudFileName;

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
     * 文件源
     */
    private String filesource;
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
     * 链接地址
     */
    @TableField("url_alioss")
    private String urlOss;

    @TableField("file_bucket")
    private String bucket;

    @TableField("file_md5")
    private String fileMd5;

    /**
     * 接口密钥
     */
    @TableField("api_key")
    private String apiKey;

    public String getDfsGroupName() {
        return dfsGroupName;
    }

    public void setDfsGroupName(String dfsGroupName) {
        this.dfsGroupName = dfsGroupName;
    }

    public Integer getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(Integer downloadNum) {
        this.downloadNum = downloadNum;
    }

    public String getDownloadPwd() {
        return downloadPwd;
    }

    public void setDownloadPwd(String downloadPwd) {
        this.downloadPwd = downloadPwd;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

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

    public String getCloudFileName() {
        return cloudFileName;
    }

    public void setCloudFileName(String cloudFileName) {
        this.cloudFileName = cloudFileName;
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

    public String getFilesource() {
        return filesource;
    }

    public void setFilesource(String filesource) {
        this.filesource = filesource;
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

    public String getUrlOss() {
        return urlOss;
    }

    public void setUrlOss(String urlOss) {
        this.urlOss = urlOss;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
