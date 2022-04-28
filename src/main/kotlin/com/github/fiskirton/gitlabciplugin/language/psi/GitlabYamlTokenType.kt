package com.github.fiskirton.gitlabciplugin.language.psi

import com.github.fiskirton.gitlabciplugin.language.GitlabYamlLanguage
import com.intellij.psi.tree.IElementType

import org.jetbrains.annotations.NonNls

class GitlabYamlTokenType(debugName: @NonNls String) : IElementType(debugName, GitlabYamlLanguage.INSTANCE) {
    override fun toString(): String {
        return "GitlabKeywordTokenType." + super.toString()
    }
}