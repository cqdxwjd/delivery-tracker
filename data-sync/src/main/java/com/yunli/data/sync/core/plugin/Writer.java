package com.yunli.data.sync.core.plugin;


import com.yunli.data.sync.config.PluginConfig;
import com.yunli.data.sync.core.JobContext;

public abstract class Writer extends AbstractPlugin {

    public void prepare(JobContext context, PluginConfig writerConfig) {
    }

    public void execute(Record record) {
    }

    public void close() {
    }
}
