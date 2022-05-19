package com.gitlabci.plugin.services;

import com.gitlabci.plugin.language.GitlabYamlBundle;
import com.intellij.openapi.project.Project;

public class GitlabCIProjectService {
    GitlabCIProjectService(Project project) {
        System.out.println(GitlabYamlBundle.message("projectService", project.getName()));
    }
}
