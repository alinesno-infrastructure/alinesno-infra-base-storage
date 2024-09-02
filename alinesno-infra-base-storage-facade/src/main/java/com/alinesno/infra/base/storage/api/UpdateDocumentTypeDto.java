package com.alinesno.infra.base.storage.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class UpdateDocumentTypeDto{

    @NotBlank(message = "项目ID不能为空")
    private String projectId ;

    private List<String> documentIds ;
}
