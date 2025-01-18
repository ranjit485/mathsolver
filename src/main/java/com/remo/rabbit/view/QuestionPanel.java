package com.remo.rabbit.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.text.Caret;
import java.awt.*;

@Component
public class QuestionPanel {
    private JButton solveButton;
    private JButton clearButton;
    private JTextArea questionInput;
    private JPanel questionPanel;
    private JPanel buttonContainer;
    public QuestionPanel() {

        questionPanel = new JPanel();
        questionPanel.setSize(200, 700);
//        questionPannel.setBorder(new MatteBorder(0, 0, 0, 0, new Color(186, 212, 248)));
        questionPanel.setBackground(new Color(188,204,215));
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
//        leftPannel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));  // Padding around components


        questionInput = new JTextArea(26, 23);
        questionInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));  // Padding around components
        questionInput.setBounds(10, 30, 200, 200);
        questionInput.setBackground(new Color(188,204,215));
        questionInput.setForeground(Color.BLACK);
//        questionInput.setBorder(new MatteBorder(0, 0, 0, 0, new Color(255, 101, 0)));
        questionInput.setLineWrap(true);
        questionInput.setSelectionColor(Color.GRAY);
        questionInput.setWrapStyleWord(true);
        questionInput.setText("How many numbers divisible by 2 , 0-100 ?");
        questionInput.setFont(new Font("Arial", Font.PLAIN, 26));  // Set font to Arial, plain style, size 16


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

        // Action listener for solveButton
        solveButton.addActionListener(e -> {
            // Call your solving logic here with the inputText
        });

        // Clear Button
        clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(210, 220, 234));
        clearButton.setOpaque(true);
        clearButton.setFont(new Font("Arial", Font.PLAIN, 20));
        clearButton.setForeground(Color.BLACK);
//        clearButton.setBorderPainted(false);


        buttonContainer =new JPanel();
        buttonContainer.setBackground(Color.WHITE);
        buttonContainer.setLayout(new GridLayout(1,2));

        buttonContainer.add(solveButton);
        buttonContainer.add(clearButton);

        questionPanel.add(scrollPane);
        questionPanel.add(buttonContainer);


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

    public JPanel getQuestionPanel() {
        return questionPanel;
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
