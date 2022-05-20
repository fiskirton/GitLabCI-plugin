package com.gitlabci.plugin.services;

import com.gitlabci.plugin.language.GitLabYamlBundle;

public class GitLabCIApplicationService {
    GitLabCIApplicationService() {
        System.out.println(GitLabYamlBundle.message("applicationService"));
    }
}
