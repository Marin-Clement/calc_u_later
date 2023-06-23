package com.example.calc_u_later;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class Converter extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Converter.class.getResource("converter-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),400, 300);
        scene.getStylesheets().add(Calculator.class.getResource("converter-style.css").toExternalForm());
        primaryStage.setTitle("Calc-U-Later");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

