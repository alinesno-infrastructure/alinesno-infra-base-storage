package com.alinesno.infra.base.storage.mapper;

import com.alinesno.infra.base.storage.entity.StorageRequestsEntity;
import com.alinesno.infra.common.facade.mapper.repository.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageRequestsMapper extends IBaseMapper<StorageRequestsEntity> {
}
