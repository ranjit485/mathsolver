package com.remo.rabbit.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.text.Caret;
import java.awt.*;

@Component
public class LeftSide {

    private JButton solveButton;
    private JButton clearButton;
    private JTextArea questionInput;
    private JPanel leftPannel;
    private JPanel creditContainer;
    private JPanel buttonContainer;

    public LeftSide() {

        leftPannel = new JPanel();
        leftPannel.setSize(200, 100);
        leftPannel.setBorder(new MatteBorder(0, 0, 0, 0, new Color(255, 101, 0)));
        leftPannel.setBackground(new Color(14, 30, 52));
        leftPannel.setLayout(new BoxLayout(leftPannel, BoxLayout.Y_AXIS));
        leftPannel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));  // Padding around components

        buttonContainer = new JPanel();
        buttonContainer.setBackground(Color.WHITE);
        buttonContainer.setLayout(new FlowLayout(FlowLayout.CENTER));

        questionInput = new JTextArea(26, 23);
        questionInput.setBounds(10, 30, 200, 200);
        questionInput.setBackground(new Color(18, 40, 64));
        questionInput.setForeground(Color.WHITE);
        questionInput.setBorder(new MatteBorder(0, 0, 0, 0, new Color(255, 101, 0)));
        questionInput.setLineWrap(true);
        questionInput.setWrapStyleWord(true);
        questionInput.setFont(new Font("Arial", Font.PLAIN, 16));  // Set font to Arial, plain style, size 16


        // Set a blinking caret
        Caret caret = questionInput.getCaret();
        caret.setBlinkRate(500);

        JScrollPane scrollPane = new JScrollPane(questionInput);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        // Solve Button
        solveButton = new JButton("Solve");
        solveButton.setBackground(new Color(255, 101, 0));
        solveButton.setOpaque(true);
        solveButton.setFont(new Font("Arial", Font.PLAIN, 20));
        solveButton.setForeground(Color.WHITE);
        solveButton.setBorderPainted(false);

        // Action listener for solveButton
        solveButton.addActionListener(e -> {
            // Call your solving logic here with the inputText
        });

        // Clear Button
        clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(255, 101, 0));
        clearButton.setOpaque(true);
        clearButton.setFont(new Font("Arial", Font.PLAIN, 20));
        clearButton.setForeground(Color.WHITE);
        clearButton.setBorderPainted(false);


        // Add components to inputContainer
        creditContainer = new JPanel();
        creditContainer.setBackground(new Color(14, 30, 52));
        creditContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));  // FlowLayout with 10px gaps between images


        buttonContainer =new JPanel();
        buttonContainer.setBackground(Color.WHITE);
        buttonContainer.setLayout(new FlowLayout(FlowLayout.CENTER));

        buttonContainer.add(solveButton);
        buttonContainer.add(clearButton);

        leftPannel.add(scrollPane);
        leftPannel.add(buttonContainer);
        leftPannel.add(creditContainer);

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

    public JPanel getLeftPannel() {
        return leftPannel;
    }

    public void setLeftPannel(JPanel leftPannel) {
        this.leftPannel = leftPannel;
    }

    public JPanel getCreditContainer() {
        return creditContainer;
    }

    public void setCreditContainer(JPanel creditContainer) {
        this.creditContainer = creditContainer;
    }

    public JPanel getButtonContainer() {
        return buttonContainer;
    }

    public void setButtonContainer(JPanel buttonContainer) {
        this.buttonContainer = buttonContainer;
    }
}
