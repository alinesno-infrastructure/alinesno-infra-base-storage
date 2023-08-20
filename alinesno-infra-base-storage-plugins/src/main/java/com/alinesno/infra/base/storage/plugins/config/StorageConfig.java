package com.alinesno.infra.base.storage.plugins.config;

import cn.xuyanwu.spring.file.storage.tika.ContentTypeDetect;
import cn.xuyanwu.spring.file.storage.tika.TikaFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 存储配置类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Component
public class StorageConfig {

    /**
     * 创建 TikaFactory Bean
     *
     * @return TikaFactory 实例
     */
    @Bean
    public TikaFactory tikaFactory() {
        return new DefaultTikaFactory();
    }

    /**
     * 创建 ContentTypeDetect Bean
     *
     * @param tikaFactory TikaFactory 实例
     * @return ContentTypeDetect 实例
     */
    @Bean
    public ContentTypeDetect contentTypeDetect(TikaFactory tikaFactory) {
        return new TikaContentTypeDetect(tikaFactory);
    }
}
