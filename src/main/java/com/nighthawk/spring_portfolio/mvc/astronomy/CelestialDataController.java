package com.nighthawk.spring_portfolio.mvc.astronomy;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/celestial-data")
public class CelestialDataController {

    @Autowired
    private CelestialDataService celestialDataService;

    @GetMapping("/fetch-and-store")
    public ResponseEntity<String> fetchAndStoreData() {
        try {
            // Define the API endpoint and headers
            String apiUrl = "https://astronomy.p.rapidapi.com/api/v2/bodies/positions?latitude=33.775867&longitude=-84.39733&from_date=2017-12-20&to_date=2017-12-21&elevation=166&time=12%3A00%3A00";
            String apiKey = "4081a90497msh5a787ecb0e167fbp16860cjsn75c92c6f8371";
            String apiHost = "astronomy.p.rapidapi.com";

            // Log the request information
            System.out.println("Sending request to the API:");
            System.out.println("API URL: " + apiUrl);
            System.out.println("API Key: " + apiKey);

            // Create and send the HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("X-RapidAPI-Key", apiKey)
                    .header("X-RapidAPI-Host", apiHost)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            // Log the response information
            System.out.println("Response from the API:");
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            if (response.statusCode() == 200) {
                // Return the response body as data
                String data = response.body();

                // Parse the JSON data into a CelestialData object
                ObjectMapper objectMapper = new ObjectMapper();
                CelestialData celestialData = objectMapper.readValue(data, CelestialData.class);

                // Store the CelestialData object
                celestialDataService.storeData(celestialData);

                return ResponseEntity.ok("Data fetched and stored successfully.");
            } else {
                throw new RuntimeException("Failed to fetch data from the external API");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch and store data: " + e.getMessage());
        }
    }

    // Sample endpoint to get celestial data by ID
    @GetMapping("/{id}")
    public ResponseEntity<CelestialData> getCelestialDataById(@PathVariable String id) {
        CelestialData data = celestialDataService.getDataById(id);
        if (data != null) {
            return ResponseEntity.ok(data);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Sample endpoint to list all celestial data
    @GetMapping("/list")
    public ResponseEntity<List<CelestialData>> listAllCelestialData() {
        List<CelestialData> dataList = celestialDataService.getAllData();
        return ResponseEntity.ok(dataList);
    }
}
