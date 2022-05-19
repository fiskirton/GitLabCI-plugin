package com.gitlabci.plugin.ui;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class Stage implements Comparable<Stage> {
    private final String stageName;
    private final Map<String, Job> jobs;

    private final int index;

    public Stage(String stageName, Map<String, Job> jobs, int index) {
        this.stageName = stageName;
        this.jobs = jobs;
        this.index = index;
    }

    public String getStageName() {
        return stageName;
    }

    public Map<String, Job> getJobs() {
        return jobs;
    }

    public Stage getSelf() {
        return this;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(@NotNull Stage o) {
        return Integer.compare(this.index, o.index);
    }
}
