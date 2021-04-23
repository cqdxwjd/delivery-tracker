package com.yunli.web.service.impl;

import com.yunli.bigdata.dsep.service.orm.data.DataResource;
import com.yunli.web.dto.TableStat;
import com.yunli.web.repositories.DataResourceRepository;
import com.yunli.web.service.DataResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataResourceServiceImpl implements DataResourceService {

    private final DataResourceRepository dataResourceRepository;

    @Autowired
    public DataResourceServiceImpl(DataResourceRepository dataResourceRepository) {
        this.dataResourceRepository = dataResourceRepository;
    }

    @Override
    public TableStat getTableStat(String layer) {
        if (layer.equals("总共")) {
            return new TableStat(
                    layer,
                    dataResourceRepository.count(),
                    dataResourceRepository.countBlankTable(),
                    dataResourceRepository.countUnrelatedTableCount(),
                    dataResourceRepository.countUnpublishedTableCount()
            );
        }
        if (layer.equals("其他")) {
            return new TableStat(
                    layer,
                    dataResourceRepository.countOtherLayer(),
                    dataResourceRepository.countOtherLayerBlankTable(),
                    dataResourceRepository.countOtherLayerUnrelatedTableCount(),
                    dataResourceRepository.countOtherLayerUnpublishedTableCount()
            );
        }

        return new TableStat(
                layer,
                dataResourceRepository.countByLayer(layer),
                dataResourceRepository.countBlankTableByLayer(layer),
                dataResourceRepository.countUnrelatedTableCountByLayer(layer),
                dataResourceRepository.countUnpublishedTableCountByLayer(layer)
        );
    }
}
