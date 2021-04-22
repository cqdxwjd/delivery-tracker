package com.yunli.bigdata.dsep.service.common.dto.statistics;

import java.util.List;

/**
 * @author guozhijun
 * @date 2020/3/2 0002
 */
public class ScreenCenterIndex extends ScreenStatistics{

    private Long total;

    private List<ScreenCenterItem> values;

    public ScreenCenterIndex() {
        super();
    }

    public ScreenCenterIndex(Long total, List<ScreenCenterItem> values) {
        super();
        this.total = total;
        this.values = values;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<ScreenCenterItem> getValues() {
        return values;
    }

    public void setValues(List<ScreenCenterItem> values) {
        this.values = values;
    }
}
