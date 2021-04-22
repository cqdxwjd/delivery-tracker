package com.yunli.bigdata.dsep.service.common.dto.resource.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zhangws
 */
@ApiModel(description = "基础节点")
public class Node implements Serializable {

  @ApiModelProperty("父ID")
  private Long parentId;

  @ApiModelProperty("ID")
  private Long nid;

  @ApiModelProperty("名称")
  private String name;

  @ApiModelProperty(value = "是否是目录", example = "true")
  private boolean directory;

  @ApiModelProperty(value = "创建时间", example = "2020-04-07 16:29:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  @ApiModelProperty(value = "更新时间", example = "2020-04-07 16:29:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  @ApiModelProperty("子节点")
  private List<Node> children;

  public Node() {
  }

  public Node(Long parentId, Long nid, String name, Date createTime, Date updateTime, boolean directory) {
    this.parentId = parentId;
    this.nid = nid;
    this.name = name;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.directory = directory;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public Long getNid() {
    return nid;
  }

  public void setNid(Long nid) {
    this.nid = nid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean getDirectory() {
    return directory;
  }

  public void setDirectory(boolean directory) {
    this.directory = directory;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public List<Node> getChildren() {
    return children;
  }

  public void setChildren(List<Node> children) {
    this.children = children;
  }

  @Override
  public String toString() {
    return "Node{" +
        "parentId=" + parentId +
        ", nid=" + nid +
        ", name='" + name + '\'' +
        ", directory=" + directory +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", children=" + children +
        '}';
  }
}