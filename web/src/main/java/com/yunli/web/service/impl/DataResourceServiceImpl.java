package com.yunli.web.service.impl;

import com.yunli.web.repositories.DataResourceRepository;
import com.yunli.web.service.DataResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataResourceServiceImpl implements DataResourceService {

    private final DataResourceRepository dataResourceRepository;

    @Autowired
    public DataResourceServiceImpl(DataResourceRepository dataResourceRepository) {
        this.dataResourceRepository = dataResourceRepository;
    }

    @Override
    public Long getTableCount() {
        return dataResourceRepository.count();
    }
}
