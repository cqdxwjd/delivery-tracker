package com.yunli.bigdata.dsep.service.common.dto.statistics;

import java.util.Map;

/**
 * @author guozhijun
 */
public class ScreenTaskStatus extends ScreenStatistics{

    private Map<String, TaskDetail> taskTypeCount;

    public Map<String, TaskDetail> getTaskTypeCount() {
        return taskTypeCount;
    }

    public void setTaskTypeCount(Map<String, TaskDetail> taskTypeCount) {
        this.taskTypeCount = taskTypeCount;
    }
}
