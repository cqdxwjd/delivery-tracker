package com.yunli.data.sync.core.plugin;


import com.yunli.data.sync.core.Metric;
import com.yunli.data.sync.core.Storage;

public class RecordCollector {

    private Storage storage;
    private Metric metric;

    public RecordCollector(Storage storage, Metric metric) {
        this.storage = storage;
        this.metric = metric;
    }

    public void send(Record record) {
        storage.put(record);
        metric.getReadCount().incrementAndGet();
    }

    public Metric getMetric() {
        return metric;
    }

    public void send(Record[] records) {
        storage.put(records);
    }
}
