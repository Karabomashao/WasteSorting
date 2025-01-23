package com.enviro.assessment.grad001.KaraboMashao;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.enviro.assessment.grad001.KaraboMashao.model.Category;
import com.enviro.assessment.grad001.KaraboMashao.repository.CategoryRepository;
import com.enviro.assessment.grad001.KaraboMashao.service.CategoryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindCategoryById_Success() {
        // Arrange
        int categoryId = 1;
        Category category = new Category();
//        category.(categoryId);
        category.setWasteCategory("plastic");

        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));

        // Act
        Category result = categoryService.findCategoryById(categoryId);

        // Assert
        assertNotNull(result);
        assertEquals("plastic", result.getWasteCategory());
        verify(categoryRepository, times(1)).findById(categoryId);
    }

    @Test
    void testFindCategoryById_NotFound() {
        // Arrange
        Long categoryId = 1L;
        when(categoryRepository.findById(1)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> categoryService.findCategoryById(1));
        verify(categoryRepository, times(1)).findById(1);
    }

    @Test
    void testSaveCategory() {
        // Arrange
        Category category = new Category();
        category.setWasteCategory("metal");

        when(categoryRepository.save(category)).thenReturn(category);

        // Act
        Category result = categoryService.createCategory(category);

        // Assert
        assertNotNull(result);
        assertEquals("metal", result.getWasteCategory());
        verify(categoryRepository, times(1)).save(category);
    }
}
