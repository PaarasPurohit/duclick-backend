package com.nighthawk.spring_portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nighthawk.spring_portfolio.mvc.weather.WeatherService;

@Controller
@RequestMapping("/api/weather")
public class Weather {

    private final WeatherService weatherService;

    @Autowired
    public Weather(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/fetch-weather")
    public String fetchWeather(Model model) {
        weatherService.fetchAndStoreWeatherData(50);
        model.addAttribute("message", "Weather data fetched and stored successfully!");
        return "weather";
    }

    @GetMapping("/display-weather")
    public String displayWeather(Model model) {
        model.addAttribute("weatherDataList", weatherService.getWeatherDataList());
        return "weather";
    }
}
