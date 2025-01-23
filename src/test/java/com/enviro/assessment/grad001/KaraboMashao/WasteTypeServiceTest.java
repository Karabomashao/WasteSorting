package com.enviro.assessment.grad001.KaraboMashao;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.enviro.assessment.grad001.KaraboMashao.model.WasteType;
import com.enviro.assessment.grad001.KaraboMashao.repository.WasteTypeRepository;
import com.enviro.assessment.grad001.KaraboMashao.service.WasteTypeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;

class WasteTypeServiceTest {

    @Mock
    private WasteTypeRepository wasteTypeRepository;

    @InjectMocks
    private WasteTypeService wasteTypeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindWasteTypeById_Success() {
        // Arrange
        int wasteTypeId = 1;
        WasteType wasteType = new WasteType();
        wasteType.setId(wasteTypeId);
        wasteType.setTypeOfWaste("Organic");

        when(wasteTypeRepository.findById(wasteTypeId)).thenReturn(Optional.of(wasteType));

        // Act
        WasteType result = wasteTypeService.findWasteTypeById(wasteTypeId);

        // Assert
        assertNotNull(result);
        assertEquals("organic", result.getTypeOfWaste());
        verify(wasteTypeRepository, times(1)).findById(wasteTypeId);
    }

    @Test
    void testFindWasteTypeById_NotFound() {
        // Arrange
        int wasteTypeId = 1;
        when(wasteTypeRepository.findById(wasteTypeId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> wasteTypeService.findWasteTypeById(wasteTypeId));
        verify(wasteTypeRepository, times(1)).findById(wasteTypeId);
    }

    @Test
    void testGetAllWasteTypes() {
        // Arrange
        WasteType wasteType1 = new WasteType();
        wasteType1.setId(1);
        wasteType1.setTypeOfWaste("Organic");

        WasteType wasteType2 = new WasteType();
        wasteType2.setId(2);
        wasteType2.setTypeOfWaste("Recyclable");

        List<WasteType> wasteTypes = Arrays.asList(wasteType1, wasteType2);
        when(wasteTypeRepository.findAll()).thenReturn(wasteTypes);

        // Act
        List<WasteType> result = wasteTypeService.findAllWasteTypes();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("organic", result.get(0).getTypeOfWaste());
        assertEquals("recyclable", result.get(1).getTypeOfWaste());
        verify(wasteTypeRepository, times(1)).findAll();
    }
}
