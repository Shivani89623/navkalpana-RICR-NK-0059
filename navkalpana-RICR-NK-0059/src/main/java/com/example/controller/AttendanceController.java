package com.example.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.AttendanceRequestDTO;
import com.example.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> markAttendance(@RequestBody AttendanceRequestDTO dto){
        service.markAttendance(dto);
        return ResponseEntity.ok("Attendance marked successfully");
    }

    @PutMapping("/{sessionId}")
    public ResponseEntity<String> editAttendance(@PathVariable Long sessionId,
                                                 @RequestBody AttendanceRequestDTO dto){
        service.updateAttendance(sessionId, dto);
        return ResponseEntity.ok("Attendance updated successfully");
    }
  
}