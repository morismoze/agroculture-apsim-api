package com.diplproj.api.service;

import com.diplproj.api.response.LocationResponseDto;
import java.util.List;

public interface LocationService {

    List<LocationResponseDto> getAllLocations();

}
