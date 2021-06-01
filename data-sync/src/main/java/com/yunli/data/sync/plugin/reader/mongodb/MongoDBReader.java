package com.yunli.data.sync.plugin.reader.mongodb;

import java.net.UnknownHostException;
import java.util.Set;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.yunli.data.sync.config.PluginConfig;
import com.yunli.data.sync.core.DefaultRecord;
import com.yunli.data.sync.core.Fields;
import com.yunli.data.sync.core.JobContext;
import com.yunli.data.sync.core.OutputFieldsDeclarer;
import com.yunli.data.sync.core.plugin.Reader;
import com.yunli.data.sync.core.plugin.Record;
import com.yunli.data.sync.core.plugin.RecordCollector;
import com.yunli.data.sync.exception.HDataException;

public class MongoDBReader extends Reader {

    private Fields fields;
    private String uri;
    private BasicDBObject condition;
    private static final String OBJECT_ID_KEY = "_id";

    @Override
    public void prepare(JobContext context, PluginConfig readerConfig) {
        uri = readerConfig.getString(MongoDBReaderProperties.URI);
        condition = (BasicDBObject) readerConfig.get(MongoDBReaderProperties.QUERY);
    }

    @Override
    public void execute(RecordCollector recordCollector) {
        MongoClientURI clientURI = new MongoClientURI(uri);
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(clientURI);
            DB db = mongoClient.getDB(clientURI.getDatabase());
            DBCollection coll = db.getCollection(clientURI.getCollection());
            DBCursor cur = coll.find(condition);
            while (cur.hasNext()) {
                DBObject doc = cur.next();
                Set<String> keys = doc.keySet();
                Record record = new DefaultRecord(keys.size() - 1);
                if (fields == null) {
                    fields = new Fields();
                    for (String key : keys) {
                        fields.add(key);
                    }
                }

                for (String key : keys) {
                    if (!OBJECT_ID_KEY.equals(key)) {
                        record.addField(doc.get(key));
                    }
                }

                recordCollector.send(record);
            }
        } catch (UnknownHostException e) {
            throw new HDataException(e);
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(fields);
    }
}
