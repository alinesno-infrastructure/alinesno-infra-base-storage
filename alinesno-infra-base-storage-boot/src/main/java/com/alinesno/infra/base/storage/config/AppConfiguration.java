package com.alinesno.infra.base.storage.config;

import com.alinesno.infra.base.storage.initialize.IStorageInitService;
import com.alinesno.infra.common.extend.datasource.enable.EnableInfraDataScope;
import com.alinesno.infra.common.facade.enable.EnableActable;
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import com.alinesno.infra.common.web.log.aspect.LogAspect;
import com.dtflys.forest.springboot.annotation.ForestScan;
import jakarta.servlet.MultipartConfigElement;
import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

/**
 * 统一配置中心
 */
@EnableActable
@EnableInfraSsoApi
@EnableInfraDataScope
@MapperScan({
        "com.alinesno.infra.base.storage.mapper" ,
        "com.alinesno.infra.base.storage.plugins.mapper"
})
@ForestScan({
        "com.alinesno.infra.common.web.adapter.base.consumer"
})
@EnableFileStorage
@Configuration
public class AppConfiguration implements CommandLineRunner {

    @Autowired
    private IStorageInitService storageInitService ;

    /**添加
     * 配置上传文件大小
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {

        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofGigabytes(1024L));
        factory.setMaxRequestSize(DataSize.ofGigabytes(1024L));

        return factory.createMultipartConfig();
    }

    @Bean
    public LogAspect getLogAspect(){
        return new LogAspect() ;
    }

    @Override
    public void run(String... args) throws Exception {
        storageInitService.storageCatalog();
    }
}
