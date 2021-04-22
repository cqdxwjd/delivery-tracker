package com.yunli.bigdata.dsep.service.common.dto.statistics;

import java.util.List;

/**
 * @author guozhijun
 * @date 2020/3/2 0002
 */
public class ScreenCenterItem {

    private List<String> dataNames;

    private Long count;

    private String nameCn;

    private String nameEn;

    public ScreenCenterItem() {
    }

    public ScreenCenterItem(List<String> dataNames, Long count, String nameCn, String nameEn) {
        this.dataNames = dataNames;
        this.count = count;
        this.nameCn = nameCn;
        this.nameEn = nameEn;
    }

    public List<String> getDataNames() {
        return dataNames;
    }

    public void setDataNames(List<String> dataNames) {
        this.dataNames = dataNames;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
}
