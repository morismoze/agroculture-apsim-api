package com.diplproj.api.controller;

import com.diplproj.api.request.MicroclimateRequestDto;
import com.diplproj.api.response.MicroclimateNameResponseDto;
import com.diplproj.api.response.MicroclimateResponseDto;
import com.diplproj.api.response.projection.MicroclimateTimePeriodResponseDto;
import com.diplproj.api.service.MicroclimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/microclimate")
public class MicroclimateController {

    private final MicroclimateService microclimateService;

    @Autowired
    public MicroclimateController(MicroclimateService microclimateService) {
        this.microclimateService = microclimateService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MicroclimateNameResponseDto>> getAllMicroclimateParameters() {
        List<MicroclimateNameResponseDto> microclimateParameters = this.microclimateService.getAllMicroclimateParameters();

        return ResponseEntity.status(200).body(microclimateParameters);
    }

    @GetMapping("/time-period")
    public ResponseEntity<MicroclimateTimePeriodResponseDto> getPossibleTimePeriod() {
        MicroclimateTimePeriodResponseDto microclimateParameters = this.microclimateService.getPossibleTimePeriod();

        return ResponseEntity.status(200).body(microclimateParameters);
    }

    @PostMapping("/{microclimateId}")
    public ResponseEntity<List<MicroclimateResponseDto>> getIntervalMicroclimateData(@PathVariable Integer microclimateId, @RequestBody MicroclimateRequestDto microclimateRequestDto) {
        List<MicroclimateResponseDto> microclimateData = this.microclimateService.getMicroclimateData(microclimateId, microclimateRequestDto.getFrom(), microclimateRequestDto.getTo(), microclimateRequestDto.getLocationId());

        return ResponseEntity.status(200).body(microclimateData);
    }

}
