package com.yunli.data.sync.plugin.writer.mongodb;

import com.mongodb.*;
import com.yunli.data.sync.config.PluginConfig;
import com.yunli.data.sync.core.Fields;
import com.yunli.data.sync.core.JobContext;
import com.yunli.data.sync.core.plugin.Record;
import com.yunli.data.sync.core.plugin.Writer;
import com.yunli.data.sync.exception.HDataException;
import org.apache.commons.lang3.ArrayUtils;

import java.net.UnknownHostException;

public class MongoDBWriter extends Writer {

    private Fields fields;
    private MongoClient mongoClient = null;
    private DBCollection coll;
    private BasicDBObject[] insertDocs;
    private int batchsize;
    private int count;

    @Override
    public void prepare(JobContext context, PluginConfig writerConfig) {
        fields = context.getFields();
        batchsize = writerConfig.getInt(MongoDBWriterProperties.BATCH_INSERT_SIZE, 1000);
        insertDocs = new BasicDBObject[batchsize];
        MongoClientURI clientURI = new MongoClientURI(writerConfig.getString(MongoDBWriterProperties.URI));
        try {
            mongoClient = new MongoClient(clientURI);
            DB db = mongoClient.getDB(clientURI.getDatabase());
            coll = db.getCollection(clientURI.getCollection());
        } catch (UnknownHostException e) {
            throw new HDataException(e);
        }
    }

    @Override
    public void execute(Record record) {
        BasicDBObject doc = new BasicDBObject();
        for (int i = 0, len = fields.size(); i < len; i++) {
            doc.put(fields.get(i), record.getField(i));
        }

        insertDocs[count++] = doc;
        if (count == batchsize) {
            coll.insert(insertDocs);
            count = 0;
        }
    }

    @Override
    public void close() {
        if (mongoClient != null) {
            if (count > 0) {
                coll.insert(ArrayUtils.subarray(insertDocs, 0, count));
            }
            mongoClient.close();
        }
    }
}
