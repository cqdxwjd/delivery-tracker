package com.yunli.bigdata.dsep.service.common.dto.resource.document;

import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * @author zhangws
 */
@ApiModel(description = "目录节点")
public class FolderNode extends Node {

  public FolderNode() {

  }

  public FolderNode(
      Long parentId,
      Long id,
      String name,
      Date createTime,
      Date updateTime) {
    super(parentId, id, name, createTime, updateTime, true);
  }
}
