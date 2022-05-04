package com.gitlabci.plugin.language.highlighter;

import com.gitlabci.plugin.language.lexer.GitlabYamlLexerAdapter;

import com.gitlabci.plugin.language.lexer.GitlabYamlSyntaxHighlighterLexerAdapter;
import com.gitlabci.plugin.language.psi.GitlabYamlTokenTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;



public class GitlabYamlSyntaxHighlighter extends SyntaxHighlighterBase implements GitlabYamlTokenTypes {
    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<>();

    static {
        ATTRIBUTES.put(COLON_SEPARATED, GitlabYamlHighlighter.STRING);
        ATTRIBUTES.put(UNQUOTED_STRING, GitlabYamlHighlighter.STRING);
        ATTRIBUTES.put(STRING, GitlabYamlHighlighter.STRING);
        ATTRIBUTES.put(COLON, GitlabYamlHighlighter.SIGN);
        ATTRIBUTES.put(COMMA, GitlabYamlHighlighter.SIGN);
        ATTRIBUTES.put(DASH, GitlabYamlHighlighter.SIGN);
        ATTRIBUTES.put(LBRACKET, GitlabYamlHighlighter.SIGN);
        ATTRIBUTES.put(RBRACKET, GitlabYamlHighlighter.SIGN);
        ATTRIBUTES.put(COMMENT, GitlabYamlHighlighter.COMMENT);
        ATTRIBUTES.put(ID, GitlabYamlHighlighter.ID);
        ATTRIBUTES.put(INT, GitlabYamlHighlighter.INT);
    }

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new GitlabYamlSyntaxHighlighterLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        return SyntaxHighlighterBase.pack(ATTRIBUTES.get(tokenType));
    }

}
