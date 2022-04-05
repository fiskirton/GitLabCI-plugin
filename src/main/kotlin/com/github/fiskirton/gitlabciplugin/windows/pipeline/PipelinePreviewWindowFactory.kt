package com.github.fiskirton.gitlabciplugin.windows.pipeline

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.Content
import com.intellij.ui.content.ContentFactory

class PipelinePreviewWindowFactory : ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val pipelinePreviewWindow = PipelinePreviewWindow(toolWindow)
        val contentFactory = ContentFactory.SERVICE.getInstance()
        val content: Content = contentFactory.createContent(pipelinePreviewWindow.getContent(), "", false)
        toolWindow.contentManager.addContent(content)
    }

}