package com.alinesno.infra.base.storage.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("backup_record")
public class BackupRecordEntity extends InfraBaseEntity {

    @TableField("backup_time")
    @ColumnComment("备份时间")
    @ColumnType(length=19)
    private LocalDateTime backupTime;

    @TableField("backup_path")
    @ColumnComment("备份路径")
    @ColumnType(length=128)
    private String backupPath;

}