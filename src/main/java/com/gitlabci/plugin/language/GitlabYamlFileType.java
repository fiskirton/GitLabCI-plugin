package com.gitlabci.plugin.language;

import icons.GitlabCIPluginIcons;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;

public class GitlabYamlFileType extends LanguageFileType {

    public static final GitlabYamlFileType INSTANCE = new GitlabYamlFileType();

    private GitlabYamlFileType() {
        super(GitlabYamlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Gitlab YAML File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Gitlab YAML File";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "gitlab-ci.yml";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return GitlabCIPluginIcons.GitlabYamlIcon;
    }

}