package com.yunli.data.sync.core;


import com.yunli.data.sync.config.PluginConfig;
import com.yunli.data.sync.core.plugin.Reader;
import com.yunli.data.sync.core.plugin.RecordCollector;

public class ReaderWorker implements Runnable {

    private Reader reader;
    private JobContext context;
    private PluginConfig readerConfig;
    private RecordCollector rc;

    public ReaderWorker(Reader reader, JobContext context, PluginConfig readerConfig, RecordCollector rc) {
        this.reader = reader;
        this.context = context;
        this.readerConfig = readerConfig;
        this.rc = rc;
    }

    public void run() {
        reader.prepare(context, readerConfig);
        reader.execute(rc);
        reader.close();
    }

}
