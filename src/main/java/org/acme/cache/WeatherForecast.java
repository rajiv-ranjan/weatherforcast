package org.acme.cache;

import java.util.List;

public class WeatherForecast {

    private List<String> dailyForecasts;

    private long executionTimeInMs;
    private long memoryLeft;
    
    public WeatherForecast(List<String> dailyForecasts, long executionTimeInMs, long memoryLeft) {
        this.dailyForecasts = dailyForecasts;
        this.executionTimeInMs = executionTimeInMs;
        this.memoryLeft=memoryLeft;
    }

    public List<String> getDailyForecasts() {
        return dailyForecasts;
    }

    public long getExecutionTimeInMs() {
        return executionTimeInMs;
    }

    public long memoryLeft() {
        return memoryLeft;
    }
}
