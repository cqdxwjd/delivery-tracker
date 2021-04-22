package com.yunli.bigdata.dsep.service.common.dto.statistics;

public class ScreenFileUsed extends ScreenStatistics {

    private Long dataTotal;

    private Double cycleRation;

    private Long usedTotal;

    private Long capacity;

    public ScreenFileUsed() {
        super();
    }

    public ScreenFileUsed(Long dataTotal, Double cycleRation, Long usedTotal, Long capacity) {
        super();
        this.dataTotal = dataTotal;
        this.cycleRation = cycleRation;
        this.usedTotal = usedTotal;
        this.capacity = capacity;
    }

    public Long getDataTotal() {
        return dataTotal;
    }

    public void setDataTotal(Long dataTotal) {
        this.dataTotal = dataTotal;
    }

    public Long getUsedTotal() {
        return usedTotal;
    }

    public void setUsedTotal(Long usedTotal) {
        this.usedTotal = usedTotal;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Double getCycleRation() {
        return cycleRation;
    }

    public void setCycleRation(Double cycleRation) {
        this.cycleRation = cycleRation;
    }
}
