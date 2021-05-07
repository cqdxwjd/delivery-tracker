package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobStat {
    String type;
    Long fileImportCount;
    Long tableImportCount;
    Long realtimeImportCount;
    Long realtimeGovernCount;
    Long fileUploadCount;
    Long tableExportCount;
}
