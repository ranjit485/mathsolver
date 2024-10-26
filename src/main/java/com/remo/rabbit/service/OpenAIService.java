package com.remo.rabbit.service;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class OpenAIService {

    private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
    
    @Value("${openai.api.key}")
    private String apiKey;

    private final OkHttpClient client;
    private final ObjectMapper objectMapper;

    public OpenAIService() {
        this.client = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public String solveMathProblem(String userMessage) throws IOException {
        // Define the system prompt to set context for the assistant
        Map<String, Object> systemPrompt = new HashMap<>();
        systemPrompt.put("role", "system");
        systemPrompt.put("content", "You are an AI math solver. Solve mathematical expressions and equations accurately and explain the steps if needed.");

        // Define the user message to be sent
        Map<String, String> userPrompt = new HashMap<>();
        userPrompt.put("role", "user");
        userPrompt.put("content", userMessage);

        Map<String, Object> messageContent = new HashMap<>();
        messageContent.put("model", "gpt-3.5-turbo");
        messageContent.put("messages", List.of(systemPrompt, userPrompt));

        RequestBody body = RequestBody.create(
                objectMapper.writeValueAsString(messageContent),
                MediaType.get("application/json")
        );

        Request request = new Request.Builder()
                .url(OPENAI_API_URL)
                .header("Authorization", "Bearer " + apiKey)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Parse the response
            Map<String, Object> jsonResponse = objectMapper.readValue(response.body().string(), Map.class);
            Map<String, Object> choice = ((List<Map<String, Object>>) jsonResponse.get("choices")).get(0);
            Map<String, Object> message = (Map<String, Object>) choice.get("message");

            return (String) message.get("content");
        }
    }
}
