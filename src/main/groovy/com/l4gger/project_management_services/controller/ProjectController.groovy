package com.l4gger.project_management_services.controller

import com.l4gger.project_management_services.model.Project
import com.l4gger.project_management_services.repository.ProjectRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/projects")
class ProjectController {
    private final ProjectRepository projectRepository

    ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository
    }

    @GetMapping
    List<Project> getAllProjects() {
        return projectRepository.findAll()
    }

    @PostMapping
    Project createProject(@RequestBody Project project) {
        return projectRepository.save(project)
    }
}