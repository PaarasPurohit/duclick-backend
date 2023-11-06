// yuri
package com.nighthawk.spring_portfolio.mvc.astronomy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class History {

    private final String rapidApiKey = "47adfc21bcmsh44e5abcedbf2a29p150b62jsn37a5f5ecf19a";
    private final String rapidApiHost = "chatgpt-best-price.p.rapidapi.com";
    private final String jsonFilePath = "history.json"; // File path for the history JSON

    @PostMapping("/fetch")
    public ResponseEntity<String> fetchFromExternalApi(@RequestBody ChatInput input) {
        String url = "https://chatgpt-best-price.p.rapidapi.com/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-RapidAPI-Key", rapidApiKey);
        headers.set("X-RapidAPI-Host", rapidApiHost);

        String requestBody = String.format(
                "{\"model\":\"gpt-3.5-turbo\",\"messages\":[{\"role\":\"user\",\"content\":\"%s\"}]}",
                input.getContent());

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity;

        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            writeHistoryToFile(input.getContent(), responseEntity.getBody());
        } catch (Exception e) {
            // Better error handling: Log the stack trace to the server's log.
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }

        return responseEntity;
    }

    // Method to write the query and response to a JSON file
    private void writeHistoryToFile(String query, String response) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(jsonFilePath);
        
        try {
            // Initialize the root array node
            ArrayNode arrayNode;
            // If file doesn't exist, create it and initialize a new array node
            if (!file.exists()) {
                file.createNewFile();
                arrayNode = mapper.createArrayNode();
            } else {
                // Otherwise, read the existing file into an array node
                arrayNode = (ArrayNode) mapper.readTree(file);
                if (arrayNode == null) {
                    arrayNode = mapper.createArrayNode();
                }
            }

            // Create the node that will be added to the array node
            ObjectNode historyNode = mapper.createObjectNode();
            historyNode.put("query", query);
            historyNode.put("response", response);
            arrayNode.add(historyNode);

            // Write the updated array node back to the file
            mapper.writeValue(file, arrayNode);
        } catch (IOException e) {
            // Better error handling: Log the stack trace to the server's log.
            e.printStackTrace();
        }
    }
}
