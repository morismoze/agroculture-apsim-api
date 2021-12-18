package com.diplproj.api.controller;

import com.diplproj.api.request.CultureMonetaryGainRequestDto;
import com.diplproj.api.response.CultureResponseDto;
import com.diplproj.api.response.projection.CultureMonetaryGainResponseDto;
import com.diplproj.api.service.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/culture")
public class CultureController {

    private final CultureService cultureService;

    @Autowired
    public CultureController(CultureService cultureService) {
        this.cultureService = cultureService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CultureResponseDto>> getAllCultures() {
        List<CultureResponseDto> cultures = this.cultureService.getAllCultures();

        return ResponseEntity.status(200).body(cultures);
    }

    @PostMapping("/{cultureId}/monetary-gain")
    public ResponseEntity<List<CultureMonetaryGainResponseDto>> getCultureMonetaryGain(@PathVariable Integer cultureId, @RequestBody CultureMonetaryGainRequestDto cultureMonetaryGainRequestDto) {
        List<CultureMonetaryGainResponseDto> microclimateParameters = this.cultureService.getCultureMonetaryGain(cultureId, cultureMonetaryGainRequestDto.getLocationId());

        return ResponseEntity.status(200).body(microclimateParameters);
    }

}
