package com.yunli.bigdata.dsep.service.common.dto.statistics;

import java.util.List;

/**
 * @author guozhijun
 * @date 2020/3/2 0002
 */
public class DataResName extends DataExtValProportion {

    List<String> dataNames;

    public DataResName() {
        super();
    }

    public DataResName(Long count, String value, String nameEn, String nameCn, List<String> dataNames) {
        super(count, value, nameEn, nameCn);
        this.dataNames = dataNames;
    }

    public DataResName(Long count, String nameEn, String nameCn, List<String> dataNames) {
        super(count, nameEn, nameCn);
        this.dataNames = dataNames;
    }

    public List<String> getDataNames() {
        return dataNames;
    }

    public void setDataNames(List<String> dataNames) {
        this.dataNames = dataNames;
    }
}
