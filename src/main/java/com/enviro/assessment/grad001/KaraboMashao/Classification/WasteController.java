package com.enviro.assessment.grad001.KaraboMashao.Classification;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class WasteController {

    private final WasteRepository wasteRepository;

    public WasteController(WasteRepository wasteRepository){
        this.wasteRepository = wasteRepository;
        }

//    @GetMapping("api/wasteCategory")
//    Categories findAllCategories(){
//
//    }
}
