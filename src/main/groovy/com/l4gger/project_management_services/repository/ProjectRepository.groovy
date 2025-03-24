package com.l4gger.project_management_services.repository

import com.l4gger.project_management_services.model.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository extends JpaRepository<Project, Long>{

}