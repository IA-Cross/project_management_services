package com.l4gger.project_management_services.model

import jakarta.persistence.*

@Entity
@Table(name = "tasks")
class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String title
    String description
    String status  // Pending, In Progress, Completed

    @ManyToOne
    @JoinColumn(name = "project_id")
    Project project
}
