package com.l4gger.project_management_services.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig {
    private final JwtFilter jwtFilter

    SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/auth/**").permitAll()  // Allow registration & login without authentication
                .requestMatchers("/api/auth/login").permitAll()
                .requestMatchers("/api/users/**").hasAuthority("ADMIN")  // Admins only
                .requestMatchers("/api/projects/**", "/api/tasks/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

        return http.build()
    }
}