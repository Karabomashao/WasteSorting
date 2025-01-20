package com.enviro.assessment.grad001.KaraboMashao.controller;

import com.enviro.assessment.grad001.KaraboMashao.model.WasteType;
import com.enviro.assessment.grad001.KaraboMashao.service.WasteTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/waste-types")
    public class WasteTypeController {

        private final WasteTypeService wasteTypeService;

        public WasteTypeController(WasteTypeService wasteTypeService) {
            this.wasteTypeService = wasteTypeService;
        }

        @GetMapping
        public ResponseEntity<List<WasteType>> getAllWasteTypes() {
            return ResponseEntity.ok(wasteTypeService.findAllWasteTypes());
        }

        @GetMapping("/{id}")
        public ResponseEntity<WasteType> getWasteTypeById(@PathVariable int id) {
            return ResponseEntity.ok(wasteTypeService.findWasteTypeById(id));
        }

        @GetMapping("/category/{category}")
        public ResponseEntity<List<WasteType>> getWasteTypesByCategory(@PathVariable String category) {
            return ResponseEntity.ok(wasteTypeService.findWasteTypesByCategory(category));
        }

        @PostMapping
        public ResponseEntity<WasteType> createWasteType(@RequestBody WasteType wasteType) {
            return ResponseEntity.ok(wasteTypeService.createWasteType(wasteType));
        }

        @PutMapping("/{id}")
        public ResponseEntity<WasteType> updateWasteType(@PathVariable int id, @RequestBody WasteType wasteType) {
            return ResponseEntity.ok(wasteTypeService.updateWasteType(id, wasteType));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteWasteType(@PathVariable int id) {
            wasteTypeService.deleteWasteType(id);
            return ResponseEntity.noContent().build();
        }
    }



