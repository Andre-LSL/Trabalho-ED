package com.faculdade;

import javafx.application.Application;
import javafx.stage.Stage;
import com.faculdade.ui.MainMenu;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainMenu menu = new MainMenu();
        menu.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
