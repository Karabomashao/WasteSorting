package com.enviro.assessment.grad001.KaraboMashao.category;

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

//    @GetMapping("/waste-types/{category}")
//        List<WasteType> findByCategory(@PathVariable String category){
//            return categoryRepository.findTypeByCategory(category);
//        }
   @GetMapping("/waste-types/search")
   List<WasteType> search(@RequestParam(required = false) String category){
        return categoryRepository.search(category);
   }
}
