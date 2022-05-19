package com.gitlabci.plugin.ui;

import com.gitlabci.plugin.listeners.JobSelectedListener;

import javax.swing.*;
import java.util.Map;

public class JobView extends JButton {

    private final String jobName;
    private final Map<String, String> jobParams;

    public JobView(String jobName, Map<String, String> jobParams) {
        super();
        this.jobName = jobName;
        this.jobParams = jobParams;
        this.addActionListener(new JobSelectedListener());
    }

    public String getJobName() {
        return jobName;
    }

    public Map<String, String> getJobParams() {
        return jobParams;
    }
}
