package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Batch;
import com.example.model.BatchStatus;
import com.example.repository.BatchRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BatchService {

    private final BatchRepository batchRepository;

    public Batch createBatch(Batch batch) {
        return batchRepository.save(batch);
    }

    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    public List<Batch> getByStatus(BatchStatus status) {
        return batchRepository.findByStatus(status);
    }

    public Batch updateBatch(Long id, Batch updatedBatch) {
        Batch batch = batchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        batch.setName(updatedBatch.getName());
        batch.setType(updatedBatch.getType());
        batch.setTotalStudents(updatedBatch.getTotalStudents());
        batch.setProgress(updatedBatch.getProgress());
        batch.setStatus(updatedBatch.getStatus());

        return batchRepository.save(batch);
    }

    public void deleteBatch(Long id) {
        batchRepository.deleteById(id);
    }
}