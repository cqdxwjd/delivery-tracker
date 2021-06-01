package com.yunli.data.sync.plugin.writer.console;


import com.yunli.data.sync.core.plugin.Record;
import com.yunli.data.sync.core.plugin.Writer;

public class ConsoleWriter extends Writer {

    @Override
    public void execute(Record record) {
        System.out.println(record);
    }
}
