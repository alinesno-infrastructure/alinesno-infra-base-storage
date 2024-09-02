package com.alinesno.infra.base.storage.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Table(name = "文件回收站")
@TableName("file_record")
public class FileRecordEntity extends InfraBaseEntity {

    @TableField("file_id")
    @ColumnComment("文件ID")
    @ColumnType(length=32)
    private long fileId; // 文件ID

    @TableField("file_name")
    @ColumnComment("文件名")
    @ColumnType(length=255)
    private String fileName; // 文件名

    @TableField("file_path")
    @ColumnComment("文件路径")
    @ColumnType(length=255)
    private String filePath; // 文件路径

}