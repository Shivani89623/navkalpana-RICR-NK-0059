
package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.dto.AttendanceRequestDTO;
import com.example.dto.StudentAttendanceDTO;
import com.example.model.AttendanceRecord;
import com.example.model.AttendanceSession;
import com.example.repository.AttendanceRecordRepository;
import com.example.repository.AttendanceSessionRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class AttendanceService {

    private final AttendanceSessionRepository sessionRepository;
    private final AttendanceRecordRepository recordRepository;

    public AttendanceService(AttendanceSessionRepository sessionRepository,
                             AttendanceRecordRepository recordRepository) {
        this.sessionRepository = sessionRepository;
        this.recordRepository = recordRepository;
    }

    @Transactional
    public void markAttendance(AttendanceRequestDTO dto) {
        if(dto.getRemarks() == null || dto.getRemarks().isBlank()){
            throw new RuntimeException("Remarks mandatory");
        }

        AttendanceSession session = AttendanceSession.builder()
                .batchId(dto.getBatchId())
                .moduleName(dto.getModuleName())
                .sessionDate(dto.getSessionDate())
                .remarks(dto.getRemarks())
                .createdAt(LocalDateTime.now())
                .build();

        sessionRepository.save(session);

        for(StudentAttendanceDTO s : dto.getStudents()){
            AttendanceRecord record = AttendanceRecord.builder()
                    .studentId(s.getStudentId())
                    .status(s.getStatus())
                    .markedAt(LocalDateTime.now())
                    .session(session)
                    .build();

            recordRepository.save(record);
        }
    }

    @Transactional
    public void updateAttendance(Long sessionId, AttendanceRequestDTO dto){
        AttendanceSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        if(!session.getSessionDate().equals(LocalDate.now())){
            throw new RuntimeException("Edit allowed only on same date");
        }

        if(session.getCreatedAt().plusMinutes(10).isBefore(LocalDateTime.now())){
            throw new RuntimeException("Edit window expired");
        }

        session.setRemarks(dto.getRemarks());
        sessionRepository.save(session);

        // Update records
        for(StudentAttendanceDTO s : dto.getStudents()){
            recordRepository.findById(s.getStudentId()).ifPresent(record -> {
                record.setStatus(s.getStatus());
                recordRepository.save(record);
            });
        }
    }
}