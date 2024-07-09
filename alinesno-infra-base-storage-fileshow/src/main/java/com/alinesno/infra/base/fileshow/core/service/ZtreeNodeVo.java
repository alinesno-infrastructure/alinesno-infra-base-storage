package com.alinesno.infra.base.fileshow.core.service;
import lombok.Data;

import java.util.List;

@Data
public class ZtreeNodeVo {

    public String id;
    public String pid;
    public String name;
    public List<ZtreeNodeVo> children;

}