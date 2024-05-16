package com.alinesno.infra.base.storage.service.impl;

import com.alinesno.infra.base.storage.entity.DocumentTypeEntity;
import com.alinesno.infra.base.storage.enums.DocumentTypeEnum;
import com.alinesno.infra.base.storage.mapper.DocumentTypeMapper;
import com.alinesno.infra.base.storage.service.IDocumentTypeService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LuoXiaoDong
 * @version 1.0.0
 */
@Slf4j
@Service
public class DocumentTypeServiceImpl extends IBaseServiceImpl<DocumentTypeEntity, DocumentTypeMapper> implements IDocumentTypeService {

    @Override
    public boolean isOpenType(String suffix) {

        LambdaQueryWrapper<DocumentTypeEntity> wrapper = new LambdaQueryWrapper<>() ;
        wrapper.eq(DocumentTypeEntity::getIsOpen , 1)
                .eq(DocumentTypeEntity::getTypeName, suffix.toUpperCase()) ;

        long count = count(wrapper) ;

        return count > 0 ;
    }

    @Override
    public void initDocumentType(long userId) {

        List<DocumentTypeEntity> documentTypes = new ArrayList<>();

        for(DocumentTypeEnum type : DocumentTypeEnum.getAllDocumentTypes()){

            DocumentTypeEntity typeE = new DocumentTypeEntity(
                    type.getIcon(),
                    type.getName(),
                    type.getDesc(), true, 100, false) ;

            typeE.setOperatorId(userId);

            documentTypes.add(typeE) ;
        }

        this.remove(new LambdaQueryWrapper<DocumentTypeEntity>()
                .eq(DocumentTypeEntity::getOperatorId, userId)
                .in(DocumentTypeEntity::getTypeName , DocumentTypeEnum.getAllNames())) ;

        saveBatch(documentTypes) ;
    }
}
