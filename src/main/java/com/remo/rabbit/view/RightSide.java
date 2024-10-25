package com.remo.rabbit.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class RightSide {
    private JPanel rightPannel;
    private JTextArea responseText;
    private JLabel aiImage;
    public RightSide() {
        // Create the main panel
        rightPannel = new JPanel(new BorderLayout());
        rightPannel.setBackground(new Color(11, 25, 44));

        // Create the text area for AI response
        responseText = new JTextArea();
        responseText.setBackground(new Color(18, 40, 64));
        responseText.setForeground(Color.WHITE);
        responseText.setLineWrap(true);
        responseText.setWrapStyleWord(true);
        responseText.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add a scroll pane to the text area
        JScrollPane scrollPaneTwo = new JScrollPane(responseText);
        scrollPaneTwo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneTwo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add components to the main panel
        rightPannel.add(scrollPaneTwo, BorderLayout.CENTER);   // Add text area below the image
    }

    public JPanel getRightPannel() {
        return rightPannel;
    }

    public void setRightPannel(JPanel rightPannel) {
        this.rightPannel = rightPannel;
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
