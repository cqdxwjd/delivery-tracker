package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class TableStat {
    String layer;
    Long tableCount;
    Long blankTableCount;
    Long unrelatedTableCount;
    Long unpublishedTableCount;

    public TableStat(String layer) {
        this.layer = layer;
        this.tableCount = 0L;
        this.blankTableCount = 0L;
        this.unrelatedTableCount = 0L;
        this.unpublishedTableCount = 0L;
    }

    public void addTableCount(int i) {
        this.tableCount += i;
    }

    public void addBlankTableCount(int i) {
        this.blankTableCount += i;
    }

    public void addUnrelatedTableCount(int i) {
        this.unrelatedTableCount += i;
    }

    public void addUnpublishedTableCount(int i) {
        this.unpublishedTableCount += i;
    }
}
