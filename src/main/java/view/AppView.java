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
        setSize(850, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(18, 18, 18));
        setResizable(false);

        // Arrange components in a layout
        setLayout(new GridLayout(1, 2));

        inputContainer = new JPanel();
        outputContainer = new JPanel();

        inputContainer.setSize(200, 200);
        inputContainer.setBorder(new MatteBorder(0, 0, 0, 1, new Color(255, 101, 0)));
        inputContainer.setBackground(new Color(14, 30, 52));
        inputContainer.setLayout(new BorderLayout());

        inputArea = new JTextArea(19, 23);
        inputArea.setBounds(10, 30, 200, 200);
        inputArea.setBorder(BorderFactory.createLineBorder(new Color(187, 134, 252), 1));
        inputArea.setBackground(new Color(18, 40, 64));
        inputArea.setForeground(Color.WHITE);
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        inputArea.setFont(new Font("Arial", Font.PLAIN, 16));  // Set font to Arial, plain style, size 16

        // Set a blinking caret
        Caret caret = inputArea.getCaret();
        caret.setBlinkRate(500);

        JScrollPane scrollPane = new JScrollPane(inputArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JTextField questionTitle = new JTextField("Enter question Below");
        questionTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        questionTitle.setBackground(new Color(11,25,44));
        questionTitle.setForeground(Color.WHITE);
        questionTitle.setBorder(BorderFactory.createLineBorder(null));

        // Solve Button
        JButton solveButton = new JButton("Solve");
        solveButton.setBackground(new Color(255, 101, 0));
        solveButton.setOpaque(true);
        solveButton.setBorderPainted(false);

        // Add components to inputContainer
//        inputContainer.add(questionTitle, BorderLayout.NORTH);
//        TODO
        inputContainer.add(scrollPane, BorderLayout.CENTER); // Use the scrollPane instead of inputArea directly
        inputContainer.add(solveButton, BorderLayout.SOUTH); // Use solveButton instead of creating a new button

        outputContainer.setSize(200, 400);
        outputContainer.setBackground(new Color(11, 25, 44));

        // Add containers to the frame
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
