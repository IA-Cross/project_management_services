package com.l4gger.project_management_services.service

import com.l4gger.project_management_services.model.Role
import com.l4gger.project_management_services.model.User
import com.l4gger.project_management_services.repository.UserRepository
import com.l4gger.project_management_services.security.JwtUtil
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService {
    private final UserRepository userRepository
    private final JwtUtil jwtUtil
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder()

    AuthService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository
        this.jwtUtil = jwtUtil
    }

    String register(User user) {
        user.password = passwordEncoder.encode(user.password)
        user.role = Role.USER // Default role
        userRepository.save(user)
        return jwtUtil.generateToken(user.email)
    }

    String login(String email, String password) {
        User user = userRepository.findByEmail(email)
        if (user && passwordEncoder.matches(password, user.password)) {
            return jwtUtil.generateToken(email)
        }
        throw new RuntimeException("Invalid credentials")
    }
}
