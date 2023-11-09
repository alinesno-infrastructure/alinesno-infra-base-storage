package com.alinesno.infra.base.storage.service.impl;

import com.alinesno.infra.base.storage.entity.StorageApplicationEntity;
import com.alinesno.infra.base.storage.entity.StorageFileEntity;
import com.alinesno.infra.base.storage.mapper.StorageApplicationMapper;
import com.alinesno.infra.base.storage.mapper.StorageFileMapper;
import com.alinesno.infra.base.storage.service.IStorageApplicationService;
import com.alinesno.infra.base.storage.service.IStorageFileService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StorageApplicationServiceImpl extends IBaseServiceImpl<StorageApplicationEntity, StorageApplicationMapper> implements IStorageApplicationService {

}
