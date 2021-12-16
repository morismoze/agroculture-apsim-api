package com.diplproj.api.controller;

import com.diplproj.api.model.Culture;
import com.diplproj.api.model.dto.request.CultureMonetaryGainRequestDto;
import com.diplproj.api.model.dto.response.CultureMonetaryGainResponseDto;
import com.diplproj.api.service.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/culture")
public class CultureController {

    @Autowired
    private CultureService cultureService;

    @GetMapping("/all")
    public ResponseEntity<List<Culture>> getAllCultures() {
        List<Culture> cultures = this.cultureService.getAllCultures();

        return ResponseEntity.status(200).body(cultures);
    }

    @PostMapping("/{cultureId}/monetary-gain")
    public ResponseEntity<List<CultureMonetaryGainResponseDto>> getCultureMonetaryGain(@RequestBody CultureMonetaryGainRequestDto cultureMonetaryGainRequestDto) {
        List<CultureMonetaryGainResponseDto> microclimateParameters = this.cultureService.getCultureMonetaryGain(cultureMonetaryGainRequestDto.getCultureId(), cultureMonetaryGainRequestDto.getLocationId());

        return ResponseEntity.status(200).body(microclimateParameters);
    }

}
