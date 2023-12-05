package com.nighthawk.spring_portfolio.mvc.weather;

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

    private final List<String> weatherDataList = new ArrayList<>();
    private final Random random = new Random();

    public void fetchAndStoreWeatherData(int numberOfRequests) {
        for (int i = 0; i < numberOfRequests; i++) {
            try {
                // Generate random latitude and longitude within a relevant range
                String latitude = generateLatitude();
                String longitude = generateLongitude();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=" + latitude + "," + longitude))
                        .header("X-RapidAPI-Key", "8401db6433msh3a46dd5bf23ad2ep19a280jsn48536a994246")
                        .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                        .method("GET", HttpRequest.BodyPublishers.noBody())
                        .build();

                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                String weatherData = extractRelevantData(response.body());

                // Store the relevant weather data in the ArrayList
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
        // Replace with your logic to generate random latitude within a relevant range
        return String.format("%.4f", 34.0 + random.nextDouble() * (40.0 - 34.0));
    }

    private String generateLongitude() {
        // Replace with your logic to generate random longitude within a relevant range
        return String.format("%.4f", -120.0 + random.nextDouble() * (150.0 + 120.0));
    }

    private String extractRelevantData(String apiResponse) {
        // You can parse the JSON response and extract the relevant information here
        // For simplicity, let's just return the entire API response as a string
        return apiResponse;
    }
}
