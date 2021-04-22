package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhijun.guo
 * @create 2020-02-07 13:50
 **/

@ApiModel(value = "数据表标签枚举查询对象")
public class ReponseDataResExtEnumDto {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "标签枚举名称")
    private String name;

    @ApiModelProperty(value = "标签枚举类型名称")
    private String type;

    @ApiModelProperty(value = "标签枚举类型ID")
    private Long typeid;

    @ApiModelProperty(value = "标签枚举描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


    public ReponseDataResExtEnumDto() {
    }

    public ReponseDataResExtEnumDto(Long id, String name, String type, Long typeid, String description, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.typeid = typeid;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
