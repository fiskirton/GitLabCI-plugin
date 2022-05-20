package com.gitlabci.plugin.language.pasrser;

import com.gitlabci.plugin.language.GitLabYamlLanguage;
import com.gitlabci.plugin.language.lexer.GitLabYamlLexerAdapter;
import com.gitlabci.plugin.language.parser.GitLabYamlParser;
import com.gitlabci.plugin.language.psi.GitLabYamlFile;
import com.gitlabci.plugin.language.psi.GitLabYamlTokenTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public class GitLabYamlParserDefinition implements ParserDefinition {

    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(GitLabYamlTokenTypes.COMMENT);
    public static final TokenSet STRING_LITERAL = TokenSet.create(GitLabYamlTokenTypes.STRING);


    public static final IFileElementType FILE = new IFileElementType(GitLabYamlLanguage.INSTANCE);

    @Override
    public @NotNull Lexer createLexer(Project project) {
        return new GitLabYamlLexerAdapter();
    }

    @NotNull
    @Override
    public PsiParser createParser(Project project) {
        return new GitLabYamlParser();
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }


    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return STRING_LITERAL;
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode node) {
        return GitLabYamlTokenTypes.Factory.createElement(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new GitLabYamlFile(viewProvider);
    }
}
