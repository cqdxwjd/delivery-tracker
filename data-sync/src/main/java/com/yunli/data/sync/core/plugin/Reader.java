package com.yunli.data.sync.core.plugin;


import com.yunli.data.sync.config.PluginConfig;
import com.yunli.data.sync.core.JobContext;
import com.yunli.data.sync.core.OutputFieldsDeclarer;

public abstract class Reader extends AbstractPlugin {

    public void prepare(JobContext context, PluginConfig readerConfig) {
    }

    public void execute(RecordCollector recordCollector) {
    }

    public void close() {
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    }
}
