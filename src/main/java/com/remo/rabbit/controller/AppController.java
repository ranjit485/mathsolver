package com.remo.rabbit.controller;

import com.remo.rabbit.model.AppModel;
import com.remo.rabbit.view.AppView;
import org.springframework.stereotype.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Controller
public class AppController {
    private AppModel model;
    private AppView view;

    public AppController(AppModel model, AppView view) {
        this.model = model;
        this.view = view;

        // Set up action listeners
        view.getClickButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setMessage(model.getMessage());
            }
        });
    }

    public AppModel getModel() {
        return model;
    }

    public void setModel(AppModel model) {
        this.model = model;
    }

    public AppView getView() {
        return view;
    }

    public void setView(AppView view) {
        this.view = view;
    }
}
