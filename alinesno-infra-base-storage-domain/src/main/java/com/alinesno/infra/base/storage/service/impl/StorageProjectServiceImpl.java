package com.alinesno.infra.base.storage.service.impl;

import com.alinesno.infra.base.storage.entity.StorageProjectEntity;
import com.alinesno.infra.base.storage.enums.DocumentTypeEnum;
import com.alinesno.infra.base.storage.mapper.StorageProjectMapper;
import com.alinesno.infra.base.storage.service.IStorageProjectService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.sqids.Sqids;

import java.util.Arrays;

@Slf4j
@Service
public class StorageProjectServiceImpl extends IBaseServiceImpl<StorageProjectEntity, StorageProjectMapper> implements IStorageProjectService {

    private static final String DEFAULT_PROJECT_FIELD = "default" ;

    @Override
    public void initDefaultApp(long userId) {
        Sqids sqids=Sqids.builder().build();
        String code = sqids.encode(Arrays.asList(1L,2L,3L)); // "86Rf07"

        StorageProjectEntity project = new StorageProjectEntity() ;

        project.setOperatorId(userId);
        project.setFieldProp(DEFAULT_PROJECT_FIELD);

        project.setProjectName("默认存储应用");
        project.setProjectDesc("包含所有的上传存储权限，用于开发和验证场景");
        project.setProjectCode(code);
        project.setDocumentType(DocumentTypeEnum.getAllNameStr());

        save(project) ;
    }
}
