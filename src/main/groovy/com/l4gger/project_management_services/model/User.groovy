package com.l4gger.project_management_services.model

import jakarta.persistence.*

enum Role {
    USER, ADMIN
}


@Entity
@Table(name = "users")
@NamedQuery(name = "User.findByEmail",
        query = "select u from User u where u.email = ?1")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String name
    String email
    String password

    @Enumerated(EnumType.STRING)
    Role role
}
