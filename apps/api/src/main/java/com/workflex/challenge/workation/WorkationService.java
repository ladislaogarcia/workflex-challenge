package com.workflex.challenge.workation;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class WorkationService {

    private WorkationRepository workationRepository;

    WorkationService(WorkationRepository workationRepository) {
        this.workationRepository = workationRepository;
    }

    List<Workation> getWorkations() {
        return this.workationRepository.findAll();
    }

}
