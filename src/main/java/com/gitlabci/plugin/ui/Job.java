package com.gitlabci.plugin.ui;

import java.util.Map;

public class Job {
    private final String jobName;
    private final Map<String, String> params;

    public Job(String jobName, Map<String, String> params) {
        this.jobName = jobName;
        this.params = params;
    }


    public String getJobName() {
        return jobName;
    }

    public Map<String, String> getParams() {
        return params;
    }
}
