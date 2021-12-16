package com.diplproj.api.service.impl;

import com.diplproj.api.model.Culture;
import com.diplproj.api.model.dto.response.CropYieldResponseDto;
import com.diplproj.api.model.dto.response.CultureMonetaryGainResponseDto;
import com.diplproj.api.repository.CultureRepository;
import com.diplproj.api.service.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CultureServiceImpl implements CultureService {

    @Autowired
    private CultureRepository cultureRepository;

    @Override
    public List<Culture> getAllCultures() {
        return this.cultureRepository.findAll();
    }

    @Override
    public List<CultureMonetaryGainResponseDto> getCultureMonetaryGain(Integer cultureId, Integer locationId) {
        List<CultureMonetaryGainResponseDto> cultureMonetaryGain = new ArrayList<>();

        return cultureMonetaryGain;
    }

}
