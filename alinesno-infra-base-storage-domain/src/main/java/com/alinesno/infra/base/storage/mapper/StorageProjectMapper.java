package com.alinesno.infra.base.storage.mapper;

import com.alinesno.infra.base.storage.entity.StorageProjectEntity;
import com.alinesno.infra.common.facade.mapper.repository.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageProjectMapper extends IBaseMapper<StorageProjectEntity> {
}
