package com.alinesno.infra.base.fileshow.core.service;

import com.alinesno.infra.base.fileshow.core.model.FileAttribute;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by kl on 2018/1/17.
 * Content :
 */
@Service
public class FilePreviewFactory {

    private final ApplicationContext context;

    public FilePreviewFactory(ApplicationContext context) {
        this.context = context;
    }

    public FilePreview get(FileAttribute fileAttribute) {
        return context.getBean(fileAttribute.getType().getInstanceName(), FilePreview.class);
    }
}
