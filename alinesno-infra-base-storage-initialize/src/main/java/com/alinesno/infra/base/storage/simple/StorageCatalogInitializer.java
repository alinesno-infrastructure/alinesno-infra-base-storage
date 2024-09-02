package com.alinesno.infra.base.storage.simple;

import com.alinesno.infra.base.storage.entity.CatalogEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class StorageCatalogInitializer {

    public static List<CatalogEntity> initializeCatalogs() {

        AtomicLong id = new AtomicLong(1L);
        List<CatalogEntity> allEntities = new ArrayList<>();

        // 创建根节点
        CatalogEntity root = new CatalogEntity();
        root.setName("公共数据存储");
        root.setDescription("负责公司所有技术研究公共数据存储");
        root.setParentId(0L);
        allEntities.add(root);

        // 创建具体的存储分类
        String[] names = {
                "数据备份",
                "日志归档",
                "媒体资源",
                "文档管理",
                "代码仓库",
                "配置文件",
                "模型存储",
                "数据库快照",
        };

        String[] descriptions = {
                "定期自动备份重要数据",
                "集中管理和存储系统日志",
                "存储各类多媒体文件",
                "企业文档和知识库",
                "源代码版本控制系统",
                "系统配置文件版本管理",
                "机器学习模型的存储",
                "数据库状态快照",
        };

        for (int i = 0; i < names.length; i++) {
            CatalogEntity entity = createCatalogEntity(names[i], descriptions[i], root.getId(), root);
            allEntities.add(entity);
        }

        allEntities.forEach(entity -> {
            entity.setId(id.getAndIncrement());
        });

        return allEntities ;
    }

    private static CatalogEntity createCatalogEntity(String name, String desc, Long parentId, CatalogEntity parent) {
        CatalogEntity entity = new CatalogEntity();

        entity.setName(name);
        entity.setDescription(desc);
        entity.setParentId(parentId);

        if (parent != null) {
            parent.getChildren().add(entity);
        }

        return entity;
    }
}