package com.example.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Batch;
import com.example.model.BatchStatus;
import com.example.service.BatchService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/batches")
@RequiredArgsConstructor
public class BatchController {

    private final BatchService batchService;

    @PostMapping
    public ResponseEntity<Batch> create(@RequestBody Batch batch) {
        return ResponseEntity.ok(batchService.createBatch(batch));
    }

    @GetMapping
    public ResponseEntity<List<Batch>> getAll() {
        return ResponseEntity.ok(batchService.getAllBatches());
    }
    

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Batch>> getByStatus(@PathVariable BatchStatus status) {
        return ResponseEntity.ok(batchService.getByStatus(status));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Batch> update(@PathVariable Long id,
                                        @RequestBody Batch batch) {
        return ResponseEntity.ok(batchService.updateBatch(id, batch));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        batchService.deleteBatch(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
   
}