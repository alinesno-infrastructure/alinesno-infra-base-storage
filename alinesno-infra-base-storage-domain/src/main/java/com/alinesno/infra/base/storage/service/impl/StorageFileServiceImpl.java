package com.alinesno.infra.base.storage.service.impl;

import com.alinesno.infra.base.storage.entity.StorageFileEntity;
import com.alinesno.infra.base.storage.mapper.StorageFileMapper;
import com.alinesno.infra.base.storage.service.IStorageFileService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StorageFileServiceImpl extends IBaseServiceImpl<StorageFileEntity, StorageFileMapper> implements IStorageFileService {

}
