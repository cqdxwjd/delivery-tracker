package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TableStat {
    String layer;
    Long tableCount;
    Long blankTableCount;
    Long unrelatedTableCount;
    Long unpublishedTableCount;
}
