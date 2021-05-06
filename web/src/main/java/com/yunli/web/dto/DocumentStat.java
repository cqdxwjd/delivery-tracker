package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DocumentStat {
    String type;
    Long count;
    int nullCount;
    int unMountedCount;
}
