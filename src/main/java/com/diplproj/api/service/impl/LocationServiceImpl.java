package com.diplproj.api.service.impl;

import com.diplproj.api.repository.LocationRepository;
import com.diplproj.api.response.LocationResponseDto;
import com.diplproj.api.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<LocationResponseDto> getAllLocations() {
        return this.locationRepository.findAll()
                .stream()
                .map((location) -> new LocationResponseDto(location.getId(), location.getLocationName()))
                .collect(Collectors.toList());
    }
}
