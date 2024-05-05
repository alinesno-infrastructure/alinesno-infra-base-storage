package com.alinesno.infra.base.storage.service;

import com.alinesno.infra.base.storage.api.TreeSelectDto;
import com.alinesno.infra.base.storage.entity.CatalogEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.List;

/**
 * Prompt指令类型Service接口
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface ICatalogService extends IBaseService<CatalogEntity> {

    /**
     * 查询出指令类型列表
     * @param promptCatalog
     * @return
     */
    List<CatalogEntity> selectCatalogList(CatalogEntity promptCatalog);

    /**
     * 保存用户类型
     * @param entity
     */
    void insertCatalog(CatalogEntity entity);

    /**
     * 查询类型列表树
     * @return
     */
    List<TreeSelectDto> selectCatalogTreeList();
}