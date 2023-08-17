package com.alinesno.infra.base.storage.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 存储应用实体类
 * </p>
 * <p>
 * 该类继承自InfraBaseEntity，表示存储应用的基本信息。
 * </p>
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("storage_application")
public class StorageApplicationEntity extends InfraBaseEntity {

    /**
     * 应用名称
     */
    @TableField("application_name")
    private String applicationName;

    /**
     * 应用代码
     */
    @TableField("application_code")
    private String applicationCode;

    /**
     * 应用值
     */
    private String token;

    /**
     * 最大文件长度
     */
    @TableField("max_file_size")
    private Integer maxFileSize;

    /**
     * 文件类型
     */
    @TableField("file_type")
    private String fileType;

    /**
     * 接口密钥
     */
    @TableField("api_key")
    private String apiKey;

    /**
     * 最大上传次数
     */
    @TableField("max_upload_count")
    private Integer maxUploadCount;

    /**
     * 最大下载次数
     */
    @TableField("max_download_count")
    private Integer maxDownloadCount;

    /**
     * 应用logo标识
     */
    private String banner;

    /**
     * 公司名称
     */
    @TableField("company_name")
    private String companyName;

    /**
     * 所开通渠道
     */
    @TableField("channel_ids")
    private String channelIds;

    /**
     * 应用码
     */
    @TableField("app_code")
    private String appCode;

    // 省略了getter和setter方法

    @Override
    public String toString() {
        return "StorageApplicationEntity{" +
                "applicationName='" + applicationName + '\'' +
                ", applicationCode='" + applicationCode + '\'' +
                ", token='" + token + '\'' +
                ", maxFileSize=" + maxFileSize +
                ", fileType='" + fileType + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", maxUploadCount=" + maxUploadCount +
                ", maxDownloadCount=" + maxDownloadCount +
                ", banner='" + banner + '\'' +
                ", companyName='" + companyName + '\'' +
                ", channelIds='" + channelIds + '\'' +
                ", appCode='" + appCode + '\'' +
                '}';
    }
}
