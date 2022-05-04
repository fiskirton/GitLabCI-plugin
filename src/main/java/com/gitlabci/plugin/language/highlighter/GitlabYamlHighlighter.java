package com.gitlabci.plugin.language.highlighter;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import org.jetbrains.annotations.NonNls;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public final class GitlabYamlHighlighter {
    @NonNls
    static final String STRING_ID = "STRING";
    @NonNls
    static final String SIGN_ID = "SIGN";
    @NonNls
    static final String COMMENT_ID = "COMMENT";
    @NonNls
    static final String ID_ID = "ID";
    @NonNls
    static final String INT_ID = "INT";

    public static final TextAttributesKey STRING = createTextAttributesKey(STRING_ID, DefaultLanguageHighlighterColors.STRING);

    public static final TextAttributesKey SIGN = createTextAttributesKey(SIGN_ID, DefaultLanguageHighlighterColors.OPERATION_SIGN);

    public static final TextAttributesKey COMMENT = createTextAttributesKey(COMMENT_ID, DefaultLanguageHighlighterColors.LINE_COMMENT);

    public static final TextAttributesKey ID = createTextAttributesKey(ID_ID, DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey INT = createTextAttributesKey(INT_ID, DefaultLanguageHighlighterColors.NUMBER);

}
