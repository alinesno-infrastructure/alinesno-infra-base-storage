package com.alinesno.infra.base.storage.service;

import com.alinesno.infra.base.storage.entity.StorageProjectEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 *
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface IStorageProjectService extends IBaseService<StorageProjectEntity> {

    /**
     * 初始化应用
     * @param userId
     */
    void initDefaultApp(long userId);

}
