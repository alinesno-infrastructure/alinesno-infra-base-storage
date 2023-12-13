package com.alinesno.infra.base.storage.mapper;

import com.alinesno.infra.base.storage.entity.StorageApplicationEntity;
import com.alinesno.infra.common.facade.mapper.repository.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageApplicationMapper extends IBaseMapper<StorageApplicationEntity> {
}
