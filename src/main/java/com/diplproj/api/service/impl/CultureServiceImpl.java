package com.diplproj.api.service.impl;

import com.diplproj.api.response.*;
import com.diplproj.api.repository.CultureRepository;
import com.diplproj.api.response.projection.CultureMonetaryGainResponseDto;
import com.diplproj.api.service.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CultureServiceImpl implements CultureService {

    private final CultureRepository cultureRepository;

    @Autowired
    public CultureServiceImpl(CultureRepository cultureRepository) {
        this.cultureRepository = cultureRepository;
    }

    @Override
    public List<CultureResponseDto> getAllCultures() {
        return this.cultureRepository.findAll()
                .stream()
                .map((culture) -> new CultureResponseDto(culture.getId(), culture.getCultureName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CultureMonetaryGainResponseDto> getCultureMonetaryGain(Integer cultureId, Integer locationId) {
        return this.cultureRepository.findByIdAndLocation(cultureId, locationId);
    }

}
