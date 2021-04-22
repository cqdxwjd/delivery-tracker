package com.yunli.bigdata.dsep.service.common.dto.resource.document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author zhangws
 */
@ApiModel(description = "文件节点")
public class FileNode extends Node {

  @ApiModelProperty("文件大小")
  private Long size;

  @ApiModelProperty("媒体类型")
  private String mediaType;

  @ApiModelProperty("文件类型")
  private String type;

  @ApiModelProperty("文件版本ID")
  private Long versionId;

  public FileNode() {
  }

  public FileNode(
      Long parentId,
      Long id,
      String name,
      Date createTime,
      Date updateTime,
      Long size,
      String mediaType,
      String type,
      Long versionId) {
    super(parentId, id, name, createTime, updateTime, false);
    this.size = size;
    this.mediaType = mediaType;
    this.type = type;
    this.versionId = versionId;
  }

  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public String getMediaType() {
    return mediaType;
  }

  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Long getVersionId() {
    return versionId;
  }

  public void setVersionId(Long versionId) {
    this.versionId = versionId;
  }
}
