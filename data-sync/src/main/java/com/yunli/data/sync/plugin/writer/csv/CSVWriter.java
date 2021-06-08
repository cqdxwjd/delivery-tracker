package com.yunli.data.sync.plugin.writer.csv;

import com.google.common.base.Joiner;
import com.yunli.data.sync.config.PluginConfig;
import com.yunli.data.sync.core.JobContext;
import com.yunli.data.sync.core.plugin.Record;
import com.yunli.data.sync.core.plugin.Writer;
import com.yunli.data.sync.exception.HDataException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

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

    private String[] strArray;
    private BufferedWriter bw;

    List<String> list = new ArrayList<>();

    @Override
    public void prepare(JobContext context, PluginConfig writerConfig) {
        PluginConfig readerConfig = context.getJobConfig().getReaderConfig();

        String path = writerConfig.getString("path");
        String table = readerConfig.getString("table");

        Path hdfsPath = new Path(path + "/delivery-tracker/" + table + ".csv");
        Configuration conf = new Configuration();
        try {
            FileSystem fs = hdfsPath.getFileSystem(conf);
            FSDataOutputStream output = fs.create(hdfsPath);
            bw = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
//            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + "/" + table + ".csv"), StandardCharsets.UTF_8));
        } catch (IOException e) {
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
