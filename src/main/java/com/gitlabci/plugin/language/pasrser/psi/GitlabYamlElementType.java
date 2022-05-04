package com.gitlabci.plugin.language.pasrser.psi;

import com.gitlabci.plugin.language.GitlabYamlLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;


public class GitlabYamlElementType extends IElementType {

    public GitlabYamlElementType(@NonNls @NotNull String debugName) {
        super(debugName, GitlabYamlLanguage.INSTANCE);
    }
}