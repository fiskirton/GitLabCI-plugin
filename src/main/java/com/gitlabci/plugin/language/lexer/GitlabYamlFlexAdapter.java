package com.gitlabci.plugin.language.lexer;

import com.intellij.lexer.FlexAdapter;

public class GitlabYamlFlexAdapter extends FlexAdapter {

    public GitlabYamlFlexAdapter() {
        super(new GitlabYamlLexer(null));
    }
}