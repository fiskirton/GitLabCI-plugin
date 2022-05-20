package com.gitlabci.plugin.language.psi.impl;

import com.gitlabci.plugin.language.psi.GitLabYamlNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class GitLabYamlNamedElementImpl extends ASTWrapperPsiElement implements GitLabYamlNamedElement {
    public GitLabYamlNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
