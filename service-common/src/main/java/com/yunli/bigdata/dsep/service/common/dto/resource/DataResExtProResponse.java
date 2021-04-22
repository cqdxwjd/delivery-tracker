package com.yunli.bigdata.dsep.service.common.dto.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author guozhijun
 * 数据表扩展属性查询响应信息
 */
@ApiModel(description = "数据表扩展属性查询响应信息")
public class DataResExtProResponse {

    @ApiModelProperty("序号")
    private Long id;

    /** 扩展属性名称（英文） */
    @ApiModelProperty("扩展属性名称（英文）")
    private String nameEn;

    /** 扩展属性名称（中文） */
    @ApiModelProperty("扩展属性名称（中文）")
    private String nameCn;

    /**属性声明分组编码值*/
    @ApiModelProperty("属性声明分组编码值")
    private String groupCode;

    /** 是否关联标签 */
    @ApiModelProperty("是否关联标签")
    private Boolean hasLabel;

    /**属性描述*/
    @ApiModelProperty("属性描述")
    private String description;

    /**状态 （0-(初始状态), 2-已发布, 3-已删除)*/
    @ApiModelProperty("状态")
    private int status;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public DataResExtProResponse() {
    }

    public DataResExtProResponse(Long id, String nameEn, String nameCn, String groupCode, String description, int status) {
        this.id = id;
        this.nameEn = nameEn;
        this.nameCn = nameCn;
        this.groupCode = groupCode;
        this.description = description;
        this.status = status;
    }

    public DataResExtProResponse(Long id, String nameEn, String nameCn, String groupCode, Boolean hasLabel, String description, int status, Date updateTime) {
        this.id = id;
        this.nameEn = nameEn;
        this.nameCn = nameCn;
        this.groupCode = groupCode;
        this.hasLabel = hasLabel;
        this.description = description;
        this.status = status;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Boolean getHasLabel() {
        return hasLabel;
    }

    public void setHasLabel(Boolean hasLabel) {
        this.hasLabel = hasLabel;
    }
}
