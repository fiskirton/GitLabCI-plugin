package com.gitlabci.plugin.language;

import com.intellij.lang.Language;

public class GitlabYamlLanguage extends Language {

    public static final GitlabYamlLanguage INSTANCE = new GitlabYamlLanguage();

    private GitlabYamlLanguage() {
        super("GitlabYaml");
    }
}