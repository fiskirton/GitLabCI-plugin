package com.gitlabci.plugin.ui;

import com.gitlabci.plugin.utils.Utils;
import com.intellij.ui.Gray;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PipelinePreviewBuilder {
    private static JPanel createStageBlock(String stageName, Map<String, Job> jobs) {
        JPanel panel = new JPanel();
        int rows = jobs.size();
        panel.setLayout(new GridLayout(rows, 1));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Gray._187), stageName));
        for (var job : jobs.entrySet()) {
            JobView jobView = PipelinePreviewBuilder.createJobView(job.getKey(), job.getValue().getParams());
            panel.add(jobView);
        }
        panel.setToolTipText(stageName);
        panel.setPreferredSize(new Dimension(200, panel.getPreferredSize().height));
        return panel;
    }

    public static JPanel createPipelineDiagram(Map<String, Stage> stages) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        Stage preStage = getDefaultStage(stages, ".pre");
        Stage postStage = getDefaultStage(stages, ".post");

        if (preStage != null && !preStage.getJobs().isEmpty()) {
            JPanel stagePanel = createStageBlock(preStage.getStageName(), preStage.getJobs());
            panel.add(stagePanel);
        }

        for (var stage : Utils.getSortedStages(stages)) {
            JPanel stagePanel = createStageBlock(stage.getKey(), stage.getValue().getJobs());
            panel.add(stagePanel);
        }

        if (postStage != null && !postStage.getJobs().isEmpty()) {
            JPanel stagePanel = createStageBlock(postStage.getStageName(), postStage.getJobs());
            panel.add(stagePanel);
        }

        return panel;
    }

    private static Stage getDefaultStage(Map<String, Stage> stages, String name) {
        if (stages.containsKey(name)) {
            Stage postStage = stages.get(name);
            stages.remove(name);
            return postStage;
        }
        return null;
    }

    private static JobView createJobView(String jobName, Map<String, String> jobParams) {
        JobView jobView = new JobView(jobName, jobParams);
        jobView.setText(jobName);
        jobView.setToolTipText(jobName);
        return jobView;
    }
}

