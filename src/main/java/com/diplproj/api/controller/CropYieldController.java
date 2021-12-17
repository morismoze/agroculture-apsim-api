package com.diplproj.api.controller;

import com.diplproj.api.model.CropYield;
import com.diplproj.api.request.CropYieldRequestDto;
import com.diplproj.api.service.CropYieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/yield")
public class CropYieldController {

    private final CropYieldService cropYieldService;

    @Autowired
    public CropYieldController(CropYieldService cropYieldService) {
        this.cropYieldService = cropYieldService;
    }

    @PostMapping
    public ResponseEntity<List<CropYield>> getCultureYield(@RequestBody CropYieldRequestDto cropYieldRequestDto) {
        List<CropYield> microclimateParameters = this.cropYieldService.getCultureYield(cropYieldRequestDto.getCultureId(), cropYieldRequestDto.getLocationId());

        return ResponseEntity.status(200).body(microclimateParameters);
    }

}
