package com.github.fiskirton.gitlabciplugin.services

import com.intellij.openapi.project.Project
import com.github.fiskirton.gitlabciplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
