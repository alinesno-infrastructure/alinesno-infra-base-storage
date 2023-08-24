package com.alinesno.infra.base.storage;

import cn.xuyanwu.spring.file.storage.spring.EnableFileStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 集成一个Java开发示例工具
 * @author LuoAnDong
 * @since 2023年8月3日 上午6:23:43
 */
@EnableAspectJAutoProxy
@EnableFileStorage
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BaseStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseStorageApplication.class, args);
	}

}