package com.alinesno.infra.base.storage.service.impl;

import com.alinesno.infra.base.storage.entity.BackupRecordEntity;
import com.alinesno.infra.base.storage.mapper.BackupRecordMapper;
import com.alinesno.infra.base.storage.service.IBackupRecordService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@SuppressWarnings("ALL")
@Slf4j
@Service
public class BackupRecordServiceImpl extends IBaseServiceImpl<BackupRecordEntity,BackupRecordMapper> implements IBackupRecordService {

    @Scheduled(cron = "0 0 2 * * ?") // 每日凌晨2点执行
    public void createBackup() {
        try {
            // 创建备份文件夹
            Path backupDir = Paths.get("backups");
            Files.createDirectories(backupDir);

            // 当前日期时间作为备份文件名的一部分
            String timestamp = LocalDateTime.now().toString().replace(":", "-").replace(".", "-");
            Path backupFile = backupDir.resolve("backup-" + timestamp + ".zip");

            // 备份的目标文件夹
            Path targetDir = Paths.get("target/path/to/your/files");

            // 开始创建压缩文件
            try (ZipOutputStream zipOut = new ZipOutputStream(Files.newOutputStream(backupFile))) {
                Files.walk(targetDir)
                     .filter(path -> !Files.isDirectory(path))
                     .forEach(path -> {
                         ZipEntry zipEntry = new ZipEntry(targetDir.relativize(path).toString());
                         try {
                             zipOut.putNextEntry(zipEntry);
                             Files.copy(path, zipOut);
                             zipOut.closeEntry();
                         } catch (Exception e) {
                             log.error("Error creating backup: " + e.getMessage());
                         }
                     });
            }

            // 记录备份
            BackupRecordEntity record = new BackupRecordEntity();
            record.setBackupTime(LocalDateTime.now());
            record.setBackupPath(backupFile.toString());
            save(record);
        } catch (Exception e) {
            log.error(e.getMessage()) ;
        }
    }
}