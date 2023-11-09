package com.alinesno.infra.base.storage.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("storage_file")
@Data
public class StorageFileEntity extends InfraBaseEntity {

    /**
     * 文件扩展名
     */
    @TableField("file_ext")
	@ColumnType(length=4)
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
	@ColumnType(length=255)
	@ColumnComment("接口密钥")
    private String apiKey;

    /**
     * 原始文件名
     */
    @TableField("originalFilename")
	@ColumnType(length=255)
	@ColumnComment("原始文件名")
    private String originalFilename;

    /**
     * 基础路径
     */
    @TableField("basePath")
	@ColumnType(length=255)
	@ColumnComment("基础路径")
    private String basePath;

    /**
     * 路径
     */
    @TableField("path")
	@ColumnType(length=255)
	@ColumnComment("路径")
    private String path;

    /**
     * 扩展名
     */
    @TableField("ext")
	@ColumnType(length=255)
	@ColumnComment("扩展名")
    private String ext;

    /**
     * 内容类型
     */
    @TableField("contentType")
	@ColumnType(length=255)
	@ColumnComment("内容类型")
    private String contentType;

    /**
     * 平台
     */
    @TableField("platform")
	@ColumnType(length=255)
	@ColumnComment("平台")
    private String platform;

    /**
     * 缩略图URL
     */
    @TableField("thUrl")
	@ColumnType(length=255)
	@ColumnComment("缩略图URL")
    private String thUrl;

    /**
     * 缩略图文件名
     */
    @TableField("thFilename")
	@ColumnType(length=255)
	@ColumnComment("缩略图文件名")
    private String thFilename;

    /**
     * 缩略图大小
     */
    @TableField("thSize")
	@ColumnType(length=255)
	@ColumnComment("缩略图大小")
    private Long thSize;

    /**
     * 缩略图内容类型
     */
    @TableField("thContentType")
	@ColumnType(length=50)
	@ColumnComment("缩略图内容类型")
    private String thContentType;

    /**
     * 对象ID
     */
    @TableField("objectId")
	@ColumnType(length=24)
	@ColumnComment("对象ID")
    private String objectId;

    /**
     * 对象类型
     */
    @TableField("objectType")
	@ColumnType(length=50)
	@ColumnComment("对象类型")
    private String objectType;

    /**
     * 属性
     */
    @TableField("attr")
	@ColumnType(length=255)
	@ColumnComment("属性")
    private String attr;

    /**
     * 文件ACL
     */
    @TableField("fileAcl")
	@ColumnType(length=20)
	@ColumnComment("文件ACL")
    private String fileAcl;

    /**
     * 缩略图文件ACL
     */
    @TableField("thFileAcl")
	@ColumnType(length=255)
	@ColumnComment("缩略图文件ACL")
    private String thFileAcl;
}
