package com.l4gger.project_management_services.repository

import com.l4gger.project_management_services.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository extends JpaRepository<User,Long>{
    User findByEmail(String email);
}