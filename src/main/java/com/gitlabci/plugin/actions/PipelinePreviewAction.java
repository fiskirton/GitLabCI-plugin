package com.gitlabci.plugin.actions;

import com.gitlabci.plugin.language.psi.GitlabYamlFile;
import com.gitlabci.plugin.utils.PsiUtils;
import com.gitlabci.plugin.language.psi.GitlabYamlPair;
import com.gitlabci.plugin.ui.Job;
import com.gitlabci.plugin.ui.PipelinePreviewBuilder;
import com.gitlabci.plugin.ui.GitlabCIPanel;
import com.gitlabci.plugin.ui.Stage;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PipelinePreviewAction extends AnAction {
    @Override
    public void update(@NotNull AnActionEvent event) {
        Project project = event.getData(CommonDataKeys.PROJECT);
        Presentation presentation = event.getPresentation();
        VirtualFile currentEditedFile = FileEditorManager.getInstance(project).getSelectedFiles()[0];
        PsiFile file = PsiManager.getInstance(project).findFile(currentEditedFile);

        presentation.setEnabled(file instanceof GitlabYamlFile);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Project project = event.getData(CommonDataKeys.PROJECT);
        VirtualFile currentEditedFile = FileEditorManager.getInstance(project).getSelectedFiles()[0];
        PsiFile file = PsiManager.getInstance(project).findFile(currentEditedFile);
        PsiElement topLevelMapping = file.getFirstChild();
        Map<String, Stage> stages = getStages(topLevelMapping);
        ToolWindow toolWindow = ToolWindowManager.getInstance(project).getToolWindow("GitlabCI");
        GitlabCIPanel panel = (GitlabCIPanel) toolWindow.getContentManager().getContent(0).getComponent();
        panel.getPreviewPanel().removeAll();
        JPanel stagesPanel = PipelinePreviewBuilder.createPipelineDiagram(stages);
        panel.getPreviewPanel().add(stagesPanel);

        System.out.println("debug");
    }

    public Map<String, Stage> getStages(PsiElement root) {
        PsiElement rootMapping = root.getFirstChild();
        List<String> stagesNames = PsiUtils.getStages(rootMapping);
        assert stagesNames != null;
        stagesNames.add(".pre");
        stagesNames.add(".post");

        Map<String, Stage> stages = IntStream
                .range(0, stagesNames.size())
                .mapToObj(i -> new Stage(stagesNames.get(i), new HashMap<>(), i))
                .collect(Collectors.toMap(Stage::getStageName, Stage::getSelf));

        for (var child : rootMapping.getChildren()) {
            if (child instanceof GitlabYamlPair) {
                String jobName = PsiUtils.getIdStr(child);
                String stage = PsiUtils.getValueOfKey("stage", child);
                if (stage != null) {
                    if (stagesNames.contains(stage)) {
                        Map<String, String> params = getRequiredParams(child, "script");
                        stages.get(stage).getJobs().put(jobName, new Job(jobName, getRequiredParams(child, "script")));
                    }
                }
            }
        }

        return stages;
    }

    public Map<String, String> getRequiredParams(PsiElement element, String ... params) {
        Map<String, String> requiredParams = new HashMap<>();
        for (var param : params) {
            String foundValue = PsiUtils.getValueOfKey(param, element);
            requiredParams.put(param, foundValue);
        }
        return requiredParams;
    }
}

