package com.enviro.assessment.grad001.KaraboMashao.service;

import com.enviro.assessment.grad001.KaraboMashao.model.Category;
import com.enviro.assessment.grad001.KaraboMashao.model.WasteType;
import com.enviro.assessment.grad001.KaraboMashao.repository.CategoryRepository;
import com.enviro.assessment.grad001.KaraboMashao.repository.WasteTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteTypeService {

    private final WasteTypeRepository wasteTypeRepository;
    private final CategoryRepository categoryRepository;

    public WasteTypeService(WasteTypeRepository wasteTypeRepository, CategoryRepository categoryRepository) {
        this.wasteTypeRepository = wasteTypeRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<WasteType> findAllWasteTypes() {
        return wasteTypeRepository.findAll();
    }

    public WasteType findWasteTypeById(int id) {
        return wasteTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("WasteType not found with id: " + id));
    }

    public List<WasteType> findWasteTypesByCategory(String wasteCategory) {
        // Assuming "findByCategory_WasteCategory" is a valid query in WasteTypeRepository
        return wasteTypeRepository.findByCategory_WasteCategory(wasteCategory);
    }

    public WasteType createWasteType(WasteType wasteType) {
        // Validate that the category exists
        Category category = categoryRepository.findById(wasteType.getCategory().getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        wasteType.setCategory(category);
        return wasteTypeRepository.save(wasteType);
    }

    public WasteType updateWasteType(int id, WasteType wasteType) {
        WasteType existingWasteType = wasteTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("WasteType not found with id: " + id));

        existingWasteType.setTypeOfWaste(wasteType.getTypeOfWaste());
        existingWasteType.setWasteExample(wasteType.getWasteExample());

        Category category = categoryRepository.findById(wasteType.getCategory().getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        existingWasteType.setCategory(category);
        return wasteTypeRepository.save(existingWasteType);
    }

    public void deleteWasteType(int id) {
        WasteType wasteType = wasteTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("WasteType not found with id: " + id));
        wasteTypeRepository.delete(wasteType);
    }
}