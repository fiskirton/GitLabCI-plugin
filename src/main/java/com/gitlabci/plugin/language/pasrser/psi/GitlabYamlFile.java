package com.gitlabci.plugin.language.pasrser.psi;

import com.gitlabci.plugin.language.GitlabYamlFileType;
import com.gitlabci.plugin.language.GitlabYamlLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class GitlabYamlFile extends PsiFileBase {
    public GitlabYamlFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, GitlabYamlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return GitlabYamlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Gitlab YAML File";
    }
}
