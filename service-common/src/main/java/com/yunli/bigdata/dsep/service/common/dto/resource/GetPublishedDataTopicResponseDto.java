package com.yunli.bigdata.dsep.service.common.dto.resource;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunli.bigdata.dsep.service.common.constant.SubscribeStatus;
import com.yunli.bigdata.dsep.service.common.dto.resource.label.LabelCatalog;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author david
 */
@ApiModel(description = "查询实时数据信道参数对象列表")
public class GetPublishedDataTopicResponseDto implements Serializable {
    /**
     * 数据表表ID
     **/
    @ApiModelProperty("实时数据信道ID")
    private Long id;

    @ApiModelProperty("实时数据信道名称")
    private String topicName;

    @ApiModelProperty("实时数据信道代码")
    private String topicCode;

    @ApiModelProperty("资源责任组织ID")
    private String responsibleOrganizationId;

    @ApiModelProperty("资源责任组织名称")
    private String responsibleOrganizationName;

    @ApiModelProperty("资源描述")
    private String description;

    @ApiModelProperty("共享类型（0-有条件共享，1-无条件共享，2-不予共享）")
    private Integer sharingType;

    @ApiModelProperty("共享条件")
    private String sharingCondition;

    @ApiModelProperty("发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date publishedTime;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("共享次数")
    private Long sharingTimes;

    @ApiModelProperty("实时数据信道Column信息列表")
    private List<FilterTopicColumnResponseDto> topicColumns;

    @ApiModelProperty("标签属性")
    private List<LabelCatalog> labels;

    /**
     * 查询此资源的用户对此资源的访问权限
     **/
    @ApiModelProperty("查询此资源的用户对此资源的访问权限（未申请:0 审批中:1 已授权:2）")
    private Integer subscribeStatus = SubscribeStatus.Default.getValue();

    public GetPublishedDataTopicResponseDto(Long id, String topicName, String topicCode, String responsibleOrganizationId,
                                            String responsibleOrganizationName, String description, Integer sharingType, String sharingCondition,
                                            Date publishedTime, Date createTime, Date updateTime, Long sharingTimes) {
        this.id = id;
        this.topicName = topicName;
        this.topicCode = topicCode;
        this.responsibleOrganizationId = responsibleOrganizationId;
        this.responsibleOrganizationName = responsibleOrganizationName;
        this.description = description;
        this.sharingType = sharingType;
        this.sharingCondition = sharingCondition;
        this.publishedTime = publishedTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.sharingTimes = sharingTimes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicCode() {
        return topicCode;
    }

    public void setTopicCode(String topicCode) {
        this.topicCode = topicCode;
    }

    public String getResponsibleOrganizationId() {
        return responsibleOrganizationId;
    }

    public void setResponsibleOrganizationId(String responsibleOrganizationId) {
        this.responsibleOrganizationId = responsibleOrganizationId;
    }

    public String getResponsibleOrganizationName() {
        return responsibleOrganizationName;
    }

    public void setResponsibleOrganizationName(String responsibleOrganizationName) {
        this.responsibleOrganizationName = responsibleOrganizationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSharingType() {
        return sharingType;
    }

    public void setSharingType(Integer sharingType) {
        this.sharingType = sharingType;
    }

    public String getSharingCondition() {
        return sharingCondition;
    }

    public void setSharingCondition(String sharingCondition) {
        this.sharingCondition = sharingCondition;
    }

    public Date getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Date publishedTime) {
        this.publishedTime = publishedTime;
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

    public Long getSharingTimes() {
        return sharingTimes;
    }

    public void setSharingTimes(Long sharingTimes) {
        this.sharingTimes = sharingTimes;
    }

    public List<FilterTopicColumnResponseDto> getTopicColumns() {
        return topicColumns;
    }

    public void setTopicColumns(List<FilterTopicColumnResponseDto> topicColumns) {
        this.topicColumns = topicColumns;
    }

    public List<LabelCatalog> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelCatalog> labels) {
        this.labels = labels;
    }

    public Integer getSubscribeStatus() {
        return subscribeStatus;
    }

    public void setSubscribeStatus(Integer subscribeStatus) {
        this.subscribeStatus = subscribeStatus;
    }
}
