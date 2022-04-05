package com.github.fiskirton.gitlabciplugin.language

import com.intellij.openapi.fileTypes.LanguageFileType
import icons.GitlabCIPluginIcons
import javax.swing.Icon

class GitlabYamlFileType private constructor() : LanguageFileType(GitlabYamlLanguage.INSTANCE) {
    override fun getName(): String {
        return "Gitlab YAML File"
    }

    override fun getDescription(): String {
        return "Gitlab YAML File"
    }

    override fun getDefaultExtension(): String {
        return "gitlab-ci.yml"
    }

    override fun getIcon(): Icon {
        return GitlabCIPluginIcons.GitlabYamlIcon
    }

    companion object {
        val INSTANCE = GitlabYamlFileType()
    }
}