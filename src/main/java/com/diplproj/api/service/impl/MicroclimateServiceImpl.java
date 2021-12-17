package com.diplproj.api.service.impl;

import com.diplproj.api.response.MicroclimateNameResponseDto;
import com.diplproj.api.response.MicroclimateResponseDto;
import com.diplproj.api.repository.MicroclimateNameRepository;
import com.diplproj.api.repository.MicroclimateValueRepository;
import com.diplproj.api.response.projection.MicroclimateTimePeriodResponseDto;
import com.diplproj.api.service.MicroclimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MicroclimateServiceImpl implements MicroclimateService {

    private final MicroclimateNameRepository microclimateNameRepository;

    private final MicroclimateValueRepository microclimateValueRepository;

    @Autowired
    public MicroclimateServiceImpl(MicroclimateNameRepository microclimateNameRepository, MicroclimateValueRepository microclimateValueRepository) {
        this.microclimateNameRepository = microclimateNameRepository;
        this.microclimateValueRepository = microclimateValueRepository;
    }

    @Override
    public List<MicroclimateNameResponseDto> getAllMicroclimateParameters() {
        return this.microclimateNameRepository.findAll()
                .stream()
                .map((microclimateName) -> new MicroclimateNameResponseDto(microclimateName.getId(), microclimateName.getMicroclimateName()))
                .collect(Collectors.toList());
    }

    @Override
    public MicroclimateTimePeriodResponseDto getPossibleTimePeriod() {
        return this.microclimateValueRepository.findMinimumAndMaximumDate();
    }

    @Override
    public List<MicroclimateResponseDto> getMicroclimateData(Integer microclimateId, Date from, Date to, Integer locationId) {
        return this.microclimateValueRepository.findByIdAndIntervalAndLocation(microclimateId, from, to, locationId)
                .stream()
                .map((data) -> new MicroclimateResponseDto(data.getDate(), data.getMicroclimateValue()))
                .collect(Collectors.toList());
    }

}
