package com.gitlabci.plugin.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import icons.GitLabYamlPluginIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GitLabYamlFileType extends LanguageFileType {

    public static final GitLabYamlFileType INSTANCE = new GitLabYamlFileType();

    private GitLabYamlFileType() {
        super(GitLabYamlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "GitLab YAML File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "GitLab YAML File";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "gitlab-ci.yml";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return GitLabYamlPluginIcons.GitLabYamlIcon;
    }

}