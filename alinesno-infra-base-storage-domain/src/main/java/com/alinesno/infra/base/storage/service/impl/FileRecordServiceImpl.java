package com.alinesno.infra.base.storage.service.impl;

import com.alinesno.infra.base.storage.entity.FileRecordEntity;
import com.alinesno.infra.base.storage.mapper.FileRecordMapper;
import com.alinesno.infra.base.storage.service.IFileRecordService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.enums.HasDeleteEnums;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FileRecordServiceImpl extends IBaseServiceImpl<FileRecordEntity , FileRecordMapper> implements IFileRecordService {

    @Override
    public void moveToRecycleBin(long fileId) {
        FileRecordEntity fileRecord = getById(fileId);
        if (fileRecord != null) {
            fileRecord.setHasDelete(HasDeleteEnums.LEGAL.value);
            fileRecord.setDeleteTime(new Date());
            updateById(fileRecord);
        }
    }

    @Override
    public void restoreFromRecycleBin(long fileId) {
        FileRecordEntity fileRecord = (FileRecordEntity) getById(fileId);
        if (fileRecord != null) {
            fileRecord.setHasDelete(HasDeleteEnums.LEGAL.value);
            fileRecord.setDeleteTime(null);
            updateById(fileRecord);
        }
    }

    @Override
    public void permanentDelete(long fileId) {
        removeById(fileId);
    }
}