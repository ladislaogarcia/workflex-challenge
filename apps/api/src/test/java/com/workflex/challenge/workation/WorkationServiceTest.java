package com.workflex.challenge.workation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WorkationServiceTest {

    @Mock
    private WorkationRepository workationRepository;

    private WorkationService workationService;

    @BeforeEach
    void setUp() {
        workationService = new WorkationService(workationRepository);
    }

    @Test
    void getWorkations_shouldReturnListOfWorkations() {
        // Arrange
        List<Workation> expectedWorkations = List.of(
            Workation.builder().workationId("w1").employee("Employee 1").build(),
            Workation.builder().workationId("w2").employee("Employee 2").build()
        );
        when(workationRepository.findAll()).thenReturn(expectedWorkations);

        // Act
        List<Workation> actualWorkations = workationService.getWorkations();

        // Assert
        assertNotNull(actualWorkations);
        assertEquals(2, actualWorkations.size());
        assertEquals("Employee 1", actualWorkations.get(0).getEmployee());
        verify(workationRepository).findAll();
    }
}
