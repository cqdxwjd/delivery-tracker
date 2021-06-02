package com.yunli.data.sync.plugin.writer.csv;

import com.google.common.base.Joiner;
import com.yunli.data.sync.config.PluginConfig;
import com.yunli.data.sync.core.JobContext;
import com.yunli.data.sync.core.plugin.Record;
import com.yunli.data.sync.core.plugin.Writer;
import com.yunli.data.sync.exception.HDataException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjingdong
 * @date 2021/6/2 11:31
 * @Copyright © 云粒智慧 2018
 */
public class CSVWriter extends Writer {

    private PluginConfig writerConfig;
    private PluginConfig readerConfig;
    private String[] strArray;
    private BufferedWriter bw;

    List<String> list = new ArrayList<>();

    @Override
    public void prepare(JobContext context, PluginConfig writerConfig) {
        this.writerConfig = writerConfig;
        this.readerConfig = context.getJobConfig().getReaderConfig();

        String path = writerConfig.getString("path");
        String table = readerConfig.getString("table");

        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + "/" + table + ".csv"), StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(Record record) {
        if (strArray == null) {
            strArray = new String[record.getFieldsCount()];
        }

        for (int i = 0, len = record.getFieldsCount(); i < len; i++) {
            Object o = record.getField(i);
            if (o == null) {
                strArray[i] = "NULL";
            } else {
                strArray[i] = o.toString();
            }
        }
        try {
            bw.write(Joiner.on(",").join(strArray));
            bw.write("\n");
        } catch (IOException e) {
            throw new HDataException(e);
        }
    }

    @Override
    public void close() {
        if (bw != null) {
            try {
                bw.flush();
                bw.close();
            } catch (IOException e) {
                throw new HDataException(e);
            }
        }
    }
}
