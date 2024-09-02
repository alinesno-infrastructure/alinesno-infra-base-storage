package com.alinesno.infra.base.storage.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("storage_file_history")
@Data
public class StorageFileHistoryEntity extends InfraBaseEntity {

    /**
     * 文件扩展名
     */
    @TableField("file_ext")
	@ColumnType(length=50)
	@ColumnComment("文件扩展名")
    private String fileExt;

    /**
     * 文件标识
     */
    @TableField("file_flag")
	@ColumnType(length=1)
	@ColumnComment("文件标识")
    private String fileFlag;

    /**
     * 文件名称
     */
    @TableField("file_name")
	@ColumnType(length=255)
	@ColumnComment("文件名称")
    private String fileName;

    /**
     * 文件长度
     */
    @TableField("file_size")
	@ColumnType(length=4)
	@ColumnComment("文件长度")
    private long fileSize;

    /**
     * 地址链接
     */
    @TableField("file_url")
	@ColumnType(length=255)
	@ColumnComment("地址链接")
    private String fileUrl;

    /**
     * 是否公开
     */
    @TableField("is_public")
	@ColumnType(length=1)
	@ColumnComment("是否公开")
    private String isPublic;

    /**
     * 保存类型
     */
    @TableField("save_type")
	@ColumnType(length=1)
	@ColumnComment("保存类型")
    private String saveType;

    /**
     * 接口密钥
     */
    @TableField("api_key")
	@ColumnType(length=32)
	@ColumnComment("接口密钥")
    private String apiKey;

    /**
     * 原始文件名
     */
    @TableField(value = "originalFilename")
	@ColumnType(length=255)
	@ColumnComment("原始文件名")
    private String originalFilename;

    /**
     * 基础路径
     */
    @TableField(value = "basePath")
	@ColumnType(length=255)
	@ColumnComment("基础路径")
    private String basePath;

    /**
     * 路径
     */
    @TableField(value = "path")
	@ColumnType(length=255)
	@ColumnComment("路径")
    private String path;

    /**
     * 文件扩展名
     */
    @TableField(value = "ext")
	@ColumnType(length=255)
	@ColumnComment("文件扩展名")
    private String ext;

    /**
     * 内容类型
     */
    @TableField(value = "contentType")
	@ColumnType(length=255)
	@ColumnComment("内容类型")
    private String contentType;

    /**
     * 平台
     */
    @TableField(value = "platform")
	@ColumnType(length=50)
	@ColumnComment("平台")
    private String platform;

    /**
     * 缩略图URL
     */
    @TableField(value = "thUrl")
	@ColumnType(length=255)
	@ColumnComment("缩略图URL")
    private String thUrl;

    /**
     * 缩略图文件名
     */
    @TableField(value = "thFilename")
	@ColumnType(length=255)
	@ColumnComment("缩略图文件名")
    private String thFilename;

    /**
     * 缩略图大小
     */
    @TableField(value = "thSize")
	@ColumnType(length=255)
	@ColumnComment("缩略图大小")
    private Long thSize;

    /**
     * 缩略图内容类型
     */
    @TableField(value = "thContentType")
	@ColumnType(length=50)
	@ColumnComment("缩略图内容类型")
    private String thContentType;

    /**
     * 对象ID
     */
    @TableField(value = "objectId")
	@ColumnType(length=24)
	@ColumnComment("对象ID")
    private String objectId;

    /**
     * 对象类型
     */
    @TableField(value = "objectType")
	@ColumnType(length=20)
	@ColumnComment("对象类型")
    private String objectType;

    /**
     * 属性
     */
    @TableField(value = "attr")
	@ColumnType(length=255)
	@ColumnComment("属性")
    private String attr;

    /**
     * 文件ACL
     */
    @TableField(value = "fileAcl")
	@ColumnType(length=50)
	@ColumnComment("文件ACL")
    private String fileAcl;

    /**
     * 缩略图文件ACL
     */
    @TableField(value = "thFileAcl")
	@ColumnType(length=255)
	@ColumnComment("缩略图文件ACL")
    private String thFileAcl;
}
