package com.remo.rabbit.controller;

import com.remo.rabbit.service.OpenAIService;
import com.remo.rabbit.view.LeftSide;
import com.remo.rabbit.view.RightSide;
import org.matheclipse.core.expression.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;

@Controller
public class AppController {

    @Autowired
    private OpenAIService openAIService;


    @Autowired
    AppController(RightSide rightSide, LeftSide leftSide, OpenAIService aiService) {

        leftSide.getSolveButton().addActionListener(e -> {

            String userInput = leftSide.getQuestionInput().getText();

            JTextArea responseText = rightSide.getResponseText();

            responseText.setText(openAIService.solveMathProblem(userInput));

        });


        leftSide.getClearButton().addActionListener(e -> {
            JTextArea jt = leftSide.getQuestionInput();
            jt.setText("Ask here..");

            JTextArea jn = rightSide.getResponseText();
            jn.setText("");
        });


    }
}
