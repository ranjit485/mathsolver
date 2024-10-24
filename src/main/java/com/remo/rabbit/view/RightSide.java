package com.remo.rabbit.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
@Component
public class RightSide {
    private JPanel rightPannel;

    private JPanel imageContainer;
    private JTextArea responseText;
    private JLabel aiImage;
    RightSide(){

        rightPannel = new JPanel();
        rightPannel.setBackground(Color.WHITE);
        rightPannel.setBounds(10,10,100,300);
        rightPannel.setLayout(new BorderLayout());
        rightPannel.setSize(200, 400);
        rightPannel.setBackground(new Color(11, 25, 44));

        imageContainer = new JPanel();
        imageContainer.setBackground(Color.WHITE);
        imageContainer.setBounds(0,0,100,100);
        imageContainer.setLayout(new BorderLayout());
        imageContainer.setSize(200, 400);
        imageContainer.setBackground(new Color(186, 212, 248));

        ImageIcon icon = new ImageIcon(new ImageIcon("src/main/resources/ys.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        aiImage = new JLabel(icon);

        imageContainer.add(aiImage);

        responseText = new JTextArea("Ai response answer Ai response answer Ai response answer Ai response answer Ai response answer ");
        responseText.setBounds(10, 30, 50, 200);
        responseText.setBackground(new Color(18, 40, 64));
        responseText.setForeground(Color.WHITE);
        responseText.setLineWrap(true);
        responseText.setWrapStyleWord(true);
        responseText.setFont(new Font("Arial", Font.PLAIN, 16));  // Set font to Arial, plain style, size 16

        JScrollPane scrollPaneTwo = new JScrollPane(responseText);
        scrollPaneTwo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneTwo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        rightPannel.add(aiImage,BorderLayout.PAGE_START);
        rightPannel.add(scrollPaneTwo, BorderLayout.CENTER);

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
