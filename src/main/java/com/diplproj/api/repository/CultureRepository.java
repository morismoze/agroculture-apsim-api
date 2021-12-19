package com.diplproj.api.repository;

import com.diplproj.api.model.Culture;
import com.diplproj.api.response.projection.CultureMonetaryGainResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CultureRepository extends JpaRepository<Culture, Integer> {

    @Query(value = "SELECT cp.price * max(cy.value) AS monetaryGain, EXTRACT(YEAR FROM cy.date) AS year " +
            "FROM culture_price AS cp " +
            "JOIN culture AS c ON cp.id_culture = c.id " +
            "JOIN microclimate_value AS mv ON mv.id_culture = c.id " +
            "JOIN location AS l ON mv.id_location = l.id  " +
            "JOIN crop_yield AS cy ON l.id = cy.id_location " +
            "WHERE c.id = :cultureId AND l.id = :locationId " +
            "GROUP BY year, cp.price, cy.value, cy.date " +
            "ORDER BY year", nativeQuery = true)
    List<CultureMonetaryGainResponseDto> findByIdAndLocation(@Param("cultureId") Integer cultureId, @Param("locationId") Integer locationId);

}
