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
        // Create the main panel
        responsePannel = new JPanel(new BorderLayout());
        responsePannel.setBackground(new Color(11, 25, 44));
        responsePannel.setBounds(new Rectangle(200,600));


        // Create the text area for AI response
        responseText = new JTextArea();
        responseText.setEnabled(false);
        responseText.setText("I am " +
                "-------------------" +
                "" +
                "AI Math Solver" +
                "" +
                "" +
                "-------------------");
        responseText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Padding around components
        responseText.setBackground(new Color(233,235,237));
        responseText.setForeground(Color.BLACK);
        responseText.setLineWrap(true);
        responseText.setBounds(10, 30, 200, 200);
        responseText.setWrapStyleWord(true);
        responseText.setFont(new Font("Arial", Font.PLAIN, 26));

        // Add a scroll pane to the text area
        JScrollPane scrollPaneTwo = new JScrollPane(responseText);
        scrollPaneTwo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneTwo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add components to the main panel
        responsePannel.add(scrollPaneTwo, BorderLayout.CENTER);
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
