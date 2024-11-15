package com.remo.rabbit.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class AppView extends JFrame {

    public LeftSide leftSide;
    public  RightSide rightSide;
   @Autowired
    public AppView(LeftSide leftSide, RightSide rightSide) {

       // Set up the window
        setTitle("Math Solver");
        setSize(950, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(18, 18, 18));
        setResizable(false);

        // Arrange components in a layout
        setLayout(new GridLayout(1, 2));


        // Add containers to the frame
        add(leftSide.getLeftPannel());
        add(rightSide.getRightPannel());

    }

}
