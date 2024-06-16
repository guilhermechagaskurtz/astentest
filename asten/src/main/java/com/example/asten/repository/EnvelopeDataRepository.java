package com.example.asten.repository;

import com.example.asten.model.EnvelopeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvelopeDataRepository extends JpaRepository<EnvelopeData, Long> {
}
