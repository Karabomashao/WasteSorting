package com.enviro.assessment.grad001.KaraboMashao.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @GetMapping("")
    List<Category> findAll(){
        return categoryRepository.findAll();
    }
    @GetMapping("/{id}")
    Optional<Category> findById(@PathVariable int id){
        return categoryRepository.findById(id);
    }

    @GetMapping("/waste-types")
    List<WasteType> findAllTypes(){
        return categoryRepository.findAllTypes();
    }

   @GetMapping("/waste-types/search")
   List<WasteType> search(@RequestParam(required = false) String category){
        return categoryRepository.search(category);
   }

   @ResponseStatus(HttpStatus.NO_CONTENT)
   @DeleteMapping("/{id}")
    void delete(@PathVariable int id){
        categoryRepository.deleteCategory(id);
   }

   @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@RequestBody Category category){
        categoryRepository.createCategory(category);
   }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/waste-types")
    void createWasteType(@RequestBody WasteType wasteType){
        categoryRepository.createWasteType(wasteType);
   }

   @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("waste-types/{id}")
    void deleteWasteTypes(@PathVariable int id){
        categoryRepository.deleteWasteType(id);
   }

   @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateCreate(@RequestBody Category category, @PathVariable int id){
        categoryRepository.updateCategory(category, id);
   }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/waste-types/{id}")
    void updateWasteType(@RequestBody WasteType wasteType, @PathVariable int id){
        categoryRepository.updateWasteType(wasteType, id);
    }

}
