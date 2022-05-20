package com.gitlabci.plugin.language.lexer;

import com.intellij.lexer.FlexAdapter;

public class GitLabYamlLexerAdapter extends FlexAdapter {

    public GitLabYamlLexerAdapter() {
        super(new GitLabYamlLexer(null));
    }
}