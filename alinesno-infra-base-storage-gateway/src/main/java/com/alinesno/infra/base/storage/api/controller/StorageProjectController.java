package com.alinesno.infra.base.storage.api.controller;

import com.alinesno.infra.base.storage.api.UpdateDocumentTypeDto;
import com.alinesno.infra.base.storage.entity.StorageProjectEntity;
import com.alinesno.infra.base.storage.service.IStorageProjectService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 处理与BusinessLogEntity相关的请求的Controller。
 * 继承自BaseController类并实现IBusinessLogService接口。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/storage/project")
public class StorageProjectController extends BaseController<StorageProjectEntity, IStorageProjectService> {
    @Autowired
    private IStorageProjectService service;

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

        long userId = CurrentAccountJwt.getUserId();
        long count = service.count(new LambdaQueryWrapper<StorageProjectEntity>().eq(StorageProjectEntity::getOperatorId , userId));

        // 初始化默认应用
        if (count == 0) {
            service.initDefaultApp(userId);
        }

        return this.toPage(model, this.getFeign(), page);
    }

    // 更新项目文档类型
    @PostMapping("/updateDocumentType")
    public AjaxResult updateDocumentType(@RequestBody @Valid UpdateDocumentTypeDto dto) {
        return toAjax(service.updateDocumentType(dto));
    }


    @Override
    public IStorageProjectService getFeign() {
        return this.service;
    }
}