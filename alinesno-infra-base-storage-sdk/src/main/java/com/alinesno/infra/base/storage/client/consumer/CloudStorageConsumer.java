package com.alinesno.infra.base.storage.client.consumer;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.dtflys.forest.annotation.*;
import com.dtflys.forest.callback.OnProgress;

import java.io.File;

/**
 * 云文件存储上传接口
 */
@BaseRequest(baseURL = "#{alinesno.infra.storage.host}" ,
        connectTimeout = 30*1000)
public interface CloudStorageConsumer {

    /**
     * 上传文件到云存储
     * @param file 要上传的文件
     * @param platform 平台标识
     * @param onProgress 上传进度回调
     * @return 上传结果
     */
    @Post(url = "/api/base/storage/upload",
            connectTimeout = 60*1000 ,
            contentType = "multipart/form-data")
    AjaxResult upload(@DataFile("file") File file, @Body("platform") String platform, OnProgress onProgress) ;

    /**
     * 从云存储下载文件
     * @param storageId 云存储文件ID
     * @param onProgress 下载进度回调
     * @return 下载的文件字节数组
     */
    @Get(url = "/api/base/storage/download",
            connectTimeout = 60*1000)
    byte[] download(@Query("storageId") String storageId, OnProgress onProgress) ;

}
