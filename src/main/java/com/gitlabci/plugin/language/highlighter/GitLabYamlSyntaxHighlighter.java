package com.gitlabci.plugin.language.highlighter;

import com.gitlabci.plugin.language.lexer.GitLabYamlSyntaxHighlighterLexerAdapter;
import com.gitlabci.plugin.language.psi.GitLabYamlTokenTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;



public class GitLabYamlSyntaxHighlighter extends SyntaxHighlighterBase implements GitLabYamlTokenTypes {
    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<>();

    static {
        ATTRIBUTES.put(STRING, GitLabYamlHighlighter.STRING);
        ATTRIBUTES.put(COLON, GitLabYamlHighlighter.SIGN);
        ATTRIBUTES.put(COMMA, GitLabYamlHighlighter.SIGN);
        ATTRIBUTES.put(DASH, GitLabYamlHighlighter.SIGN);
        ATTRIBUTES.put(LBRACKET, GitLabYamlHighlighter.SIGN);
        ATTRIBUTES.put(RBRACKET, GitLabYamlHighlighter.SIGN);
        ATTRIBUTES.put(COMMENT, GitLabYamlHighlighter.COMMENT);
        ATTRIBUTES.put(ID, GitLabYamlHighlighter.ID);
        ATTRIBUTES.put(INT, GitLabYamlHighlighter.INT);
    }

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new GitLabYamlSyntaxHighlighterLexerAdapter();
    }

    @Override
    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return SyntaxHighlighterBase.pack(ATTRIBUTES.get(tokenType));
    }

}
