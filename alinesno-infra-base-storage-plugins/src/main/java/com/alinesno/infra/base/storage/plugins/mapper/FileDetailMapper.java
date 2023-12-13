package com.alinesno.infra.base.storage.plugins.mapper;

import com.alinesno.infra.base.storage.plugins.entity.FileDetailEntity;
import com.alinesno.infra.common.facade.mapper.repository.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileDetailMapper extends IBaseMapper<FileDetailEntity> {
}
