package com.yunli.bigdata.dsep.service.common.dto.statistics;

import java.util.Map;

public class ScreenProportion extends ScreenStatistics {

    private Long total;

    /** 比例类型 key 类型名称, value 统计的总数 */
    private Map<String,Long> values;

    public ScreenProportion() {
        super();
    }

    public ScreenProportion(Long total, Map<String, Long> values) {
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

    public Map<String, Long> getValues() {
        return values;
    }

    public void setValues(Map<String, Long> values) {
        this.values = values;
    }
}
