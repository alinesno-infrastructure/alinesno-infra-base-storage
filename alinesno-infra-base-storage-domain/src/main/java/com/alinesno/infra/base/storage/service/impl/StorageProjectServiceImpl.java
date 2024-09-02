package com.alinesno.infra.base.storage.service.impl;

import cn.hutool.json.JSONUtil;
import com.alinesno.infra.base.storage.api.UpdateDocumentTypeDto;
import com.alinesno.infra.base.storage.entity.DocumentTypeEntity;
import com.alinesno.infra.base.storage.entity.StorageProjectEntity;
import com.alinesno.infra.base.storage.enums.DocumentTypeEnum;
import com.alinesno.infra.base.storage.mapper.StorageProjectMapper;
import com.alinesno.infra.base.storage.service.IDocumentTypeService;
import com.alinesno.infra.base.storage.service.IStorageProjectService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqids.Sqids;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class StorageProjectServiceImpl extends IBaseServiceImpl<StorageProjectEntity, StorageProjectMapper> implements IStorageProjectService {

    private static final String DEFAULT_PROJECT_FIELD = "default" ;

    @Autowired
    private IDocumentTypeService documentTypeService ;

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

        List<DocumentTypeEntity> documentTypes = documentTypeService.initDocumentType(userId);
        List<String> ids = documentTypes.stream().map(DocumentTypeEntity::getId).toList()
                .stream().map(Object::toString).toList(); // fix:处理前端转换精度的问题

        project.setDocumentType(JSONUtil.toJsonStr(ids)) ;

        save(project) ;
    }

    @Override
    public int updateDocumentType(UpdateDocumentTypeDto dto) {
        StorageProjectEntity project = getById(Long.parseLong(dto.getProjectId()));
        if (project != null) {
            project.setDocumentType(JSONUtil.toJsonStr(dto.getDocumentIds()));
            updateById(project);
            return 1;
        }
        return 0;
    }
}
