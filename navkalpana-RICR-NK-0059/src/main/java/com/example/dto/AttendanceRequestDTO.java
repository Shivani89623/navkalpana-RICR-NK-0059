package com.example.dto;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;
@Data
public class AttendanceRequestDTO {
    private Long batchId;
    private String moduleName;
    private LocalDate sessionDate;
    private String remarks;
    private List<StudentAttendanceDTO> students;

    // Getters and Setters
}