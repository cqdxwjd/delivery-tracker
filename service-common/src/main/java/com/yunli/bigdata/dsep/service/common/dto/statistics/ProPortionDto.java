package com.yunli.bigdata.dsep.service.common.dto.statistics;

import java.util.Map;
import java.util.Set;

/**
 * @author guozhijun
 * 占比結果DTO
 */
public class ProPortionDto {

    /**
     * 指标名称
     */
    private String title;

    /**
     * 总数
     */
    private Long count;


    /**
     * 各项的数量
     */
    private Set<Map<String, Long>> values;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Set<Map<String, Long>> getValues() {
        return values;
    }

    public void setValues(Set<Map<String, Long>> values) {
        this.values = values;
    }
}
