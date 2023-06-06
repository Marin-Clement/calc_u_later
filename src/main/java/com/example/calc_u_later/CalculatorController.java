package com.example.calc_u_later;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class CalculatorController {

    @FXML
    private TextField resultField;

    private StringBuilder inputBuffer;

    public void initialize() {
        inputBuffer = new StringBuilder();
    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonText = clickedButton.getText();

        switch (buttonText) {
            case "C" -> {
                inputBuffer.setLength(0);
                resultField.setText("");
            }
            case "=" -> {
                resultField.setText(String.valueOf(calculateResult()));
                inputBuffer.setLength(0);
            }
            default -> {
                inputBuffer.append(buttonText);
                resultField.setText(inputBuffer.toString());
            }
        }

        // Create a scale animation for the clicked button
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), clickedButton);
        scaleTransition.setFromX(0.8);
        scaleTransition.setFromY(0.8);
        scaleTransition.setToX(1.0);
        scaleTransition.setToY(1.0);
        scaleTransition.play();

        // Create a fade animation for the resultField
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), resultField);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }


    private double calculateResult() {
        String input = inputBuffer.toString();
        String[] operands = input.split("[+\\-*/]");
        String operator = input.replaceAll("[0-9.]", "");

        return switch (operator) {
            case "+" -> Double.parseDouble(operands[0]) + Double.parseDouble(operands[1]);
            case "-" -> Double.parseDouble(operands[0]) - Double.parseDouble(operands[1]);
            case "*" -> Double.parseDouble(operands[0]) * Double.parseDouble(operands[1]);
            case "/" -> Double.parseDouble(operands[0]) / Double.parseDouble(operands[1]);
            default -> 0.0;
        };
    }
}
