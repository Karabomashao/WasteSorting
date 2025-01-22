package com.enviro.assessment.grad001.KaraboMashao.service;

import com.enviro.assessment.grad001.KaraboMashao.dto.CategoryDTO;
import com.enviro.assessment.grad001.KaraboMashao.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.KaraboMashao.dto.WasteTypeDTO;
import com.enviro.assessment.grad001.KaraboMashao.model.Category;
import com.enviro.assessment.grad001.KaraboMashao.model.DisposalGuideline;
import com.enviro.assessment.grad001.KaraboMashao.model.WasteType;
import com.enviro.assessment.grad001.KaraboMashao.repository.CategoryRepository;
import com.enviro.assessment.grad001.KaraboMashao.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.KaraboMashao.repository.WasteTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    // Fetch all guidelines as DTOs
    public List<DisposalGuidelineDTO> findAllGuidelines() {
        List<DisposalGuideline> guidelines = disposalGuidelineRepository.findAll();
        return guidelines.stream()
                .map(this::mapToDto) // Use the mapping method here
                .collect(Collectors.toList());
    }

    // Fetch a specific guideline by ID as a DTO
    public DisposalGuidelineDTO findGuidelineById(int id) {
        DisposalGuideline guideline = disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disposal Guideline not found with id: " + id));
        return mapToDto(guideline);
    }

    // Create a new guideline
    public DisposalGuideline createDisposalGuideline(DisposalGuideline guideline) {
        WasteType wasteType = wasteTypeRepository.findById(guideline.getWasteType().getWasteId())
                .orElseThrow(() -> new RuntimeException("WasteType not found"));
        guideline.setWasteType(wasteType);

        Category category = categoryRepository.findById(guideline.getCategory().getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        guideline.setCategory(category);

        return disposalGuidelineRepository.save(guideline);
    }

    // Update an existing guideline
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

    // Delete a guideline
    public void deleteDisposalGuideline(int id) {
        DisposalGuideline guideline = disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disposal Guideline not found with id: " + id));
        disposalGuidelineRepository.delete(guideline);
    }

    // Map DisposalGuideline entity to DTO
    public DisposalGuidelineDTO mapToDto(DisposalGuideline guideline) {
        DisposalGuidelineDTO dto = new DisposalGuidelineDTO();
        dto.setDisposalGuidelineId(guideline.getDisposalGuidelineId());
        dto.setDisposalMethod(guideline.getDisposalMethod());
        dto.setLocation(guideline.getLocation());

        WasteTypeDTO wasteTypeDTO = new WasteTypeDTO();
        wasteTypeDTO.setWasteId(guideline.getWasteType().getWasteId());
        wasteTypeDTO.setTypeOfWaste(guideline.getWasteType().getTypeOfWaste());
        wasteTypeDTO.setWasteExample(guideline.getWasteType().getWasteExample());
        dto.setWasteType(wasteTypeDTO);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(guideline.getCategory().getCategoryId());
        categoryDTO.setWasteCategory(guideline.getCategory().getWasteCategory());
        categoryDTO.setDescription(guideline.getCategory().getDescription());
        dto.setCategory(categoryDTO);

        return dto;
    }

    public DisposalGuideline mapToEntity(DisposalGuidelineDTO dto) {
        DisposalGuideline guideline = new DisposalGuideline();
        guideline.setDisposalMethod(dto.getDisposalMethod());
        guideline.setLocation(dto.getLocation());

        WasteType wasteType = wasteTypeRepository.findById(dto.getWasteType().getWasteId())
                .orElseThrow(() -> new RuntimeException("WasteType not found"));
        guideline.setWasteType(wasteType);

        Category category = categoryRepository.findById(dto.getCategory().getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        guideline.setCategory(category);

        return guideline;
    }
}
