package com.yunli.data.sync.core;

public class OutputFieldsDeclarer {

    private JobContext context;

    public OutputFieldsDeclarer(JobContext context) {
        this.context = context;
    }

    public void declare(Fields fields) {
        context.setFields(fields);
    }
}
