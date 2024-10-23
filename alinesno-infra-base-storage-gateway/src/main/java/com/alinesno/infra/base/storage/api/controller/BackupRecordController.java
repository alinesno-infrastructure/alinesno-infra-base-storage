package com.alinesno.infra.base.storage.api.controller;

import com.alinesno.infra.base.storage.entity.BackupRecordEntity;
import com.alinesno.infra.base.storage.service.IBackupRecordService;
import com.alinesno.infra.base.storage.service.IFileRecordService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.extend.datasource.annotation.DataPermissionScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/storage/backup")
public class BackupRecordController extends BaseController<BackupRecordEntity, IBackupRecordService> {

    @Autowired
    private IBackupRecordService backupRecordService;

    /**
     * 获取BusinessLogEntity的DataTables数据。
     *
     * @param request HttpServletRequest对象。
     * @param model Model对象。
     * @param page DatatablesPageBean对象。
     * @return 包含DataTables数据的TableDataInfo对象。
     */
    @DataPermissionScope
    @ResponseBody
    @PostMapping("/datatables")
    public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
        log.debug("page = {}", ToStringBuilder.reflectionToString(page));
        return this.toPage(model, this.getFeign(), page);
    }

    @Override
    public IBackupRecordService getFeign() {
        return this.backupRecordService;
    }

    @GetMapping("/manual")
    public AjaxResult manualBackup() {
        backupRecordService.createBackup();
        return AjaxResult.success("Backup created manually.");
    }

}