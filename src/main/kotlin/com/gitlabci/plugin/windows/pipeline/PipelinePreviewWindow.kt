package com.gitlabci.plugin.windows.pipeline

import com.intellij.openapi.wm.ToolWindow
import javax.swing.JPanel

class PipelinePreviewWindow(toolWindow: ToolWindow) {
    private var pipelinePreviewWindowContent: JPanel = JPanel()

    fun getContent(): JPanel {
        return pipelinePreviewWindowContent
    }
}