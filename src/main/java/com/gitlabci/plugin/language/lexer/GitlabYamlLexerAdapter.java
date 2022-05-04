package com.gitlabci.plugin.language.lexer;

import com.intellij.lexer.FlexAdapter;

public class GitlabYamlLexerAdapter extends FlexAdapter {

    public GitlabYamlLexerAdapter() {
        super(new GitlabYamlLexer(null));
    }
}