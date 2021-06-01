package com.yunli.data.sync.core.plugin;

public abstract class AbstractPlugin implements Pluginable {

    private String pluginName;

    public String getPluginName() {
        return this.pluginName;
    }

    public void setPluginName(String name) {
        this.pluginName = name;
    }

}
