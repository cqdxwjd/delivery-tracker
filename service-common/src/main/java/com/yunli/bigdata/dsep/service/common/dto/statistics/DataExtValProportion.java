package com.yunli.bigdata.dsep.service.common.dto.statistics;

/**
 * @author guozhijun
 * 扩展信息比例统计对象
 */
public class DataExtValProportion {

    /** 分类总数 */
    private Long count;

    /** 扩展枚举ID */
    private String value;

    /** 扩展枚举英文名称 */
    private String nameEn;

    /** 扩展枚举中文名称 */
    private String nameCn;

    public DataExtValProportion() {
    }

    public DataExtValProportion(Long count, String value, String nameEn, String nameCn) {
        this.count = count;
        this.value = value;
        this.nameEn = nameEn;
        this.nameCn = nameCn;
    }

    public DataExtValProportion(Long count, String nameEn, String nameCn) {
        this.count = count;
        this.nameEn = nameEn;
        this.nameCn = nameCn;
    }

    public DataExtValProportion(Long count, String nameCn) {
        this.count = count;
        this.nameCn = nameCn;
        this.nameEn = nameCn;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
}
