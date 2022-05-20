package com.gitlabci.plugin.listeners;

import com.gitlabci.plugin.services.GitLabCIProjectService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import org.jetbrains.annotations.NotNull;

class GitLabCIProjectManagerListener implements ProjectManagerListener {
    @Override
    public void projectOpened(@NotNull Project project) {
        project.getService(GitLabCIProjectService.class);
    }
}