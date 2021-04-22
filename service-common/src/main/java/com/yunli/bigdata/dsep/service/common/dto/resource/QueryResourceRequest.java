package com.yunli.bigdata.dsep.service.common.dto.resource;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhangws
 */
@ApiModel(description = "资源目录高级检索请求")
public class QueryResourceRequest implements Serializable {
  @ApiModelProperty("模糊搜索关键字")
  private String keyword;

  @ApiModelProperty(value = "目录ID", example = "1")
  private Long tagId;

  @ApiModelProperty(value = "目录ID", example = "1")
  private Long treeId;

  @ApiModelProperty("资源类型（数据表:data 文件夹:document 实时信道:topic）")
  private List<String> types;

  @ApiModelProperty("查询此资源的用户对此资源的访问权限（未申请:0 审批中:1 已授权:2）")
  private List<Integer> subscribeStatus;

  @ApiModelProperty(value = "标签集合")
  private List<String> labelList;

  @ApiModelProperty(value = "排序键（sharingTimes或updateTime）")
  private String orderKey;

  public QueryResourceRequest() {
  }

  public QueryResourceRequest(String keyword, Long tagId, Long treeId, List<String> types,
      List<Integer> subscribeStatus, List<String> labelList, String orderKey) {
    this.keyword = keyword;
    this.tagId = tagId;
    this.treeId = treeId;
    this.types = types;
    this.subscribeStatus = subscribeStatus;
    this.labelList = labelList;
    this.orderKey = orderKey;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public Long getTagId() {
    return tagId;
  }

  public void setTagId(Long tagId) {
    this.tagId = tagId;
  }

  public Long getTreeId() {
    return treeId;
  }

  public void setTreeId(Long treeId) {
    this.treeId = treeId;
  }

  public List<String> getTypes() {
    return types;
  }

  public void setTypes(List<String> types) {
    this.types = types;
  }

  public List<Integer> getSubscribeStatus() {
    return subscribeStatus;
  }

  public void setSubscribeStatus(List<Integer> subscribeStatus) {
    this.subscribeStatus = subscribeStatus;
  }

  public List<String> getLabelList() {
    return labelList;
  }

  public void setLabelList(List<String> labelList) {
    this.labelList = labelList;
  }

  public String getOrderKey() {
    return orderKey;
  }

  public void setOrderKey(String orderKey) {
    this.orderKey = orderKey;
  }
}
