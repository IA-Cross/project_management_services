package com.l4gger.project_management_services.controller

import com.l4gger.project_management_services.model.User
import com.l4gger.project_management_services.repository.UserRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController {
    private final UserRepository userRepository

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository
    }

    @GetMapping
    List<User> getAllUsers() {
        return userRepository.findAll()
    }

    @PutMapping("/{id}/promote")
    User promoteToAdmin(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"))
        user.role = Role.ADMIN
        return userRepository.save(user)
    }
}