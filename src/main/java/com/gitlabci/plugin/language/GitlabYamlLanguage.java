package com.gitlabci.plugin.language;

import com.intellij.lang.Language;

public class GitLabYamlLanguage extends Language {

    public static final GitLabYamlLanguage INSTANCE = new GitLabYamlLanguage();

    private GitLabYamlLanguage() {
        super("GitLabYaml");
    }
}