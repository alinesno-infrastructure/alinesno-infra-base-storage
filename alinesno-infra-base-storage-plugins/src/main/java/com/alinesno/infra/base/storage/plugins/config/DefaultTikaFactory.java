package com.alinesno.infra.base.storage.plugins.config;

import cn.xuyanwu.spring.file.storage.tika.TikaFactory;
import org.apache.tika.Tika;

/**
 * 默认的 Tika 工厂类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class DefaultTikaFactory implements TikaFactory {
    private volatile Tika tika;

    @Override
    public Tika getTika() {
        if (tika == null) {
            synchronized (this) {
                if (tika == null) {
                    tika = new Tika();
                }
            }
        }
        return tika;
    }
}
