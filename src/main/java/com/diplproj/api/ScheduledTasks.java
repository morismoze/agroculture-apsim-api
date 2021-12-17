package com.diplproj.api;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 86400000)
    public void predictWeatherData() {

    }

}
