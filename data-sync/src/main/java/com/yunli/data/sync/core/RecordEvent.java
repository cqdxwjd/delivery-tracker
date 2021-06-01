package com.yunli.data.sync.core;


import com.lmax.disruptor.EventFactory;
import com.yunli.data.sync.core.plugin.Record;

public class RecordEvent {

    private Record record;

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public static final EventFactory<RecordEvent> FACTORY = new EventFactory<RecordEvent>() {

        public RecordEvent newInstance() {
            return new RecordEvent();
        }
    };

}
