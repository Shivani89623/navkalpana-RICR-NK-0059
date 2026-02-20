

package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "batch")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Batch Name
    @Column(nullable = false)
    private String name;

    // Batch Type (Online / Offline)
    private String type;

    // Total Students in Batch
    @Column(name = "total_students")
    private Integer totalStudents;

    // Progress Percentage
    private Integer progress;

    // Batch Status
    @Enumerated(EnumType.STRING)
    private BatchStatus status;

    // Optional Dates
    private LocalDate startDate;
    private LocalDate endDate;
}