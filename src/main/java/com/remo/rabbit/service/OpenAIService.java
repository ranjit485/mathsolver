package com.remo.rabbit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.remo.rabbit.model.AppModel;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.remo.rabbit.model.AppModel.MY_API_KEY;
import static com.theokanning.openai.utils.TikTokensUtil.ModelEnum.*;

@Service
public class OpenAIService {

    private final OpenAiService service;
    String MY_KEY ="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";


    public OpenAIService() {
        this.service = new OpenAiService(MY_KEY);
    }
    public String solveMathProblem(String userMessage) {
        // Define the system prompt
        List<ChatMessage> messages = new ArrayList<>();
        messages.add(new ChatMessage(ChatMessageRole.SYSTEM.value(), "You are a helpful assistant."));

        // Add the user's message
        messages.add(new ChatMessage(ChatMessageRole.USER.value(), userMessage));

        // Build the chat request
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                .model(GPT_3_5_TURBO.getName())
                .messages(messages)
                .build();

        // Call the OpenAI API and retrieve the response
        try {
            ChatCompletionResult result = service.createChatCompletion(chatCompletionRequest);
            ChatMessage responseMessage = result.getChoices().get(0).getMessage();
            return responseMessage.getContent();
        } catch (Exception e) {
            // Handle API or network errors
            return "An error occurred: " + e.getMessage();
        }
    }

}
