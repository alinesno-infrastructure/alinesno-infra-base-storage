package com.alinesno.infra.base.fileshow.core.config;

import com.alinesno.infra.base.fileshow.core.service.CacheService;
import com.alinesno.infra.base.fileshow.core.utils.KkFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @auther: chenjh
 * @since: 2019/6/11 7:45
 */
@Slf4j
@Component
@ConditionalOnExpression("'${cache.clean.enabled:false}'.equals('true')")
public class SchedulerCleanConfig {

    private final CacheService cacheService;

    public SchedulerCleanConfig(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    private final String fileDir = ConfigConstants.getFileDir();

    //默认每晚3点执行一次
    @Scheduled(cron = "${cache.clean.cron:0 0 3 * * ?}")
    public void clean() {
        log.info("Cache clean start");
        cacheService.cleanCache();
        KkFileUtils.deleteDirectory(fileDir);
        log.info("Cache clean end");
    }
}
