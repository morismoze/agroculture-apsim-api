package com.diplproj.api.service;

import com.diplproj.api.response.projection.CropYieldResponseDto;

import java.util.List;

public interface CropYieldService {

    List<CropYieldResponseDto> getCultureYield(Integer cultureId, Integer locationId);

}
