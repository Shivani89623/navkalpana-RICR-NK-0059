package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dto.DashboardSummaryDTO;

import com.example.model.Batch;
import com.example.repository.BatchRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final BatchRepository batchRepository;

    public DashboardSummaryDTO getSummary() {

        long activeCourses = batchRepository.count();
        long totalStudents = batchRepository.findAll()
                .stream()
                .mapToLong(Batch::getTotalStudents)
                .sum();

        long pendingAssignments = 5; // dummy for now

        return new DashboardSummaryDTO(
                totalStudents,
                activeCourses,
                pendingAssignments
        );
    }
}