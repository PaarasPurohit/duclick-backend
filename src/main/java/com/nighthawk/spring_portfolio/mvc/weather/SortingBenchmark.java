package com.nighthawk.spring_portfolio.mvc.weather;

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
        displayBenchmarkSummary(weatherData);
    }

    private void displayBenchmarkSummary(List<WeatherData> weatherData) {
        System.out.println("Sorting Benchmark Summary:");
        System.out.println("Number of WeatherData elements: " + weatherData.size());
    }
}
