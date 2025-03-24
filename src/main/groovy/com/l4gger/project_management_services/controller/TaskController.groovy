package com.l4gger.project_management_services.controller

import com.l4gger.project_management_services.model.Task
import com.l4gger.project_management_services.repository.TaskRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tasks")
class TaskController {
    private final TaskRepository taskRepository

    TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository
    }

    @GetMapping
    List<Task> getAllTasks(){
        return taskRepository.findAll()
    }

    @PostMapping
    Task createTask(@RequestBody Task task){
        return taskRepository.save(task)
    }
}
