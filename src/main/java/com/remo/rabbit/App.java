package com.remo.rabbit;

import com.remo.rabbit.config.AppConfig;
import com.remo.rabbit.model.AppModel;
import com.remo.rabbit.view.AppView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

public class App {

    static ApplicationContext context;

    public static ApplicationContext getContext() {
        return context;
    }
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppView appView = context.getBean(AppView.class);

        // Set up the application
        appView.setVisible(true);
    }
}
