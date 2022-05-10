package com.gitlabci.plugin.language.psi.impl;

import com.gitlabci.plugin.language.GitlabYamlLanguage;
import com.gitlabci.plugin.language.psi.GitlabYamlFile;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;

public class GitlabYamlElementTextFactory {
    public static PsiElement createStatementFromText(Project project, String name) {
        GitlabYamlFile fileFromText = createFileFromText(project, name);
        return fileFromText.getFirstChild().getFirstChild();
    }

    private static GitlabYamlFile createFileFromText(Project project, String text) {
        return (GitlabYamlFile) PsiFileFactory.getInstance(project).createFileFromText("GitlabYaml", GitlabYamlLanguage.INSTANCE, text);
    }


}
