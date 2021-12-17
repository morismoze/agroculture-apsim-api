package com.diplproj.api.service;

import com.diplproj.api.response.CultureMonetaryGainResponseDto;
import com.diplproj.api.response.CultureResponseDto;
import java.util.List;

public interface CultureService {

    List<CultureResponseDto> getAllCultures();

    List<CultureMonetaryGainResponseDto> getCultureMonetaryGain(Integer cultureId, Integer locationId);

}
