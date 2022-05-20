package com.gitlabci.plugin.services;

import com.gitlabci.plugin.language.GitLabYamlBundle;
import com.intellij.openapi.project.Project;

public class GitLabCIProjectService {
    GitLabCIProjectService(Project project) {
        System.out.println(GitLabYamlBundle.message("projectService", project.getName()));
    }
}
