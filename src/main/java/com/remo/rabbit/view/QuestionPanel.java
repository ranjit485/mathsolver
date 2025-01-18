package com.remo.rabbit.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class QuestionPanel {
    private JButton solveButton;
    private JButton clearButton;
    private JTextArea questionInput;
    private JPanel questionPanel;
    private JPanel buttonContainer;

    public QuestionPanel() {
        // Main panel styling
        questionPanel = new JPanel();
        questionPanel.setBackground(new Color(41, 45, 62)); // Dark background for the question panel
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));

        // Input text area styling
        questionInput = new JTextArea(8, 23);
        questionInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Padding
        questionInput.setBackground(new Color(56, 62, 80)); // Darker background for input
        questionInput.setForeground(Color.WHITE); // White text
        questionInput.setFont(new Font("Segoe UI", Font.PLAIN, 18));  // Font update
        questionInput.setLineWrap(true);
        questionInput.setWrapStyleWord(true);
        questionInput.setText("How many numbers divisible by 2, 0-100?");

        // Scroll Pane for the input text area
        JScrollPane scrollPane = new JScrollPane(questionInput);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Solve Button with hover effect
        solveButton = new JButton("Solve");
        solveButton.setBackground(new Color(76, 175, 80)); // Green color for button
        solveButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        solveButton.setForeground(Color.WHITE);
        solveButton.setFocusPainted(false);
        solveButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        solveButton.setOpaque(true);
        solveButton.addActionListener(e -> {
            // Action to solve the question
        });

        // Clear Button with hover effect
        clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(255, 87, 34)); // Red-orange color for button
        clearButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clearButton.setOpaque(true);

        // Button container
        buttonContainer = new JPanel();
        buttonContainer.setLayout(new GridLayout(1, 2, 10, 10)); // Adjusted grid layout with spacing
        buttonContainer.setOpaque(false); // Make the container transparent
        buttonContainer.add(solveButton);
        buttonContainer.add(clearButton);

        // Adding components to the panel
        questionPanel.add(scrollPane);
        questionPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Adds spacing between components
        questionPanel.add(buttonContainer);
    }

    public JPanel getQuestionPanel() {
        return questionPanel;
    }

    public JButton getSolveButton() {
        return solveButton;
    }

    public void setSolveButton(JButton solveButton) {
        this.solveButton = solveButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public JTextArea getQuestionInput() {
        return questionInput;
    }

    public void setQuestionInput(JTextArea questionInput) {
        this.questionInput = questionInput;
    }

    public void setQuestionPanel(JPanel questionPanel) {
        this.questionPanel = questionPanel;
    }

    public JPanel getButtonContainer() {
        return buttonContainer;
    }

    public void setButtonContainer(JPanel buttonContainer) {
        this.buttonContainer = buttonContainer;
    }
}
