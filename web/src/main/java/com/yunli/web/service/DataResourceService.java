package com.yunli.web.service;

import com.yunli.web.dto.TableStat;

import java.util.List;

public interface DataResourceService {
    TableStat getTableStat(String layer);
}
