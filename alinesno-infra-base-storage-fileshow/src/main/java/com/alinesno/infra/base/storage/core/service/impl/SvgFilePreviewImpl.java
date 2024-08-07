package com.alinesno.infra.base.storage.core.service.impl;

import com.alinesno.infra.base.storage.core.model.FileAttribute;
import com.alinesno.infra.base.storage.core.service.FilePreview;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * svg 图片文件处理
 * @author kl (http://kailing.pub)
 * @since 2021/2/8
 */
@Service
public class SvgFilePreviewImpl implements FilePreview {

    private final CommonPreviewImpl commonPreview;

    public SvgFilePreviewImpl(CommonPreviewImpl commonPreview) {
        this.commonPreview = commonPreview;
    }

    @Override
    public String filePreviewHandle(String url, Model model, FileAttribute fileAttribute) {
        commonPreview.filePreviewHandle(url,model,fileAttribute);
        return SVG_FILE_PREVIEW_PAGE;
    }
}
