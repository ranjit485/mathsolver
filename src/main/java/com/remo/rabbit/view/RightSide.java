package com.remo.rabbit.view;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class RightSide {
    private JPanel rightPannel;
    private JPanel imageContainer;
    private JTextArea responseText;
    private JLabel aiImage;
    private Icon icon;
    public RightSide() throws IOException {
        // Create the main panel
        rightPannel = new JPanel(new BorderLayout());
        rightPannel.setBackground(new Color(11, 25, 44));
        rightPannel.setPreferredSize(new Dimension(200, 400)); // Optional, for controlling panel size

        // Create the image container panel
        imageContainer = new JPanel(new BorderLayout());
        imageContainer.setPreferredSize(new Dimension(100, 120));

        icon = new ImageIcon("src/main/resources/ail.gif");
        aiImage = new JLabel(icon);


        imageContainer.add(aiImage, BorderLayout.CENTER);

        // Create the text area for AI response
        responseText = new JTextArea("Ai response answer Ai response answer Ai response answer...");
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
        rightPannel.add(imageContainer, BorderLayout.NORTH);  // Add image at the top
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
