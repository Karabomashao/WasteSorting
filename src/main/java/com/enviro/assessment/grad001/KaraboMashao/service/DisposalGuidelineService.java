package com.enviro.assessment.grad001.KaraboMashao.service;

import com.enviro.assessment.grad001.KaraboMashao.model.DisposalGuideline;
import com.enviro.assessment.grad001.KaraboMashao.model.WasteType;
import com.enviro.assessment.grad001.KaraboMashao.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.KaraboMashao.repository.WasteTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DisposalGuidelineService {

    private final DisposalGuidelineRepository disposalGuidelineRepository;
    private final WasteTypeRepository wasteTypeRepository;

    public DisposalGuidelineService(
            DisposalGuidelineRepository disposalGuidelineRepository,
            WasteTypeRepository wasteTypeRepository) {
        this.disposalGuidelineRepository = disposalGuidelineRepository;
        this.wasteTypeRepository = wasteTypeRepository;
    }

    public List<DisposalGuideline> findAllGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    public DisposalGuideline findGuidelineById(int id) {
        return disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disposal Guideline not found with id: " + id));
    }

    public DisposalGuideline createDisposalGuideline(DisposalGuideline guideline) {
        WasteType wasteType = wasteTypeRepository.findById(guideline.getWasteType().getWasteId())
                .orElseThrow(() -> new RuntimeException("WasteType not found"));

        return disposalGuidelineRepository.save(guideline);
    }

    public DisposalGuideline updateDisposalGuideline(int id, DisposalGuideline updatedGuideline) {
        DisposalGuideline existingGuideline = disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disposal Guideline not found with id: " + id));

        WasteType wasteType = wasteTypeRepository.findById(updatedGuideline.getWasteType().getWasteId())
                .orElseThrow(() -> new IllegalArgumentException("WasteType not found"));

        existingGuideline.setDisposalMethod(updatedGuideline.getDisposalMethod());
        existingGuideline.setLocation(updatedGuideline.getLocation());
        existingGuideline.setWasteType(wasteType);

        return disposalGuidelineRepository.save(existingGuideline);
    }

    public void deleteDisposalGuideline(int id) {
        DisposalGuideline guideline = disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disposal Guideline not found with id: " + id));
        disposalGuidelineRepository.delete(guideline);
    }
}

