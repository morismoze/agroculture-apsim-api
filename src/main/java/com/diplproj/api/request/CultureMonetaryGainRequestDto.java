package com.diplproj.api.request;

public class CultureMonetaryGainRequestDto {

    private Integer cultureId;
    private Integer locationId;

    public Integer getCultureId() {
        return cultureId;
    }

    public void setCultureId(Integer cultureId) {
        this.cultureId = cultureId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

}
