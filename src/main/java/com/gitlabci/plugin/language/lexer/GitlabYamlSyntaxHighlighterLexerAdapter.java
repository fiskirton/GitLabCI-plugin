package com.gitlabci.plugin.language.lexer;

import com.intellij.lexer.FlexAdapter;

public class GitlabYamlSyntaxHighlighterLexerAdapter extends FlexAdapter {

    public GitlabYamlSyntaxHighlighterLexerAdapter() {
        super(new GitlabYamlSyntaxHighlighterLexer(null));
    }
}