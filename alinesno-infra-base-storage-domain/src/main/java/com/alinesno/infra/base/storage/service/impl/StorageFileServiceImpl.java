package com.alinesno.infra.base.storage.service.impl;

import com.alinesno.infra.base.storage.entity.StorageFileEntity;
import com.alinesno.infra.base.storage.mapper.StorageFileMapper;
import com.alinesno.infra.base.storage.service.IStorageFileService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StorageFileServiceImpl extends IBaseServiceImpl<StorageFileEntity, StorageFileMapper> implements IStorageFileService {

    private static final Logger log = LoggerFactory.getLogger(StorageFileServiceImpl.class) ;

}
