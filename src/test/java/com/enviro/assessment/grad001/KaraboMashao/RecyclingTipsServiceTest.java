package com.enviro.assessment.grad001.KaraboMashao;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.enviro.assessment.grad001.KaraboMashao.model.RecyclingTip;
import com.enviro.assessment.grad001.KaraboMashao.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.KaraboMashao.service.RecyclingTipService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;

class RecyclingTipsServiceTest {

    @Mock
    private RecyclingTipRepository recyclingTipsRepository;

    @InjectMocks
    private RecyclingTipService recyclingTipsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindTipById_Success() {
        // Arrange
        int tipId = 1;
        RecyclingTip tip = new RecyclingTip();
        tip.setId(tipId);
        tip.setTipDescription("Separate glass from plastics.");

        when(recyclingTipsRepository.findById(tipId)).thenReturn(Optional.of(tip));

        // Act
        RecyclingTip result = recyclingTipsService.findRecyclingTipById(tipId);

        // Assert
        assertNotNull(result);
        assertEquals("separate glass from plastics.", result.getTipDescription());
        verify(recyclingTipsRepository, times(1)).findById(tipId);
    }

    @Test
    void testFindTipById_NotFound() {
        // Arrange
        int tipId = 1;
        when(recyclingTipsRepository.findById(tipId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> recyclingTipsService.findRecyclingTipById(tipId));
        verify(recyclingTipsRepository, times(1)).findById(tipId);
    }

    @Test
    void testGetAllTips() {
        // Arrange
        RecyclingTip tip1 = new RecyclingTip();
        tip1.setId(1);
        tip1.setTipDescription("Separate glass from plastics.");

        RecyclingTip tip2 = new RecyclingTip();
        tip2.setId(2);
        tip2.setTipDescription("Flatten cardboard boxes.");

        List<RecyclingTip> tips = Arrays.asList(tip1, tip2);
        when(recyclingTipsRepository.findAll()).thenReturn(tips);

        // Act
        List<RecyclingTip> result = recyclingTipsService.findAllRecyclingTips();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("separate glass from plastics.", result.get(0).getTipDescription());
        assertEquals("flatten cardboard boxes.", result.get(1).getTipDescription());
        verify(recyclingTipsRepository, times(1)).findAll();
    }

}