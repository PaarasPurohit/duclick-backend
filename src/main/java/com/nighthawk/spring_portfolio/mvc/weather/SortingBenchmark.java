package com.nighthawk.spring_portfolio.mvc.weather;

import com.nighthawk.spring_portfolio.mvc.weather.SortingService;
import com.nighthawk.spring_portfolio.mvc.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SortingBenchmark {

    private final WeatherService weatherService;
    private final SortingService sortingService;

    @Autowired
    public SortingBenchmark(WeatherService weatherService, SortingService sortingService) {
        this.weatherService = weatherService;
        this.sortingService = sortingService;
    }

    public void runBenchmark() {
        List<WeatherData> weatherData = weatherService.getWeatherDataList();
        sortingService.applySortingAlgorithms(weatherData);
        // Perform time complexity analysis
        // ...
    }
}
