package com.remo.rabbit;

import com.remo.rabbit.config.AppConfig;
import com.remo.rabbit.model.AppModel;
import com.remo.rabbit.view.AppView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

public class App {

    static ApplicationContext context;
    static public void setUpApi(){

        String userInput = JOptionPane.showInputDialog(null,
                "Enter OpenAI API KEY:",
                "User Input",
                JOptionPane.QUESTION_MESSAGE);

        // Check if the user clicked "Cancel" or closed the dialog
        if (userInput != null) {
            // Display a message dialog with the input
            JOptionPane.showMessageDialog(null,
                    "KEY ADDED :, " + userInput + "!",
                    "Welcome",
                    JOptionPane.INFORMATION_MESSAGE);
            AppModel.setMyApiKey(userInput);
        } else {
            // Handle the case where the user cancels or closes the dialog
            JOptionPane.showMessageDialog(null,
                    "No input received.",
                    "Cancelled",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static ApplicationContext getContext() {
        return context;
    }
    public static void main(String[] args) {
        setUpApi();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppView appView = context.getBean(AppView.class);

        // Set up the application
        appView.setVisible(true);
    }
}
