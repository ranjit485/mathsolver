package controller;

import model.AppModel;
import view.AppView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
}
