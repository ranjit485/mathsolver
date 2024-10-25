package com.remo.rabbit.controller;

import com.remo.rabbit.service.AppService;
import com.remo.rabbit.view.LeftSide;
import com.remo.rabbit.view.RightSide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;

@Controller public class AppController {

    @Autowired
    private AppService service;

    @Autowired
    AppController (RightSide rightSide,LeftSide leftSide){

        leftSide.getSolveButton().addActionListener(e->{
            String userInput = leftSide.getQuestionInput().getText();
            String ans =service.genrateAnswer(userInput);

            JTextArea responseText=rightSide.getResponseText();
            responseText.setText(ans);

        });


        leftSide.getClearButton().addActionListener(e->{
            JTextArea jt = leftSide.getQuestionInput();
            jt.setText("Ask here..");

            JTextArea jn =rightSide.getResponseText();
            jn.setText("");
        });
    }
}
