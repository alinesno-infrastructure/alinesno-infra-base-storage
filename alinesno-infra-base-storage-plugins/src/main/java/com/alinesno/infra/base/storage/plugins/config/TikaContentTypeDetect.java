package com.alinesno.infra.base.storage.plugins.config;


import org.dromara.x.file.storage.core.tika.ContentTypeDetect;
import org.dromara.x.file.storage.core.tika.TikaFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Tika 内容类型检测类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class TikaContentTypeDetect implements ContentTypeDetect {

    private TikaFactory tikaFactory;

    /**
     * 获取 TikaFactory 实例
     *
     * @return TikaFactory 实例
     */
    public TikaFactory getTikaFactory() {
        return tikaFactory;
    }

    public TikaContentTypeDetect() {
    }

    /**
     * 使用指定的 TikaFactory 实例创建 TikaContentTypeDetect 对象
     *
     * @param tikaFactory TikaFactory 实例
     */
    public TikaContentTypeDetect(TikaFactory tikaFactory) {
        this.tikaFactory = tikaFactory;
    }

    /**
     * 设置 TikaFactory 实例
     *
     * @param tikaFactory TikaFactory 实例
     */
    public void setTikaFactory(TikaFactory tikaFactory) {
        this.tikaFactory = tikaFactory;
    }

    @Override
    public String detect(File file) throws IOException {
        return tikaFactory.getTika().detect(file);
    }

    @Override
    public String detect(byte[] bytes) {
        return tikaFactory.getTika().detect(bytes);
    }

    @Override
    public String detect(byte[] bytes, String filename) {
        return tikaFactory.getTika().detect(bytes, filename);
    }

    @Override
    public String detect(InputStream in, String filename) throws IOException {
        return tikaFactory.getTika().detect(in, filename);
    }
}
