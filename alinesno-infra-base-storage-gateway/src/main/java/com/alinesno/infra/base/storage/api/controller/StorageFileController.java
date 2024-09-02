package com.alinesno.infra.base.storage.api.controller;

import com.alinesno.infra.base.storage.api.StorageFileDto;
import com.alinesno.infra.base.storage.entity.StorageFileEntity;
import com.alinesno.infra.base.storage.enums.FileTypeEnum;
import com.alinesno.infra.base.storage.service.ICatalogService;
import com.alinesno.infra.base.storage.service.IStorageFileService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
@RequestMapping("/api/infra/base/storage/file")
public class StorageFileController extends BaseController<StorageFileEntity, IStorageFileService> {

    @Autowired
    private IStorageFileService service;

    @Autowired
    private ICatalogService catalogService ;

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
        TableDataInfo tableDataInfo = this.toPage(model, this.getFeign(), page);

        List<StorageFileEntity> list = (List<StorageFileEntity>) tableDataInfo.getRows();
        List<StorageFileDto> storageFileDtos = new ArrayList<>();

        if(list != null){
            for (StorageFileEntity storageFileEntity : list) {
                StorageFileDto storageFileDto = new StorageFileDto();
                BeanUtils.copyProperties(storageFileEntity, storageFileDto);

                storageFileDto.setIcon(FileTypeEnum.getIconByName(storageFileEntity.getExt()));
                storageFileDtos.add(storageFileDto);
            }
        }

        tableDataInfo.setRows(storageFileDtos);

        return tableDataInfo;
    }

    @GetMapping("/catalogTreeSelect")
    public AjaxResult catalogTreeSelect(){
        return AjaxResult.success("success" , catalogService.selectCatalogTreeList()) ;
    }

    @Override
    public IStorageFileService getFeign() {
        return this.service;
    }
}