package com.enviro.assessment.grad001.KaraboMashao.service;

import com.enviro.assessment.grad001.KaraboMashao.model.Category;
import com.enviro.assessment.grad001.KaraboMashao.model.DisposalGuideline;
import com.enviro.assessment.grad001.KaraboMashao.model.WasteType;
import com.enviro.assessment.grad001.KaraboMashao.repository.CategoryRepository;
import com.enviro.assessment.grad001.KaraboMashao.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.KaraboMashao.repository.WasteTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {

    private final DisposalGuidelineRepository disposalGuidelineRepository;
    private final WasteTypeRepository wasteTypeRepository;
    private final CategoryRepository categoryRepository;

    public DisposalGuidelineService(
            DisposalGuidelineRepository disposalGuidelineRepository,
            WasteTypeRepository wasteTypeRepository,
            CategoryRepository categoryRepository) {
        this.disposalGuidelineRepository = disposalGuidelineRepository;
        this.wasteTypeRepository = wasteTypeRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<DisposalGuideline> findAllGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    public DisposalGuideline findGuidelineById(int id) {
        return disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disposal Guideline not found with id: " + id));
    }

    public DisposalGuideline createDisposalGuideline(DisposalGuideline guideline) {
        // Validate WasteType and Category exist
        WasteType wasteType = wasteTypeRepository.findById(guideline.getWasteType().getWasteId())
                .orElseThrow(() -> new IllegalArgumentException("WasteType not found"));

        Category category = categoryRepository.findById(guideline.getCategory().getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        guideline.setWasteType(wasteType);
        guideline.setCategory(category);

        return disposalGuidelineRepository.save(guideline);
    }

    public DisposalGuideline updateDisposalGuideline(int id, DisposalGuideline updatedGuideline) {
        DisposalGuideline existingGuideline = disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disposal Guideline not found with id: " + id));

        WasteType wasteType = wasteTypeRepository.findById(updatedGuideline.getWasteType().getWasteId())
                .orElseThrow(() -> new IllegalArgumentException("WasteType not found"));

        Category category = categoryRepository.findById(updatedGuideline.getCategory().getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        existingGuideline.setDisposalMethod(updatedGuideline.getDisposalMethod());
        existingGuideline.setLocation(updatedGuideline.getLocation());
        existingGuideline.setWasteType(wasteType);
        existingGuideline.setCategory(category);

        return disposalGuidelineRepository.save(existingGuideline);
    }

    public void deleteDisposalGuideline(int id) {
        DisposalGuideline guideline = disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disposal Guideline not found with id: " + id));
        disposalGuidelineRepository.delete(guideline);
    }
}

