package com.alinesno.infra.base.storage.config;

import com.alinesno.infra.common.facade.enable.EnableActable;
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 统一配置中心
 */
@EnableActable
@EnableInfraSsoApi
@MapperScan({"com.alinesno.infra.base.storage.mapper" , "com.alinesno.infra.base.storage.plugins.mapper"})
@EnableFileStorage
@Configuration
public class AppConfiguration {

}
