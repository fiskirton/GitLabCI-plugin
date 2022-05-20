package com.gitlabci.plugin.language.psi;

import com.gitlabci.plugin.language.GitLabYamlFileType;
import com.gitlabci.plugin.language.GitLabYamlLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class GitLabYamlFile extends PsiFileBase {
    public GitLabYamlFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, GitLabYamlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return GitLabYamlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "GitLab YAML File";
    }
}
