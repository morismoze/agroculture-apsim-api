package com.diplproj.api.service;

import com.diplproj.api.model.CropYield;
import java.util.List;

public interface CropYieldService {

    List<CropYield> getCultureYield(Integer cultureId, Integer locationId);

}
