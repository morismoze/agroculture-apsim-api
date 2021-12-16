package com.diplproj.api.service;

import com.diplproj.api.model.Culture;
import com.diplproj.api.model.dto.response.CultureMonetaryGainResponseDto;
import java.util.List;

public interface CultureService {

    List<Culture> getAllCultures();

    List<CultureMonetaryGainResponseDto> getCultureMonetaryGain(Integer cultureId, Integer locationId);

}
