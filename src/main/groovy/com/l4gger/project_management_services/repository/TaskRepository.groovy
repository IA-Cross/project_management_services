package com.l4gger.project_management_services.repository

import com.l4gger.project_management_services.model.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository extends JpaRepository<Task, Long>{

}