package com.example.dto;

import com.example.model.AttendanceStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAttendanceDTO {
    private Long studentId;
    private AttendanceStatus status;

    // Getters and Setters
}