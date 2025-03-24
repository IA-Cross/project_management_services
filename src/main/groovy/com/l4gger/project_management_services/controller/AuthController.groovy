package com.l4gger.project_management_services.controller

import com.l4gger.project_management_services.model.User
import com.l4gger.project_management_services.service.AuthService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController {
    private final AuthService authService

    AuthController(AuthService authService) {
        this.authService = authService
    }

    @PostMapping("/register")
    String register(@RequestBody User user) {
        return authService.register(user)
    }

    @PostMapping("/login")
    String login(@RequestBody Map<String, String> credentials) {
        return authService.login(credentials.email, credentials.password)
    }
}
