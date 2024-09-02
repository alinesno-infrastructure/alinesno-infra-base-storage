package com.alinesno.infra.base.storage.service;

import com.alinesno.infra.base.storage.entity.FileRecordEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * 文件记录服务接口
 * 该接口扩展了通用服务接口(IService)针对FileRecord实体，提供了文件记录的业务操作方法
 */
public interface IFileRecordService extends IBaseService<FileRecordEntity> {

    /**
     * 将文件移动到回收站
     * 此方法允许将一个文件记录标记为已删除，但保留在数据库中，逻辑删除
     *
     * @param fileId 文件记录的唯一标识
     */
    void moveToRecycleBin(long fileId);

    /**
     * 从回收站恢复文件
     * 标记为已删除的文件记录可以通过此方法恢复
     *
     * @param fileId 文件记录的唯一标识
     */
    void restoreFromRecycleBin(long fileId);

    /**
     * 永久删除文件记录
     * 此方法将从数据库中物理删除文件记录，操作不可逆
     *
     * @param fileId 文件记录的唯一标识
     */
    void permanentDelete(long fileId);
}
