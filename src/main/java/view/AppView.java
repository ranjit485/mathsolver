package view;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.text.Caret;
import java.awt.*;

public class AppView extends JFrame {
    private JLabel messageLabel;
    private JButton clickButton;
    JPanel inputContainer;
    JPanel outputContainer;
    private JTextArea inputArea;

    public AppView() {

        // Set up the window
        setTitle("Math Solver - Developed By Rohan Gharge");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(18, 18, 18));
        setResizable(false);

        // Arrange components in a layout
        setLayout(new GridLayout(1,2));

        inputContainer = new JPanel();
        outputContainer = new JPanel();

        inputContainer.setSize(MAXIMIZED_BOTH,200);
        inputContainer.setBorder(new MatteBorder(0, 0, 0, 1, new Color(255, 101, 0)));
        inputContainer.setBackground(new Color(14, 30, 52));
//        BorderFactory.createLineBorder(new Color(187, 134, 252), 2)

        inputArea = new JTextArea(19,23);
        inputArea.setBorder(BorderFactory.createLineBorder(new Color(187, 134, 252), 1));
        inputArea.setBackground(new Color(18, 40, 64));
        inputArea.setForeground(Color.WHITE);
//        inputArea.setLineWrap(true);
//        inputArea.setWrapStyleWord(true);
        inputArea.setFont(new Font("Arial", Font.PLAIN, 16));  // Set font to Arial, plain style, size 16

        // Set a blinking caret
        Caret caret = inputArea.getCaret();
        caret.setBlinkRate(500);

//        JScrollPane scrollPane = new JScrollPane(inputArea);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//
        inputContainer.add(inputArea);


        outputContainer.setSize(200,400);
        outputContainer.setBackground(new Color(11, 25, 44));


        add(inputContainer);
        add(outputContainer);

        // Create UI components
        messageLabel = new JLabel("Click the button to see the message!");
        clickButton = new JButton("Click Me");


    }

    public JButton getClickButton() {
        return clickButton;
    }

    public void setMessage(String message) {
        messageLabel.setText(message);
    }
}
