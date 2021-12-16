package com.diplproj.api.repository;

import com.diplproj.api.model.MicroclimateName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicroclimateNameRepository extends JpaRepository<MicroclimateName, Integer> {
    
}
