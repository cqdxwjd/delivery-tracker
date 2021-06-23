package com.yunli.data.sync.core;


import com.lmax.disruptor.WorkHandler;
import com.yunli.data.sync.config.PluginConfig;
import com.yunli.data.sync.core.plugin.Reader;
import com.yunli.data.sync.core.plugin.Writer;
import com.yunli.data.sync.plugin.reader.hive.HiveSplitter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RecordWorkHandler implements WorkHandler<RecordEvent> {

    private static final Logger LOG = LogManager.getLogger(RecordWorkHandler.class);

    private Reader[] readers;
    private Writer writer;
    private JobContext context;
    private PluginConfig writerConfig;
    private boolean writerPrepared;
    private boolean isWriterError;
    private Metric metric;

    public RecordWorkHandler(Reader[] readers, Writer writer, JobContext context, PluginConfig writerConfig) {
        this.readers = readers;
        this.writer = writer;
        this.context = context;
        this.writerConfig = writerConfig;
        this.metric = context.getMetric();
    }

    public void onEvent(RecordEvent event) {
        if (!isWriterError) {
            try {
                if (!writerPrepared) {
                    for (Reader reader : readers) {
                        if (context.getFields() == null) {
                            reader.declareOutputFields(context.getDeclarer());
                        } else {
                            break;
                        }
                    }
                    writer.prepare(context, writerConfig);
                    writerPrepared = true;

                    if (metric.getWriterStartTime() == 0) {
                        metric.setWriterStartTime(System.currentTimeMillis());
                    }
                }
                LOG.info(event.getRecord());
                writer.execute(event.getRecord());
                metric.getWriteCount().incrementAndGet();
            } catch (Exception e) {
                this.isWriterError = true;
                context.setWriterError(true);
                e.printStackTrace();
            }
        }
    }

}
