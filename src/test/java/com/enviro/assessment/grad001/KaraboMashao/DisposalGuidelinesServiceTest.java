package com.enviro.assessment.grad001.KaraboMashao;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.enviro.assessment.grad001.KaraboMashao.model.DisposalGuideline;
import com.enviro.assessment.grad001.KaraboMashao.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.KaraboMashao.service.DisposalGuidelineService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;

class DisposalGuidelinesServiceTest {

    @Mock
    private DisposalGuidelineRepository disposalGuidelinesRepository;

    @InjectMocks
    private DisposalGuidelineService disposalGuidelinesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindGuidelineById_Success() {
        // Arrange
        int guidelineId = 1;
        DisposalGuideline guideline = new DisposalGuideline();
        guideline.setId(guidelineId);
        guideline.setDisposalMethod("Dispose in designated bins.");

        when(disposalGuidelinesRepository.findById(guidelineId)).thenReturn(Optional.of(guideline));

        // Act
        DisposalGuideline result = disposalGuidelinesService.findGuidelineById(guidelineId);

        // Assert
        assertNotNull(result);
        assertEquals("dispose in designated bins.", result.getDisposalMethod());
        verify(disposalGuidelinesRepository, times(1)).findById(guidelineId);
    }

    @Test
    void testFindGuidelineById_NotFound() {
        // Arrange
        int guidelineId = 1;
        when(disposalGuidelinesRepository.findById(guidelineId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> disposalGuidelinesService.findGuidelineById(guidelineId));
        verify(disposalGuidelinesRepository, times(1)).findById(guidelineId);
    }

    @Test
    void testGetAllGuidelines() {
        // Arrange
        DisposalGuideline guideline1 = new DisposalGuideline();
        guideline1.setId(1);
        guideline1.setDisposalMethod("Dispose in designated bins.");

        DisposalGuideline guideline2 = new DisposalGuideline();
        guideline2.setId(2);
        guideline2.setDisposalMethod("Recycle if possible.");

        List<DisposalGuideline> guidelines = Arrays.asList(guideline1, guideline2);
        when(disposalGuidelinesRepository.findAll()).thenReturn(guidelines);

        // Act
        List<DisposalGuideline> result = disposalGuidelinesService.findAllGuidelines();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("dispose in designated bins.", result.get(0).getDisposalMethod());
        assertEquals("recycle if possible.", result.get(1).getDisposalMethod());
        verify(disposalGuidelinesRepository, times(1)).findAll();
    }

}
