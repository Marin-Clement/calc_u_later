package com.example.calc_u_later;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Calculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Calculator.class.getResource("calc-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),820, 450);
        scene.getStylesheets().add(Objects.requireNonNull(Calculator.class.getResource("calc-style.css")).toExternalForm());
        stage.setResizable(false);
        stage.setTitle("Calc-U-Later");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}