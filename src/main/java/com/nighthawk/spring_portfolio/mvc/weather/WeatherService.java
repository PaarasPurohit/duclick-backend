package com.nighthawk.spring_portfolio.mvc.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WeatherService {

    private final List<WeatherData> weatherDataList = new ArrayList<>();
    private final Random random = new Random();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void fetchAndStoreWeatherData(int numberOfRequests) {
        for (int i = 0; i < numberOfRequests; i++) {
            try {
                String latitude = generateLatitude();
                String longitude = generateLongitude();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=" + latitude + "," + longitude))
                        .header("X-RapidAPI-Key", "8401db6433msh3a46dd5bf23ad2ep19a280jsn48536a994246")
                        .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                        .method("GET", HttpRequest.BodyPublishers.noBody())
                        .build();

                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                WeatherData weatherData = extractRelevantData(response.body());

                weatherDataList.add(weatherData);
            } catch (Exception e) {
                System.err.println("Error fetching weather data: " + e.getMessage());
            }
        }
    }

    public List<WeatherData> getWeatherDataList() {
        return new ArrayList<>(weatherDataList);
    }

    private String generateLatitude() {
        return String.format("%.4f", 34.0 + random.nextDouble() * (40.0 - 34.0));
    }

    private String generateLongitude() {
        return String.format("%.4f", -120.0 + random.nextDouble() * (150.0 + 120.0));
    }

    private WeatherData extractRelevantData(String apiResponse) throws Exception {
        // Parse the JSON response and extract the relevant information
        return objectMapper.readValue(apiResponse, WeatherData.class);
    }
}