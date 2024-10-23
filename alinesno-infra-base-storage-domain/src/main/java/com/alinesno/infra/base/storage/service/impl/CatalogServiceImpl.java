package com.alinesno.infra.base.storage.service.impl;

import com.alinesno.infra.base.storage.api.TreeSelectDto;
import com.alinesno.infra.base.storage.entity.CatalogEntity;
import com.alinesno.infra.base.storage.mapper.CatalogMapper;
import com.alinesno.infra.base.storage.service.ICatalogService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.core.utils.StringUtils;
import com.alinesno.infra.common.facade.datascope.PermissionQuery;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Prompt指令类型Service业务层处理
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
@Service
public class CatalogServiceImpl extends IBaseServiceImpl<CatalogEntity, CatalogMapper> implements ICatalogService {

    @Override
    public List<CatalogEntity> selectCatalogList(CatalogEntity promptCatalog, PermissionQuery query) {

        LambdaQueryWrapper<CatalogEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.setEntityClass(CatalogEntity.class) ;
        query.toWrapper(queryWrapper);

        List<CatalogEntity> list = list(queryWrapper) ;

        if(list == null || list.isEmpty()){

            list = new ArrayList<>() ;

            // 默认有一个选项是父类
            CatalogEntity parent = new CatalogEntity() ;
            parent.setName("父类对象");
            parent.setId(0L);

            list.add(parent) ;
        }

        return list ;

    }

    @Override
    public void insertCatalog(CatalogEntity entity) {

        CatalogEntity info = this.getById(entity.getParentId());
        if(info != null){
            entity.setAncestors(info.getAncestors() + "," + entity.getParentId());
        }

        this.save(entity) ;
    }

    @Override
    public List<TreeSelectDto> selectCatalogTreeList(PermissionQuery query) {

        LambdaQueryWrapper<CatalogEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.setEntityClass(CatalogEntity.class) ;
        query.toWrapper(queryWrapper);

        List<CatalogEntity> deptTrees = buildDeptTree(list(queryWrapper));
        return deptTrees.stream().map(TreeSelectDto::new).collect(Collectors.toList());
    }

    /**
     * 构建前端所需要树结构
     *
     * @param prompts 部门列表
     * @return 树结构列表
     */
    public List<CatalogEntity> buildDeptTree(List<CatalogEntity> prompts) {

        List<CatalogEntity> returnList = new ArrayList<>();
        List<Long> tempList = prompts.stream().map(CatalogEntity::getId).toList();

        for (CatalogEntity dept : prompts) {
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(dept.getParentId())) {
                recursionFn(prompts, dept);
                returnList.add(dept);
            }
        }

        if (returnList.isEmpty()) {
            returnList = prompts;
        }
        return returnList;
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<CatalogEntity> list, CatalogEntity t) {
        // 得到子节点列表
        List<CatalogEntity> childList = getChildList(list, t);
        t.setChildren(childList);
        for (CatalogEntity tChild : childList) {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<CatalogEntity> getChildList(List<CatalogEntity> list, CatalogEntity t) {
        List<CatalogEntity> tlist = new ArrayList<>();
        for (CatalogEntity n : list) {
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<CatalogEntity> list, CatalogEntity t) {
        return !getChildList(list, t).isEmpty();
    }
}
