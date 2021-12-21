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

    @Query(value = "SELECT max(value) AS yield, EXTRACT(YEAR FROM date) AS year " +
            "FROM crop_yield " +
            "WHERE id_culture = :cultureId AND id_location = :locationId " +
            "GROUP BY EXTRACT(YEAR FROM date) " +
            "ORDER BY year", nativeQuery = true)
    List<CropYieldResponseDto> findByIdAndLocation(@Param("cultureId") Integer cultureId, @Param("locationId") Integer locationId);

}
