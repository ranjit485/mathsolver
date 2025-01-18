package com.remo.rabbit.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class AppView extends JFrame {

    public  ResponsePannel responsePannel;
    public QuestionPanel questionPanel;

   @Autowired
    public AppView(ResponsePannel responsePannel, QuestionPanel questionPanel) {

       // Set up the window
        setTitle("AI Math Solver");
        setSize(950, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 255, 255));
        setResizable(false);

        // Arrange components in a layout
        setLayout(new GridLayout(2, 2,0,0));


        add(responsePannel.getResponsePannel());
        add(questionPanel.getQuestionPanel());

    }

}
