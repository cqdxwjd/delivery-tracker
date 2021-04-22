package com.yunli.bigdata.dsep.service.common.dto.statistics;

public class ScreenDataTotal extends ScreenStatistics{

    private Long total;

    private Double cycleRation;

    public ScreenDataTotal() {
    }

    public ScreenDataTotal(Long total, Double cycleRation) {
        this.total = total;
        this.cycleRation = cycleRation;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Double getCycleRation() {
        return cycleRation;
    }

    public void setCycleRation(Double cycleRation) {
        this.cycleRation = cycleRation;
    }
}
