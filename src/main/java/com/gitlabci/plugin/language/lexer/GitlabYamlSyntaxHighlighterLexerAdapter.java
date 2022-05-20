package com.gitlabci.plugin.language.lexer;

import com.intellij.lexer.FlexAdapter;

public class GitLabYamlSyntaxHighlighterLexerAdapter extends FlexAdapter {

    public GitLabYamlSyntaxHighlighterLexerAdapter() {
        super(new GitLabYamlSyntaxHighlighterLexer(null));
    }
}