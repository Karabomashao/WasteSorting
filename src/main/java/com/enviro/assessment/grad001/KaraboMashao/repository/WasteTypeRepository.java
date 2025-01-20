package com.enviro.assessment.grad001.KaraboMashao.repository;

import com.enviro.assessment.grad001.KaraboMashao.model.WasteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WasteTypeRepository extends JpaRepository<WasteType, Integer> {
    List<WasteType> findByCategory_WasteCategory(String wasteCategory);
}