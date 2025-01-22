package com.enviro.assessment.grad001.KaraboMashao.controller;

import com.enviro.assessment.grad001.KaraboMashao.model.RecyclingTip;
import com.enviro.assessment.grad001.KaraboMashao.service.RecyclingTipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    private final RecyclingTipService recyclingTipService;

    public RecyclingTipController(RecyclingTipService recyclingTipService) {
        this.recyclingTipService = recyclingTipService;
    }

    // Get all recycling tips
    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips() {
        List<RecyclingTip> tips = recyclingTipService.findAllRecyclingTips();
        return ResponseEntity.ok(tips);
    }

    // Get a recycling tip by ID
    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable int id) {
        RecyclingTip tip = recyclingTipService.findRecyclingTipById(id);
        return ResponseEntity.ok(tip);
    }

    // Create a new recycling tip
    @PostMapping
    public ResponseEntity<RecyclingTip> createRecyclingTip(@RequestBody RecyclingTip recyclingTip) {
        RecyclingTip savedTip = recyclingTipService.saveRecyclingTip(recyclingTip);
        return ResponseEntity.status(201).body(savedTip);
    }

    // Update an existing recycling tip
    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable int id, @RequestBody RecyclingTip recyclingTip) {
        RecyclingTip updatedTip = recyclingTipService.updateRecyclingTip(id, recyclingTip);
        return ResponseEntity.ok(updatedTip);
    }

    // Delete a recycling tip by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable int id) {
        recyclingTipService.deleteRecyclingTipById(id);
        return ResponseEntity.noContent().build();
    }
}
