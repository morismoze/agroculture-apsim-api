package com.diplproj.api.service;

import com.diplproj.api.response.MicroclimateNameResponseDto;
import com.diplproj.api.response.MicroclimateResponseDto;
import com.diplproj.api.response.projection.MicroclimateTimePeriodResponseDto;

import java.sql.Date;
import java.util.List;

public interface MicroclimateService {

    List<MicroclimateNameResponseDto> getAllMicroclimateParameters();

    List<MicroclimateResponseDto> getMicroclimateData(Integer microclimateId, Date from, Date to, Integer locationId);

    MicroclimateTimePeriodResponseDto getPossibleTimePeriod();

}
