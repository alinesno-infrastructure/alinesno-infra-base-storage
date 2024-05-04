package com.alinesno.infra.base.storage.service.impl;

import com.alinesno.infra.base.storage.entity.StorageProjectEntity;
import com.alinesno.infra.base.storage.mapper.StorageProjectMapper;
import com.alinesno.infra.base.storage.service.IStorageProjectService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StorageProjectServiceImpl extends IBaseServiceImpl<StorageProjectEntity, StorageProjectMapper> implements IStorageProjectService {

}
