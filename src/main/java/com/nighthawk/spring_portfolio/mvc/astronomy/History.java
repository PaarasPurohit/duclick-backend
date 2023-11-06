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
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api")
public class History {

    private final String rapidApiKey = "47adfc21bcmsh44e5abcedbf2a29p150b62jsn37a5f5ecf19a";
    private final String rapidApiHost = "chatgpt-best-price.p.rapidapi.com";
    private final String jsonFilePath = "history.json"; // File path for the history JSON
    private final List<ObjectNode> queryHistory = new CopyOnWriteArrayList<>(); // Thread-safe list to store history of queries and responses

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
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }

        return responseEntity;
    }

    private void writeHistoryToFile(String query, String response) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(jsonFilePath);
        
        try {
            ArrayNode arrayNode;
            if (!file.exists()) {
                file.createNewFile();
                arrayNode = mapper.createArrayNode();
            } else {
                arrayNode = (ArrayNode) mapper.readTree(file);
                if (arrayNode == null) {
                    arrayNode = mapper.createArrayNode();
                }
            }

            ObjectNode historyNode = mapper.createObjectNode();
            historyNode.put("query", query);

            ObjectNode responseNode = mapper.readValue(response, ObjectNode.class);
            if (responseNode.has("choices") && responseNode.get("choices").isArray()) {
                ArrayNode choicesArray = (ArrayNode) responseNode.get("choices");
                if (!choicesArray.isEmpty() && choicesArray.get(0).has("message") &&
                    choicesArray.get(0).get("message").has("content")) {
                    String content = choicesArray.get(0).get("message").get("content").asText();
                    historyNode.put("response", content);
                }
            } else {
                historyNode.put("response", "Response format not recognized.");
            }
            
            arrayNode.add(historyNode);
            mapper.writeValue(file, arrayNode);
            addToHistory(query, historyNode.get("response").asText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addToHistory(String query, String content) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode historyNode = mapper.createObjectNode();
        historyNode.put("query", query);
        historyNode.put("response", content);
        queryHistory.add(historyNode);
    }

    @GetMapping("/history")
    public List<ObjectNode> getHistory() {
        return queryHistory;
    }

    @DeleteMapping("/history")
    public ResponseEntity<String> clearHistory() {
        queryHistory.clear();
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(jsonFilePath);

        try {
            if (file.exists()) {
                ArrayNode emptyArray = mapper.createArrayNode();
                mapper.writeValue(file, emptyArray);
            }
            return ResponseEntity.ok("History cleared successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to clear history: " + e.getMessage());
        }
    }
}
