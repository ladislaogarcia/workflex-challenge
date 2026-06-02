package com.workflex.challenge.workation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkationRepository extends JpaRepository<Workation, String> {

}
