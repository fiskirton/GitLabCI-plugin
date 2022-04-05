package com.github.fiskirton.gitlabciplugin.language

import com.intellij.lang.Language

class GitlabYamlLanguage private constructor() : Language("GitlabYaml") {

    companion object {
        val INSTANCE: GitlabYamlLanguage = GitlabYamlLanguage()
    }}