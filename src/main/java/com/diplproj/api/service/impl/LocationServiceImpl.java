package com.diplproj.api.service.impl;

import com.diplproj.api.model.Location;
import com.diplproj.api.repository.LocationRepository;
import com.diplproj.api.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
