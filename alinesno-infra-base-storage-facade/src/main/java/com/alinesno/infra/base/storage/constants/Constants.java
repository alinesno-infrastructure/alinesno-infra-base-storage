package com.alinesno.infra.base.storage.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件断点续传常量表
 * <p>
 * 该接口定义了文件断点续传相关的常量。
 * </p>
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface Constants {

    /**
     * 异常信息统一头信息
     * <p>
     * 非常遗憾的通知您，程序发生了异常。
     * </p>
     */
    public static final String Exception_Head = "上传信息异常.";

    /**
     * 缓存键值
     */
    public static final Map<Class<?>, String> cacheKeyMap = new HashMap<>();

    /**
     * 保存文件所在路径的key，eg.FILE_MD5:1243jkalsjflkwaejklgjawe
     */
    public static final String FILE_MD5_KEY = "FILE_MD5:";

    /**
     * 保存上传文件的状态
     */
    public static final String FILE_UPLOAD_STATUS = "FILE_UPLOAD_STATUS";

    /**
     * conf存放的位置
     */
    public static final String FILE_UPLOAD_CONF = "FILE_UPLOAD_CONF";

    /**
     * 本地缓存路径
     */
    public static final String FILE_UPLOAD_URL = "FILE_UPLOAD_URL";
}
