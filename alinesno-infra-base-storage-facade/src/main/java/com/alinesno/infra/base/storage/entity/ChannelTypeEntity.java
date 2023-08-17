package com.alinesno.infra.base.storage.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 渠道类型实体类
 * </p>
 * <p>
 * 该类继承自InfraBaseEntity，表示渠道类型的基本信息。
 * </p>
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("channel_type")
public class ChannelTypeEntity extends InfraBaseEntity {

    /**
     * 渠道代码
     */
    @TableField("channel_code")
    private String channelCode; // 使用[NoticeSendTypeEnum]枚举对象

    /**
     * 渠道名称
     */
    @TableField("channel_name")
    private String channelName;

    /**
     * 渠道描述
     */
    @TableField("channel_desc")
    private String channelDesc;

    /**
     * 所属策略ID
     */
    @TableField("strategy_id")
    private String strategyId;

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelDesc() {
        return channelDesc;
    }

    public void setChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

}
