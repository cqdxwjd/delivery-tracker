package com.yunli.data.sync.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.yunli.data.sync.common.Constants;
import com.yunli.data.sync.core.plugin.ReaderPlugin;
import com.yunli.data.sync.core.plugin.WriterPlugin;
import com.yunli.data.sync.exception.HDataException;
import com.yunli.data.sync.util.Utils;
import com.yunli.data.sync.util.XMLUtils;
import org.jdom2.Element;
import org.springframework.core.io.ClassPathResource;

public class PluginLoader {

    private static Map<String, ReaderPlugin> readerMap;
    private static Map<String, WriterPlugin> writerMap;

    public static ReaderPlugin getReaderPlugin(String name) {
        return readerMap.get(name);
    }

    public static WriterPlugin getWriterPlugin(String name) {
        return writerMap.get(name);
    }

    static {
        readerMap = new HashMap<String, ReaderPlugin>();
        writerMap = new HashMap<String, WriterPlugin>();

        Element root;
        try {
//            root = XMLUtils.load(Utils.getConfigDir() + Constants.PLUGINS_XML);
            root = XMLUtils.load(new ClassPathResource("conf/plugins.xml").getInputStream());
        } catch (Exception e) {
            throw new HDataException(e);
        }
        List<Element> readers = root.getChild("readers").getChildren("reader");
        for (Element e : readers) {
            ReaderPlugin readerPlugin = new ReaderPlugin();
            readerPlugin.setPluginName(e.getChildText("name"));
            readerPlugin.setClassName(e.getChildText("class"));
            readerPlugin.setSplitterClassName(e.getChildText("splitter"));
            readerMap.put(readerPlugin.getPluginName(), readerPlugin);
        }

        List<Element> writers = root.getChild("writers").getChildren("writer");
        for (Element e : writers) {
            WriterPlugin writerPlugin = new WriterPlugin();
            writerPlugin.setPluginName(e.getChildText("name"));
            writerPlugin.setClassName(e.getChildText("class"));
            writerMap.put(writerPlugin.getPluginName(), writerPlugin);
        }
    }
}
