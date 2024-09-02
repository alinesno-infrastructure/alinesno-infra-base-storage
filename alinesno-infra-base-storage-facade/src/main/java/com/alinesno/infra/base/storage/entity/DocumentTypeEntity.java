package com.alinesno.infra.base.storage.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 文档类型
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("document_type")
@NoArgsConstructor
public class DocumentTypeEntity extends InfraBaseEntity {

    /**
     * 类型名称
     */
    @ColumnType(length = 32)
    @ColumnComment("类型名称")
    @TableField
    private String typeName;

    /**
     * 类型描述
     */
    @ColumnType(length = 256)
    @ColumnComment("类型名称")
    @TableField
    private String typeDesc;

    /**
     * 图标
     */
    @ColumnType(length = 32)
    @ColumnComment("图标")
    @TableField
    private String icon;

    /**
     * 是否打开
     */
    @ColumnType(length = 1)
    @ColumnComment("是否打开")
    @TableField
    private Integer isOpen;

    /**
     * 请求次数
     */
    @ColumnType(length = 11)
    @ColumnComment("请求次数")
    @TableField
    private Integer requestCount;

    @ColumnType(length = 128)
    @ColumnComment("文件格式类型")
    @TableField
    private String fileType ;

    /**
     * 是否限流
     */
    @ColumnType(length = 1)
    @ColumnComment("是否限流")
    @TableField
    private Integer isRateLimited;

    public DocumentTypeEntity(String icon, String typeName, String typeDesc, boolean isOpen, int requestCount, boolean isRateLimited) {
        this.icon = icon;
        this.typeName = typeName;
        this.typeDesc = typeDesc;
        this.isOpen = isOpen?1:0;
        this.requestCount = requestCount;
        this.isRateLimited = isRateLimited?1:0;
    }

}
