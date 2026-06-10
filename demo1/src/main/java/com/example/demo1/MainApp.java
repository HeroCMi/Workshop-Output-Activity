package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApp extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        primaryStage.setTitle("Student Management System");

        // ✅ FIXED WINDOW SIZE — BIG & VISIBLE
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);

        switchToList(); // open list screen first
    }

    public static void switchToList() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/com/example/demo1/list-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.toFront(); // ✅ BRING TO FRONT — NEVER HIDDEN
    }

    public static void switchToForm() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/com/example/demo1/form-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.toFront(); // ✅ BRING TO FRONT
    }

    public static void main(String[] args) {
        launch();
    }
}