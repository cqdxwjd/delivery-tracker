package com.yunli.bigdata.dsep.service.common.dto.statistics;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author guozhijun
 * @date 2020/2/29 0029
 */
@ApiModel(description = "大屏指标mock数据请求对象")
public class RequestScreenMock {

    @ApiModelProperty("数据总量")
    private Long dataTotal;

    @ApiModelProperty("硬盘使用量,单位GB")
    private Long diskUsed;
    @ApiModelProperty("硬盘总量,单位GB")
    private Long diskTotal;
    @ApiModelProperty("实时数据清洗量")
    private Long realRinseTotal;

    @ApiModelProperty("质量检核数据量")
    private Long checkDataTotal;

    @ApiModelProperty("数据治理任务量")
    private Long governDataTotal;

    @ApiModelProperty("数据服务使用次数")
    private Long dataServiceUseTotal;

    @ApiModelProperty("数据表占比_按主题")
    private List<RequestProportion> dataResourceThemeProportion;

    public RequestScreenMock() {
    }

    public RequestScreenMock(Long dataTotal, Long diskUsed, Long diskTotal, Long realRinseTotal, Long checkDataTotal, Long governDataTotal, Long dataServiceUseTotal, List<RequestProportion> dataResourceThemeProportion) {
        this.dataTotal = dataTotal;
        this.diskUsed = diskUsed;
        this.diskTotal = diskTotal;
        this.realRinseTotal = realRinseTotal;
        this.checkDataTotal = checkDataTotal;
        this.governDataTotal = governDataTotal;
        this.dataServiceUseTotal = dataServiceUseTotal;
        this.dataResourceThemeProportion = dataResourceThemeProportion;
    }

    public Long getDataTotal() {
        return dataTotal;
    }

    public void setDataTotal(Long dataTotal) {
        this.dataTotal = dataTotal;
    }

    public Long getDiskUsed() {
        return diskUsed;
    }

    public void setDiskUsed(Long diskUsed) {
        this.diskUsed = diskUsed;
    }

    public Long getDiskTotal() {
        return diskTotal;
    }

    public void setDiskTotal(Long diskTotal) {
        this.diskTotal = diskTotal;
    }

    public Long getRealRinseTotal() {
        return realRinseTotal;
    }

    public void setRealRinseTotal(Long realRinseTotal) {
        this.realRinseTotal = realRinseTotal;
    }

    public Long getCheckDataTotal() {
        return checkDataTotal;
    }

    public void setCheckDataTotal(Long checkDataTotal) {
        this.checkDataTotal = checkDataTotal;
    }

    public Long getGovernDataTotal() {
        return governDataTotal;
    }

    public void setGovernDataTotal(Long governDataTotal) {
        this.governDataTotal = governDataTotal;
    }

    public Long getDataServiceUseTotal() {
        return dataServiceUseTotal;
    }

    public void setDataServiceUseTotal(Long dataServiceUseTotal) {
        this.dataServiceUseTotal = dataServiceUseTotal;
    }

    public List<RequestProportion> getDataResourceThemeProportion() {
        return dataResourceThemeProportion;
    }

    public void setDataResourceThemeProportion(List<RequestProportion> dataResourceThemeProportion) {
        this.dataResourceThemeProportion = dataResourceThemeProportion;
    }
}
