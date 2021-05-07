package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusStat {
    String type;
    Long count;
    Long unMountedCount;
}
