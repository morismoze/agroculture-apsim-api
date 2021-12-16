package com.diplproj.api.service;

import com.diplproj.api.model.MicroclimateName;
import com.diplproj.api.model.dto.response.MicroclimateResponseDto;

import java.sql.Date;
import java.util.List;

public interface MicroclimateService {

    List<MicroclimateName> getAllMicroclimateParameters();

    List<MicroclimateResponseDto> getMicroclimateData(Integer microclimateId, Date from, Date to, Integer locationId);

}
