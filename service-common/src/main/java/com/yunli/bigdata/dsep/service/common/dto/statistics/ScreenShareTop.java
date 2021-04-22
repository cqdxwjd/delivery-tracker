package com.yunli.bigdata.dsep.service.common.dto.statistics;

import java.util.List;

public class ScreenShareTop extends ScreenStatistics{

    List<String> items;

    List<Long> values;

    public ScreenShareTop() {
        super();
    }

    public ScreenShareTop(List<String> items, List<Long> values) {
        super();
        this.items = items;
        this.values = values;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<Long> getValues() {
        return values;
    }

    public void setValues(List<Long> values) {
        this.values = values;
    }
}
