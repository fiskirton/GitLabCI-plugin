package com.gitlabci.plugin.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.psi.PsiFile


class PipelinePreviewAction : AnAction() {
    override fun update(e: AnActionEvent) {
        super.update(e)
    }

    override fun actionPerformed(e: AnActionEvent) {
//        val pipelinePreviewWindowFactory = PipelinePreviewWindowFactory()
//        pipelinePreviewWindowFactory.createToolWindowContent(e.project, toolWindow = e.)
    }
}