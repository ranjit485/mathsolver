package com.remo.rabbit.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class ResponsePannel {
    private JPanel responsePannel;
    private JTextArea responseText;
    private JLabel aiImage;

    @Autowired
    public ResponsePannel() {
        // Main panel with a modern background
        responsePannel = new JPanel(new BorderLayout());
        responsePannel.setBackground(new Color(18, 20, 28)); // Darker background for the response panel

        // Create the text area for AI response with modern styling
        responseText = new JTextArea();
        responseText.setEnabled(false);
        responseText.setText("\n\n\n                          A I   M A T H          \n" +
                "                           S O L V E R            \n" +
                "                     Developed by: Rohan, Rushi, Abhi, Akansh \n");
        responseText.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));  // Padding
        responseText.setBackground(new Color(32, 36, 45)); // Darker background for text area
        responseText.setForeground(Color.WHITE); // White text for contrast
        responseText.setFont(new Font("Segoe UI", Font.PLAIN, 20)); // Modern font
        responseText.setLineWrap(true);
        responseText.setWrapStyleWord(true);

        // Scroll Pane for the response text area
        JScrollPane scrollPaneTwo = new JScrollPane(responseText);
        scrollPaneTwo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneTwo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Adding components to the response panel
        responsePannel.add(scrollPaneTwo, BorderLayout.CENTER);

        // Optional: You can add an image for AI branding here, styled as needed.
    }

    public JPanel getResponsePannel() {
        return responsePannel;
    }

    public void setResponsePannel(JPanel responsePannel) {
        this.responsePannel = responsePannel;
    }

    public JTextArea getResponseText() {
        return responseText;
    }

    public void setResponseText(JTextArea responseText) {
        this.responseText = responseText;
    }

    public JLabel getAiImage() {
        return aiImage;
    }

    public void setAiImage(JLabel aiImage) {
        this.aiImage = aiImage;
    }
}
