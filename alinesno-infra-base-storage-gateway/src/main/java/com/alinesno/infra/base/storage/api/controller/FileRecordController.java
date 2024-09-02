package com.alinesno.infra.base.storage.api.controller;

import com.alinesno.infra.base.storage.entity.FileRecordEntity;
import com.alinesno.infra.base.storage.service.IChannelKeyService;
import com.alinesno.infra.base.storage.service.IFileRecordService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.enums.HasDeleteEnums;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/storage/fileRecord")
public class FileRecordController extends BaseController<FileRecordEntity, IFileRecordService> {

    @Autowired
    private IFileRecordService fileRecordService;

    /**
     * 获取BusinessLogEntity的DataTables数据。
     *
     * @param request HttpServletRequest对象。
     * @param model Model对象。
     * @param page DatatablesPageBean对象。
     * @return 包含DataTables数据的TableDataInfo对象。
     */
    @ResponseBody
    @PostMapping("/datatables")
    public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
        log.debug("page = {}", ToStringBuilder.reflectionToString(page));
        return this.toPage(model, this.getFeign(), page);
    }

    @Override
    public IFileRecordService getFeign() {
        return this.fileRecordService;
    }

    @PostMapping("/recycle")
    public AjaxResult moveToRecycleBin(@RequestParam long fileId) {
        fileRecordService.moveToRecycleBin(fileId);
        return ok() ;
    }

    @PostMapping("/restore")
    public AjaxResult restoreFromRecycleBin(@RequestParam long fileId) {
        fileRecordService.restoreFromRecycleBin(fileId);
        return ok() ;
    }

    @PostMapping("/permanent-delete")
    public AjaxResult permanentDelete(@RequestParam long fileId) {
        fileRecordService.permanentDelete(fileId);
        return ok() ;
    }

    @GetMapping("/recycle-bin")
    public List<FileRecordEntity> getRecycleBinFiles() {
        LambdaQueryWrapper<FileRecordEntity> queryWrapper = new LambdaQueryWrapper<FileRecordEntity>().eq(FileRecordEntity::getHasDelete, HasDeleteEnums.LEGAL.value) ;
        return fileRecordService.list(queryWrapper);
    }
}