package com.gitlabci.plugin.language.psi;

import com.gitlabci.plugin.language.GitlabYamlFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;

public class GitlabYamlElementFactory {

    public static GitlabYamlIdentifier createProperty(Project project, String name) {
        GitlabYamlFile file = createFile(project, name);
        return (GitlabYamlIdentifier) file.getFirstChild();
    }

    public static GitlabYamlFile createFile(Project project, String text) {
        String name = "gitlabyaml";
        return (GitlabYamlFile) PsiFileFactory.getInstance(project).createFileFromText(name, GitlabYamlFileType.INSTANCE, text);
    }
}
