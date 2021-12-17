package com.diplproj.api.repository;

import com.diplproj.api.model.CropYield;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CropYieldRepository extends JpaRepository<CropYield, Integer> {

    @Query(value = "SELECT DISTINCT cy.id, cy.id_location, cy.value, cy.date " +
            "FROM microclimate_value mv " +
            "JOIN culture c ON mv.id_culture = c.id " +
            "JOIN location l ON mv.id_location = l.id  " +
            "JOIN crop_yield cy ON l.id = cy.id_location " +
            "WHERE c.id = :cultureId AND l.id = :locationId " +
            "ORDER BY cy.date DESC " +
            "LIMIT 20;", nativeQuery = true)
    List<CropYield> findByIdAndLocation(@Param("cultureId") Integer cultureId, @Param("locationId") Integer locationId);

}
