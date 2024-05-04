package com.alinesno.infra.base.storage.client;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动扫描配置
 */
@Configuration
@ForestScan(basePackages = "com.alinesno.infra.base.storage.client.consumer;")
public class ConfigurationConsumer{

}