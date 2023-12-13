package com.alinesno.infra.base.storage.service.impl;

import com.alinesno.infra.base.storage.entity.StorageRequestsEntity;
import com.alinesno.infra.base.storage.mapper.StorageRequestsMapper;
import com.alinesno.infra.base.storage.service.IStorageRequestsService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StorageRequestsServiceImpl extends IBaseServiceImpl<StorageRequestsEntity, StorageRequestsMapper> implements IStorageRequestsService {

}
