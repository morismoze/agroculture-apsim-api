package com.diplproj.api.service;

import com.diplproj.api.response.CultureResponseDto;
import com.diplproj.api.response.projection.CultureMonetaryGainResponseDto;
import java.util.List;

public interface CultureService {

    List<CultureResponseDto> getAllCultures();

    List<CultureMonetaryGainResponseDto> getCultureMonetaryGain(Integer cultureId, Integer locationId);

}
