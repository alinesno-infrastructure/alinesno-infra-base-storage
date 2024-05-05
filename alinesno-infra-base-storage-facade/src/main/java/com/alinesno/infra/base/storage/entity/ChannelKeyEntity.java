package com.alinesno.infra.base.storage.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.annotation.TableComment;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 渠道密钥
 * @author luoxiaodong
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("channel_key")
@TableComment("渠道密钥")
public class ChannelKeyEntity extends BaseEntity {

    /**
     * 键名称
     */
    @ColumnType(length=64)
    @ColumnComment("键名称")
    @Excel(name = "键名称")
    @TableField("settings_name")
    private String settingsName;

    @ColumnType(length=64)
    @ColumnComment("键名称")
    @Excel(name = "渠道标识")
    @TableField("code")
    private String code ;

    /**
     * 键名称
     */
    @ColumnType(MySqlTypeConstant.TEXT)
    @ColumnComment("键名称")
    @Excel(name = "键值")
    @TableField("settings_key")
    private String settingsKey;

    /**
     * 是否当前使用
     */
    @ColumnType(length=1)
    @ColumnComment("是否当前使用")
    @TableField("是否当前使用")
    private int currentUse;

    /**
     * 使用描述
     */
    @ColumnType(length=128)
    @ColumnComment("使用描述")
    @Excel(name = "使用描述")
    @TableField("settings_desc")
    private String settingsDesc ;

}
