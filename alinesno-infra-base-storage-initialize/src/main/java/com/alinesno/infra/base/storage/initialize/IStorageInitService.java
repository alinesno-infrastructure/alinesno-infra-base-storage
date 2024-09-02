package com.alinesno.infra.base.storage.initialize;

public interface IStorageInitService {

    /**
     * 初始化指令分类
     */
    void storageCatalog() ;

    /**
     * 初始化文档类型
     */
    void initDocumentType() ;

}
