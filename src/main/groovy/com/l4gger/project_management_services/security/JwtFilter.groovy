package com.l4gger.project_management_services.security

import com.l4gger.project_management_services.model.Role
import com.l4gger.project_management_services.model.User
import com.l4gger.project_management_services.repository.UserRepository
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtFilter extends OncePerRequestFilter{
    private final JwtUtil jwtUtil
    private final UserRepository userRepository

    JwtFilter(JwtUtil jwtUtil, UserRepository userRepository){
        this.jwtUtil = jwtUtil
        this.userRepository = userRepository
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String header = request.getHeader("Authorization")
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response)
            return
        }

        String token = header.substring(7)
        if (!jwtUtil.validateToken(token)) {
            chain.doFilter(request, response)
            return
        }

        String email = jwtUtil.getEmailFromToken(token)
        Role role = jwtUtil.getRoleFromToken(token)

        UserDetails userDetails = new User(email, "", [new SimpleGrantedAuthority(role.name())])
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities())

        SecurityContextHolder.getContext().setAuthentication(authentication)
        chain.doFilter(request, response)
    }

}
