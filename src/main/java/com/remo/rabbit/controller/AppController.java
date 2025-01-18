package com.remo.rabbit.controller;

import com.remo.rabbit.service.LocalOllamaService;
import com.remo.rabbit.view.QuestionPanel;
import com.remo.rabbit.view.ResponsePannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class AppController {

    @Autowired
    private LocalOllamaService ollamaService;

    @Autowired
    AppController(ResponsePannel responsePannel, QuestionPanel questionPanel) {

        questionPanel.getSolveButton().addActionListener(e -> {
            String userInput = questionPanel.getQuestionInput().getText();
            JTextArea responseText = responsePannel.getResponseText();
            responseText.setEnabled(true);

            // Start the typing effect with random messages while waiting for the response
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> {
                simulateTyping(responseText);
            });

            // Get the response and update the text area
            new Thread(() -> {
                String response = ollamaService.getResponse(userInput).getResponse();
                // After the typing effect, set the actual response
                SwingUtilities.invokeLater(() -> {
                    responseText.setText(response);  // Set actual response
                });
            }).start();
        });

        questionPanel.getClearButton().addActionListener(e -> {
            JTextArea jt = questionPanel.getQuestionInput();
            jt.setText("Ask here..");

            JTextArea jn = responsePannel.getResponseText();
            jn.setText("");
        });
    }

    // Method to simulate typing effect in the JTextArea with random messages
    private void simulateTyping(JTextArea responseText) {
        String[] messages = {
                "Crunching numbers...",
                "Solving your equation...",
                "Working on it...",
                "Calculating the solution...",
                "Almost there...",
                "Analyzing your problem...",
                "Gathering insights...",
                "Running calculations...",
                "Let me think...",
                "Hold on... Solving!",
                "Decoding the math...",
                "Math magic in progress...",
                "Breaking it down...",
                "Give me a second...",
                "Crunching the data...",
                "Finding the answer...",
                "Unleashing the solution...",
                "Solving with style..."
        };

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        while (true) {
            // Randomly pick a message from the list
            String randomMessage = messages[random.nextInt(messages.length)];

            // Reset the string builder and append the new message
            sb.setLength(0);  // Clear the builder
            sb.append(randomMessage);

            try {
                Thread.sleep(500);  // Adjust typing speed here
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final String text = sb.toString();
            SwingUtilities.invokeLater(() -> responseText.setText(text));

            // Stop the typing effect when the real response is available
            if (responseText.getText().length() > randomMessage.length()) {
                break;  // Exit loop when the response arrives
            }
        }
    }
}
