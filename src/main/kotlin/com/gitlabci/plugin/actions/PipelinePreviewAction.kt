package com.gitlabci.plugin.actions

import com.gitlabci.plugin.windows.pipeline.PipelinePreviewWindowFactory
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class PipelinePreviewAction : AnAction() {
    override fun update(e: AnActionEvent) {
        super.update(e)
    }

    override fun actionPerformed(e: AnActionEvent) {
//        val pipelinePreviewWindowFactory = PipelinePreviewWindowFactory()
//        pipelinePreviewWindowFactory.createToolWindowContent(e.project, toolWindow = e.)
    }
}