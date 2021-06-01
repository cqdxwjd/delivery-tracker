package com.yunli.data.sync.core.plugin;

import com.yunli.data.sync.config.JobConfig;
import com.yunli.data.sync.config.PluginConfig;

import java.util.List;


public abstract class Splitter extends AbstractPlugin {

    public abstract List<PluginConfig> split(JobConfig jobConfig);
}
