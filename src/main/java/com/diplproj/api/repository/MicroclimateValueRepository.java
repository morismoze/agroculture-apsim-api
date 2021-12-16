package com.diplproj.api.repository;

import com.diplproj.api.model.MicroclimateValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Date;
import java.util.List;

public interface MicroclimateValueRepository extends JpaRepository<MicroclimateValue, Integer> {

    @Query(value = "SELECT * " +
            "FROM microclimate_value " +
            "WHERE id_microclimate = :microclimateId AND id_location = :locationId AND date BETWEEN :from AND :to " +
            "ORDER BY date",
            nativeQuery = true)
    List<MicroclimateValue> findByIdAndIntervalAndLocation(
            @Param("microclimateId") Integer microclimateId,
            @Param("from") Date from,
            @Param("to") Date to,
            @Param("locationId") Integer locationId);

}
