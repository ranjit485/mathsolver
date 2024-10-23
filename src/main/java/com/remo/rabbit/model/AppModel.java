package com.remo.rabbit.model;

import org.springframework.stereotype.Component;

@Component
public class AppModel {
    private String message;

    public AppModel() {
        this.message = "Hello, World!";
    }

    public String getMessage() {
        return message;
    }
}
