package com.alinesno.infra.base.storage.api.aspect;

import com.alinesno.infra.base.storage.entity.StorageRequestsEntity;
import com.alinesno.infra.base.storage.service.IStorageRequestsService;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Component
@Aspect
public class InterceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(InterceptionHandler.class) ;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IStorageRequestsService requestsService;

    @Before("@annotation(com.alinesno.infra.base.storage.api.aspect.Intercepted)")
    public void beforeInterception(JoinPoint joinPoint) {
        // 在方法执行前拦截并输出信息

        log.debug("Before Interception");

        saveRequest() ;
    }

    private void saveRequest() {

        // 获取请求的IP
        String ip = request.getRemoteAddr();
        log.debug("IP: " + ip);

        // 获取请求链接
        String url = request.getRequestURL().toString();
        log.debug("URL: " + url);

        // 获取请求参数
        Map<String, String[]> params = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : params.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            log.debug("Param: " + key + " = " + Arrays.toString(values));
        }

        StorageRequestsEntity r = new StorageRequestsEntity() ;

        r.setRequestIp(ip);
        r.setRequestUrl(url);

        requestsService.save(r) ;
    }

}
