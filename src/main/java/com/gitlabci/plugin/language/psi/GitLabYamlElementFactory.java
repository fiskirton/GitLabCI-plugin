package com.gitlabci.plugin.language.psi;

import com.gitlabci.plugin.language.GitLabYamlFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;

public class GitLabYamlElementFactory {

    public static GitLabYamlIdentifier createProperty(Project project, String name) {
        GitLabYamlFile file = createFile(project, name);
        return (GitLabYamlIdentifier) file.getFirstChild();
    }

    public static GitLabYamlFile createFile(Project project, String text) {
        String name = "gitlabyaml";
        return (GitLabYamlFile) PsiFileFactory.getInstance(project).createFileFromText(name, GitLabYamlFileType.INSTANCE, text);
    }
}
