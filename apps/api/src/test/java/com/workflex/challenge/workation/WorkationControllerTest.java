package com.workflex.challenge.workation;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class WorkationControllerTest {

    private MockMvc mockMvc;

    @Mock
    private WorkationService workationService;

    @InjectMocks
    private WorkationController workationController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(workationController).build();
    }

    @Test
    void getWorkation_shouldReturnOkAndList() throws Exception {
        // Arrange
        List<Workation> workations = List.of(
            Workation.builder().workationId("w1").employee("Employee 1").build()
        );
        when(workationService.getWorkations()).thenReturn(workations);

        // Act & Assert
        mockMvc.perform(get("/workflex/workation"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].workationId").value("w1"))
                .andExpect(jsonPath("$[0].employee").value("Employee 1"));
    }

    @Test
    void getWorkation_whenEmpty_shouldReturnOkAndEmptyList() throws Exception {
        // Arrange
        when(workationService.getWorkations()).thenReturn(List.of());

        // Act & Assert
        mockMvc.perform(get("/workflex/workation"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
