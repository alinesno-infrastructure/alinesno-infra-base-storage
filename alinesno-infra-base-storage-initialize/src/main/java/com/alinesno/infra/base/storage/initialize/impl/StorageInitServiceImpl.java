package com.alinesno.infra.base.storage.initialize.impl;

import com.alinesno.infra.base.storage.initialize.IStorageInitService;
import com.alinesno.infra.base.storage.service.ICatalogService;
import com.alinesno.infra.base.storage.simple.StorageCatalogInitializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 默认的存储初始化实现类
 */
@Service
@Slf4j
public class StorageInitServiceImpl implements IStorageInitService {

    @Autowired
    private ICatalogService catalogService ;

    @Override
    public void storageCatalog() {
        catalogService.saveOrUpdateBatch(StorageCatalogInitializer.initializeCatalogs()) ;
    }

    @Override
    public void initDocumentType() {

    }

}
