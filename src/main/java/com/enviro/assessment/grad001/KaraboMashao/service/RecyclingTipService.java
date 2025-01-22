package com.enviro.assessment.grad001.KaraboMashao.service;

import com.enviro.assessment.grad001.KaraboMashao.exceptions.NotFoundExceptions;
import com.enviro.assessment.grad001.KaraboMashao.model.WasteType;
import com.enviro.assessment.grad001.KaraboMashao.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.KaraboMashao.repository.WasteTypeRepository;
import com.enviro.assessment.grad001.KaraboMashao.model.RecyclingTip;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RecyclingTipService {

    private final RecyclingTipRepository recyclingTipRepository;
    private final WasteTypeRepository wasteTypeRepository;

    public RecyclingTipService(RecyclingTipRepository recyclingTipRepository, WasteTypeRepository wasteTypeRepository){
        this.recyclingTipRepository = recyclingTipRepository;
        this.wasteTypeRepository = wasteTypeRepository;
    }

    public List<RecyclingTip> findAllRecyclingTips(){
        return recyclingTipRepository.findAll();
    }

    public RecyclingTip findRecyclingTipById(int id){
        return recyclingTipRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions("Recycling tip not found with id: " + id));
    }

    public RecyclingTip saveRecyclingTip(RecyclingTip recyclingTip){
        return recyclingTipRepository.save(recyclingTip);
    }

    public RecyclingTip updateRecyclingTip(int id, RecyclingTip updateRecyclingTip){
        RecyclingTip existingRecyclingTip = recyclingTipRepository.findById(updateRecyclingTip.getTipId())
                .orElseThrow(() -> new NotFoundExceptions("Recycling tip not found with id: " + id));

        WasteType existingWasteType = wasteTypeRepository.findById(updateRecyclingTip.getWasteType().getWasteId())
                .orElseThrow(() -> new NotFoundExceptions("Waste tip not found with id: " + id));

        existingRecyclingTip.setTipDescription(updateRecyclingTip.getTipDescription());
        existingRecyclingTip.setMaterial(updateRecyclingTip.getMaterial());
        existingRecyclingTip.setAdditionalInfo(updateRecyclingTip.getAdditionalInfo());
        existingRecyclingTip.setWasteType(updateRecyclingTip.getWasteType());

        return recyclingTipRepository.save(existingRecyclingTip);
    }

    public void deleteRecyclingTipById(int id){
        RecyclingTip recyclingTip = recyclingTipRepository.findById(id)
                        .orElseThrow(() -> new NotFoundExceptions("Recycling tip not found with id: " + id));
        recyclingTipRepository.deleteById(id);
    }
}
