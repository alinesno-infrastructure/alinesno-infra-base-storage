package com.alinesno.infra.base.storage;

import org.dromara.x.file.storage.spring.SpringFileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 集成一个Java开发示例工具
 * @author LuoAnDong
 * @since 2023年8月3日 上午6:23:43
 */
@SpringBootApplication
public class BaseStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseStorageApplication.class, args);
	}

}