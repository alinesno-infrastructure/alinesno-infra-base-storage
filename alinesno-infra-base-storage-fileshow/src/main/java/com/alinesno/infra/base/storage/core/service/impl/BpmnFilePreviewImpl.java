package com.alinesno.infra.base.storage.core.service.impl;

import com.alinesno.infra.base.storage.core.model.FileAttribute;
import com.alinesno.infra.base.storage.core.service.FilePreview;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

/**
 * @author kl (http://kailing.pub)
 * @since 2023/3/9
 */
@Component
public class BpmnFilePreviewImpl implements FilePreview {

    private final CommonPreviewImpl commonPreview;

    public BpmnFilePreviewImpl(CommonPreviewImpl commonPreview) {
        this.commonPreview = commonPreview;
    }

    @Override
    public String filePreviewHandle(String url, Model model, FileAttribute fileAttribute) {
        commonPreview.filePreviewHandle(url,model,fileAttribute);
        model.addAttribute("fileName", fileAttribute.getName());
        return FilePreview.BPMN_FILE_PREVIEW_PAGE;
    }
}
