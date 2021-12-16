package com.diplproj.api.controller;

import com.diplproj.api.model.MicroclimateName;
import com.diplproj.api.model.dto.request.MicroclimateRequestDto;
import com.diplproj.api.model.dto.response.MicroclimateResponseDto;
import com.diplproj.api.service.MicroclimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/microclimate")
public class MicroclimateController {

    @Autowired
    private MicroclimateService microclimateService;

    @GetMapping("/all")
    public ResponseEntity<List<MicroclimateName>> getAllMicroclimateParameters() {
        List<MicroclimateName> microclimateParameters = this.microclimateService.getAllMicroclimateParameters();

        return ResponseEntity.status(200).body(microclimateParameters);
    }

    @PostMapping("/{microclimateId}")
    public ResponseEntity<List<MicroclimateResponseDto>> getIntervalMicroclimateData(@PathVariable Integer microclimateId, @RequestBody MicroclimateRequestDto microclimateRequestDto) {
        List<MicroclimateResponseDto> microclimateData = this.microclimateService.getMicroclimateData(microclimateId, microclimateRequestDto.getFrom(), microclimateRequestDto.getTo(), microclimateRequestDto.getLocationId());

        return ResponseEntity.status(200).body(microclimateData);
    }

}
