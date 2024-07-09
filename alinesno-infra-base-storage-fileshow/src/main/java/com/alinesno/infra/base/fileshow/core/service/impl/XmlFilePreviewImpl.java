package com.alinesno.infra.base.fileshow.core.service.impl;

import com.alinesno.infra.base.fileshow.core.model.FileAttribute;
import com.alinesno.infra.base.fileshow.core.service.FilePreview;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * @author kl (http://kailing.pub)
 * @since 2020/12/25
 */
@Service
public class XmlFilePreviewImpl implements FilePreview {

    private final SimTextFilePreviewImpl simTextFilePreview;

    public XmlFilePreviewImpl(SimTextFilePreviewImpl simTextFilePreview) {
        this.simTextFilePreview = simTextFilePreview;
    }

    @Override
    public String filePreviewHandle(String url, Model model, FileAttribute fileAttribute) {
        simTextFilePreview.filePreviewHandle(url, model, fileAttribute);
        return XML_FILE_PREVIEW_PAGE;
    }
}
