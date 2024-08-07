package com.alinesno.infra.base.storage.core.service.impl;

import com.alinesno.infra.base.storage.core.model.FileAttribute;
import com.alinesno.infra.base.storage.core.model.ReturnResponse;
import com.alinesno.infra.base.storage.core.service.FileHandlerService;
import com.alinesno.infra.base.storage.core.service.FilePreview;
import com.alinesno.infra.base.storage.core.utils.DownloadUtils;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

/**
 * Created by kl on 2018/1/17.
 * Content :图片文件处理
 */
@Component("commonPreview")
public class CommonPreviewImpl implements FilePreview {

    private final FileHandlerService fileHandlerService;
    private final OtherFilePreviewImpl otherFilePreview;

    public CommonPreviewImpl(FileHandlerService fileHandlerService, OtherFilePreviewImpl otherFilePreview) {
        this.fileHandlerService = fileHandlerService;
        this.otherFilePreview = otherFilePreview;
    }

    @Override
    public String filePreviewHandle(String url, Model model, FileAttribute fileAttribute) {
        // 不是http开头，浏览器不能直接访问，需下载到本地
        if (url != null && !url.toLowerCase().startsWith("http")) {
            ReturnResponse<String> response = DownloadUtils.downLoad(fileAttribute, null);
            if (response.isFailure()) {
                return otherFilePreview.notSupportedFile(model, fileAttribute, response.getMsg());
            } else {
                String file = fileHandlerService.getRelativePath(response.getContent());
                model.addAttribute("currentUrl", file);
            }
        } else {
            model.addAttribute("currentUrl", url);
        }
        return null;
    }
}
