package com.enviro.assessment.grad001.KaraboMashao.controller;

import com.enviro.assessment.grad001.KaraboMashao.dto.DisposalGuidelineDTO;
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

    @Autowired
    private DisposalGuidelineService service;

    // Get all disposal guidelines

    @GetMapping
    public List<DisposalGuidelineDTO> getAllDisposalGuidelines() {
        return service.findAllGuidelines();
    }

    @GetMapping("/{id}")
    public DisposalGuidelineDTO getDisposalGuidelineById(@PathVariable int id) {
        return service.findGuidelineById(id);
    }

    // Create a new disposal guideline
    @PostMapping
    public DisposalGuidelineDTO createDisposalGuideline(@RequestBody DisposalGuidelineDTO dto) {
        DisposalGuideline guideline = service.mapToEntity(dto);
        return service.mapToDto(service.createDisposalGuideline(guideline));
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