package com.diplproj.api.repository;

import com.diplproj.api.model.CropYield;
import com.diplproj.api.response.projection.CropYieldResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CropYieldRepository extends JpaRepository<CropYield, Integer> {

    @Query(value = "SELECT max(cy.value) AS yield, EXTRACT(YEAR FROM cy.date) AS year " +
            "FROM culture AS c " +
            "JOIN crop_yield AS cy ON c.id = cy.id_culture " +
            "JOIN location AS l ON l.id = cy.id_location " +
            "WHERE c.id = :cultureId AND l.id = :locationId " +
            "GROUP BY year " +
            "ORDER BY year", nativeQuery = true)
    List<CropYieldResponseDto> findByIdAndLocation(@Param("cultureId") Integer cultureId, @Param("locationId") Integer locationId);

}
