package com.diplproj.api.response;

public class LocationResponseDto {

    private Integer id;

    private String name;

    public LocationResponseDto(Integer id, String locationName) {
        this.id = id;
        this.name = locationName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
