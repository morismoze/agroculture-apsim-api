package com.diplproj.api.service.impl;

import com.diplproj.api.model.MicroclimateName;
import com.diplproj.api.model.dto.response.MicroclimateResponseDto;
import com.diplproj.api.repository.MicroclimateNameRepository;
import com.diplproj.api.repository.MicroclimateValueRepository;
import com.diplproj.api.service.MicroclimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MicroclimateServiceImpl implements MicroclimateService {

    @Autowired
    MicroclimateNameRepository microclimateNameRepository;
    @Autowired
    MicroclimateValueRepository microclimateValueRepository;

    @Override
    public List<MicroclimateName> getAllMicroclimateParameters() {
        return this.microclimateNameRepository.findAll();
    }

    @Override
    public List<MicroclimateResponseDto> getMicroclimateData(Integer microclimateId, Date from, Date to, Integer locationId) {
        return this.microclimateValueRepository.findByIdAndIntervalAndLocation(microclimateId, from, to, locationId)
                .stream()
                .map((data) -> new MicroclimateResponseDto(data.getDate(), data.getMicroclimateValue()))
                .collect(Collectors.toList());
    }

}
