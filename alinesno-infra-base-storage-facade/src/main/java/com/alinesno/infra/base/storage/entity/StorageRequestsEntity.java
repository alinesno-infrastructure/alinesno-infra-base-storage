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
 * 存储请求记录实体类
 * </p>
 * <p>
 * 该实体类用于存储请求记录的相关信息，包括请求路径、保存路径、请求应用、请求信息、文件名称、请求IP、响应时间、请求用户、文件类型和请求用户名等。
 * </p>
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("storage_requests")
@Data
public class StorageRequestsEntity extends InfraBaseEntity {

    /**
     * 请求路径
     */
    @TableField("request_url")
	@ColumnType(length=255)
	@ColumnComment("请求路径")
    private String requestUrl;

    /**
     * 保存路径
     */
    @TableField("storage_url")
	@ColumnType(length=255)
	@ColumnComment("保存路径")
    private String storageUrl;

    /**
     * 请求应用
     */
    @TableField("request_application")
	@ColumnType(length=255)
	@ColumnComment("请求应用")
    private String requestApplication;

    /**
     * 请求信息
     */
    @TableField("agent")
	@ColumnType(length=255)
	@ColumnComment("请求信息")
    private String agent;

    /**
     * 文件名称
     */
    @TableField("filename")
	@ColumnType(length=255)
	@ColumnComment("文件名称")
    private String filename;

    /**
     * 请求IP
     */
    @TableField("request_ip")
	@ColumnType(length=15)
	@ColumnComment("请求IP")
    private String requestIp;

    /**
     * 响应时间
     */
    @TableField("response_time")
	@ColumnType(length=8)
	@ColumnComment("响应时间")
    private long responseTime;

    /**
     * 请求用户
     */
    @TableField("request_user_id")
	@ColumnType(length=50)
	@ColumnComment("请求用户")
    private String requestUserId;

    /**
     * 文件类型
     */
    @TableField("request_type")
	@ColumnType(length=10)
	@ColumnComment("文件类型")
    private String requestType;

    /**
     * 请求用户名
     */
    @TableField("request_username")
	@ColumnType(length=255)
	@ColumnComment("请求用户名")
    private String requestUsername;
}
