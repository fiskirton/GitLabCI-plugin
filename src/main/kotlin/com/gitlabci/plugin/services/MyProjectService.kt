package com.gitlabci.plugin.services

import com.intellij.openapi.project.Project
import com.gitlabci.plugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
