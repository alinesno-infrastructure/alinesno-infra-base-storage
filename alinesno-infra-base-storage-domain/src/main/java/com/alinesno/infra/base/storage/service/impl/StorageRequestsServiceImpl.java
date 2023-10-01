package com.alinesno.infra.base.storage.service.impl;

import com.alinesno.infra.base.storage.entity.StorageFileEntity;
import com.alinesno.infra.base.storage.entity.StorageRequestsEntity;
import com.alinesno.infra.base.storage.mapper.StorageRequestsMapper;
import com.alinesno.infra.base.storage.service.IStorageFileService;
import com.alinesno.infra.base.storage.service.IStorageRequestsService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StorageRequestsServiceImpl extends IBaseServiceImpl<StorageRequestsEntity, StorageRequestsMapper> implements IStorageRequestsService {

    private static final Logger log = LoggerFactory.getLogger(StorageFileServiceImpl.class) ;

}
