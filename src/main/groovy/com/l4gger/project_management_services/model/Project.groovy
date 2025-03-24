package com.l4gger.project_management_services.model

import jakarta.persistence.*

@Entity
@Table(name = "projects")
class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String name

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user
}
