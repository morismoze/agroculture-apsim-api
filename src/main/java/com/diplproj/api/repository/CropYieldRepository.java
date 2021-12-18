package com.diplproj.api.repository;

import com.diplproj.api.model.CropYield;
import com.diplproj.api.response.projection.CropYieldResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CropYieldRepository extends JpaRepository<CropYield, Integer> {

    @Query(value = "SELECT max(cy.value) AS yield, EXTRACT(YEAR FROM cy.date) AS year " +
            "FROM microclimate_value AS mv " +
            "JOIN culture AS c ON mv.id_culture = c.id " +
            "JOIN location AS l ON mv.id_location = l.id  " +
            "JOIN crop_yield AS cy ON l.id = cy.id_location " +
            "WHERE c.id = :cultureId AND l.id = :locationId " +
            "GROUP BY year " +
            "ORDER BY year", nativeQuery = true)
    List<CropYieldResponseDto> findByIdAndLocation(@Param("cultureId") Integer cultureId, @Param("locationId") Integer locationId);

}
