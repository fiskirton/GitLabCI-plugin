package com.gitlabci.plugin.language.pasrser.psi;

import com.gitlabci.plugin.language.GitlabYamlLanguage;
import com.intellij.psi.tree.IElementType;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class GitlabYamlTokenType extends IElementType {
    public GitlabYamlTokenType(@NonNls @NotNull String debugName) {
        super(debugName, GitlabYamlLanguage.INSTANCE);
    }

    public String toString() {
        return "GitlabKeywordTokenType." + super.toString();
    }
}