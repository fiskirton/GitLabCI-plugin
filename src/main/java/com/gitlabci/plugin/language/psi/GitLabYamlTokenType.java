package com.gitlabci.plugin.language.psi;

import com.gitlabci.plugin.language.GitLabYamlLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class GitLabYamlTokenType extends IElementType {
    public GitLabYamlTokenType(@NonNls @NotNull String debugName) {
        super(debugName, GitLabYamlLanguage.INSTANCE);
    }

    public String toString() {
        return super.toString();
    }
}