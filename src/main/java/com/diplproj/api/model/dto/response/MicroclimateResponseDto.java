package com.diplproj.api.model.dto.response;

import java.util.Date;

public class MicroclimateResponseDto {
    private Date date;
    private Double microclimateValue;

    public MicroclimateResponseDto(Date date, Double microclimateValue) {
        this.date = date;
        this.microclimateValue = microclimateValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getMicroclimateValue() {
        return microclimateValue;
    }

    public void setMicroclimateValue(Double microclimateValue) {
        this.microclimateValue = microclimateValue;
    }

}
