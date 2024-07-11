package com.alinesno.infra.base.fileshow.core.service.impl;

import com.alinesno.infra.base.fileshow.core.model.FileAttribute;
import com.alinesno.infra.base.fileshow.core.service.FilePreview;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * ofd 图片文件处理
 * @author kl (http://kailing.pub)
 * @since 2021/2/8
 */
@Service
public class OfdFilePreviewImpl implements FilePreview {

    private final CommonPreviewImpl commonPreview;

    public OfdFilePreviewImpl(CommonPreviewImpl commonPreview) {
        this.commonPreview = commonPreview;
    }

    @Override
    public String filePreviewHandle(String url, Model model, FileAttribute fileAttribute) {
        commonPreview.filePreviewHandle(url,model,fileAttribute);
        return OFD_FILE_PREVIEW_PAGE;
    }
}
