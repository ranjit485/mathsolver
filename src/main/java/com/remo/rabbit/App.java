package com.remo.rabbit;

import com.remo.rabbit.config.AppConfig;
import com.remo.rabbit.controller.AppController;
import com.remo.rabbit.model.AppModel;
import com.remo.rabbit.view.AppView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppModel appModel = context.getBean(AppModel.class);
        AppView appView = context.getBean(AppView.class);
        AppController appController =context.getBean(AppController.class);

//        AppModel model = new AppModel();
//        AppView view = new AppView();


        AppController controller = new AppController(appModel, appView);

        // Set up the application
        appView.setVisible(true);
    }
}
