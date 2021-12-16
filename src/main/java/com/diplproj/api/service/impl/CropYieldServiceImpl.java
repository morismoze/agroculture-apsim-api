package com.diplproj.api.service.impl;

import com.diplproj.api.model.CropYield;
import com.diplproj.api.model.dto.response.CropYieldResponseDto;
import com.diplproj.api.repository.CropYieldRepository;
import com.diplproj.api.service.CropYieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CropYieldServiceImpl implements CropYieldService {

    @Autowired
    private CropYieldRepository cropYieldRepository;

    @Override
    public List<CropYield> getCultureYield(Integer cultureId, Integer locationId) {
        List<CropYieldResponseDto> cultureYield = new ArrayList<>();

        return this.cropYieldRepository.findByIdAndLocation(cultureId, locationId);
    }

}
