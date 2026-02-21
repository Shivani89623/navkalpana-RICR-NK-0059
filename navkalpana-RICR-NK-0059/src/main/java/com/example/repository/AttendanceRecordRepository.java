package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.AttendanceRecord;

import java.util.List;

public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord, Long> {

    @Query("SELECT ar FROM AttendanceRecord ar WHERE ar.session.id = :sessionId")
    List<AttendanceRecord> findBySessionId(Long sessionId);
}