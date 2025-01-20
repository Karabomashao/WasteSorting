package com.enviro.assessment.grad001.KaraboMashao.controller;

import com.enviro.assessment.grad001.KaraboMashao.model.Category;
import com.enviro.assessment.grad001.KaraboMashao.model.DisposalGuideline;
import com.enviro.assessment.grad001.KaraboMashao.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService disposalGuidelineService;

//    @Autowired
    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
        this.disposalGuidelineService = disposalGuidelineService;
    }

    // Get all disposal guidelines
    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllDisposalGuidelines() {
        List<DisposalGuideline> guidelines = disposalGuidelineService.findAllGuidelines();
        return ResponseEntity.ok(guidelines);
    }

    // Get a specific disposal guideline by ID
    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable int id) {
        DisposalGuideline guideline = disposalGuidelineService.findGuidelineById(id);
        return ResponseEntity.ok(guideline);
    }

    // Create a new disposal guideline
    @PostMapping
    public ResponseEntity<DisposalGuideline> createDisposalGuideline(@RequestBody DisposalGuideline guideline) {
        DisposalGuideline createdGuideline = disposalGuidelineService.createDisposalGuideline(guideline);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGuideline);
    }

    // Update an existing disposal guideline
    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateDisposalGuideline(
            @PathVariable int id,
            @RequestBody DisposalGuideline updatedGuideline) {
        DisposalGuideline guideline = disposalGuidelineService.updateDisposalGuideline(id, updatedGuideline);
        return ResponseEntity.ok(guideline);
    }

    // Delete a disposal guideline
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable int id) {
        disposalGuidelineService.deleteDisposalGuideline(id);
        return ResponseEntity.noContent().build();
    }
}