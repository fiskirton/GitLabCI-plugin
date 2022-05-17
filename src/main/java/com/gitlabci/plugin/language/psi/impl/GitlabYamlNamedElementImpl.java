package com.gitlabci.plugin.language.psi.impl;

import com.gitlabci.plugin.language.psi.GitlabYamlNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class GitlabYamlNamedElementImpl extends ASTWrapperPsiElement implements GitlabYamlNamedElement {
    public GitlabYamlNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
