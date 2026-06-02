package com.workflex.challenge.workation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/workflex")
public class WorkationController {

    private WorkationService workationService;

    WorkationController(WorkationService workationService) {
        this.workationService = workationService;
    }

    @GetMapping("/workation")
    public ResponseEntity<List<Workation>> getWorkation() {
        List<Workation> workations = this.workationService.getWorkations();
        return ResponseEntity.ok(workations);
    }
}
