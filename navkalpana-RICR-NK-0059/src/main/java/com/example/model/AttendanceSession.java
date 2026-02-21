package com.example.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Entity
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long batchId;
    private String moduleName;
    private LocalDate sessionDate;

    @Column(nullable = false)
    private String remarks;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
}