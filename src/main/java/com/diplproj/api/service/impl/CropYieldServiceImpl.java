package com.diplproj.api.service.impl;

import com.diplproj.api.response.projection.CropYieldResponseDto;
import com.diplproj.api.repository.CropYieldRepository;
import com.diplproj.api.service.CropYieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CropYieldServiceImpl implements CropYieldService {

    private final CropYieldRepository cropYieldRepository;

    @Autowired
    public CropYieldServiceImpl(CropYieldRepository cropYieldRepository) {
        this.cropYieldRepository = cropYieldRepository;
    }

    @Override
    public List<CropYieldResponseDto> getCultureYield(Integer cultureId, Integer locationId) {
        return this.cropYieldRepository.findByIdAndLocation(cultureId, locationId);
    }

}
