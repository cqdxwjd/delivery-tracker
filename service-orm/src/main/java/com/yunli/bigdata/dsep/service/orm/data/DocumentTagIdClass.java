package com.yunli.bigdata.dsep.service.orm.data;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocumentTagIdClass implements Serializable {
    private Long documentId;
    private Long tagId;
}
