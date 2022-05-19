package com.gitlabci.plugin.listeners;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import org.jetbrains.annotations.NotNull;
import com.gitlabci.plugin.services.GitlabCIProjectService;

class GitlabCIProjectManagerListener implements ProjectManagerListener {
    @Override
    public void projectOpened(@NotNull Project project) {
        project.getService(GitlabCIProjectService.class);
    }
}