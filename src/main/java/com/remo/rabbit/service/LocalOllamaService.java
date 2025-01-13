package com.remo.rabbit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.remo.rabbit.model.OllamaResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@Component
public class LocalOllamaService {

    private final RestTemplate restTemplate;
    private String apiUrl = "http://localhost:11434";  // Ollama API URL

    public LocalOllamaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OllamaResponse getResponse(String prompt) {
        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request body
        Map<String, Object> requestBody = Map.of(
                "model", "llama3.2",
                "stream", false,
                "prompt", prompt
        );

        // Make HTTP POST request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
        String jsonResponse = restTemplate.postForObject(apiUrl + "/api/generate", entity, String.class);

        // Parse the JSON response into the OllamaResponse object
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            OllamaResponse ollamaResponse = objectMapper.readValue(jsonResponse, OllamaResponse.class);
            return ollamaResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
