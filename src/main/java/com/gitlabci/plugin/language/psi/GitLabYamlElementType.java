package com.gitlabci.plugin.language.psi;

import com.gitlabci.plugin.language.GitLabYamlLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;


public class GitLabYamlElementType extends IElementType {

    public GitLabYamlElementType(@NonNls @NotNull String debugName) {
        super(debugName, GitLabYamlLanguage.INSTANCE);
    }
}