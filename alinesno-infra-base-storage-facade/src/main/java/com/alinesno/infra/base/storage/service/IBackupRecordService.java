package com.alinesno.infra.base.storage.service;

import com.alinesno.infra.base.storage.entity.BackupRecordEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * 备份记录服务接口
 * 该接口继承了基础服务接口IBaseService，用于对备份记录实体(BackupRecordEntity)进行CRUD操作
 */
public interface IBackupRecordService extends IBaseService<BackupRecordEntity> {

    /**
     * 创建一个新的备份记录
     * 该方法用于初始化并保存一个新的备份记录实体，记录备份的相关信息
     */
    void createBackup();
}
