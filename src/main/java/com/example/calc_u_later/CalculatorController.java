package com.example.calc_u_later;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;

import java.util.Objects;

public class CalculatorController {
    // FXML elements
    @FXML
    private TextField display;

    @FXML
    private ListView<String> history;

    @FXML
    private ListView<String> memoryList;

    // Variables for calculator operations
    private double operand1;
    private double operand2;
    private String operator;
    private boolean isOperatorClicked;
    private double memory;
    private double result;

    @FXML
    private void initialize() {
        // Initialize variables
        operand1 = 0;
        operand2 = 0;
        operator = "";
        result = 0;
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        // Handle button clicks
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        String displayText = display.getText();

        // Play animation for buttons
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), button);
        scaleTransition.setFromX(1.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(2);
        scaleTransition.play();


        // Perform different actions based on the clicked button
        switch (buttonText) {
            // Clear the display and reset variables
            case "CE" -> clearDisplay();

            // Negate the display value (change sign)
            case "+/-" -> negateDisplay();

            // Add decimal point to the display value
            case "." -> addDecimalPoint();

            // Handle basic arithmetic operators (+, -, x, /)
            case "+", "-", "x", "/" -> handleOperatorButton(buttonText, displayText);

            // Calculate percentage
            case "P" -> calculatePercentage(displayText);

            // Calculate trigonometric functions (sin, cos, tan)
            case "sin", "cos", "tan" -> calculateTrigonometricFunction(buttonText, displayText);

            // Calculate inverse trigonometric functions (asin, acos, atan)
            case "asin", "acos", "atan" -> calculateInverseTrigonometricFunction(buttonText, displayText);

            // Calculate square root or square
            case "sqrt", "sqr" -> calculateSquareRootOrSquare(buttonText, displayText);

            // Calculate logarithm (log, ln)
            case "log", "ln" -> calculateLogarithm(buttonText, displayText);

            // Handle memory operations (M+, MR, MC)
            case "M+", "MR", "MC" -> handleMemoryButton(buttonText, displayText);

            // Calculate and display the result
            case "=" -> calculateResult(displayText);

            // Open the converter window
            case "Converter" -> openConverter();

            // Append the clicked button text to the display
            default -> appendToDisplay(buttonText, displayText);
        }
    }

    // Clear the display and reset variables
    private void clearDisplay() {
        display.setText("");
        operand1 = 0;
        operand2 = 0;
        operator = "";
        isOperatorClicked = false;
    }

    // Negate the display value (change sign)
    private void negateDisplay() {
        String displayText = display.getText();
        if (displayText.length() > 0) {
            if (displayText.charAt(0) == '-') {
                display.setText(displayText.substring(1));
            } else {
                display.setText("-" + displayText);
            }
        }
    }

    // Add decimal point to the display value
    private void addDecimalPoint() {
        String displayText = display.getText();
        if (displayText.length() > 0 && !displayText.contains(".")) {
            display.setText(displayText + ".");
        }
    }

    // Handle arithmetic operator button clicks
    private void handleOperatorButton(String buttonText, String displayText) {
        if (displayText.length() > 0) {
            if (operand1 != 0) {
                operand2 = Double.parseDouble(displayText);
                calculateResult(displayText);
            } else {
                operand1 = Double.parseDouble(displayText);
            }
            operator = buttonText;
            isOperatorClicked = true;
        }
    }

    // Calculate percentage
    private void calculatePercentage(String displayText) {
        if (displayText.length() > 0) {
            operand1 = Double.parseDouble(displayText);
            result = operand1 / 100;
            display.setText(String.valueOf(result));
            history.getItems().add(operand1 + " % = " + result);
        }
    }

    // Calculate trigonometric functions (sin, cos, tan)
    private void calculateTrigonometricFunction(String buttonText, String displayText) {
        if (displayText.length() > 0) {
            operand1 = Double.parseDouble(displayText);
            switch (buttonText) {
                case "sin" -> result = Math.sin(operand1);
                case "cos" -> result = Math.cos(operand1);
                case "tan" -> result = Math.tan(operand1);
            }
            display.setText(String.valueOf(result));
            history.getItems().add(buttonText + "(" + operand1 + ") = " + result);
        }
    }

    // Calculate inverse trigonometric functions (asin, acos, atan)
    private void calculateInverseTrigonometricFunction(String buttonText, String displayText) {
        if (displayText.length() > 0) {
            operand1 = Double.parseDouble(displayText);
            switch (buttonText) {
                case "asin" -> result = Math.asin(operand1);
                case "acos" -> result = Math.acos(operand1);
                case "atan" -> result = Math.atan(operand1);
            }
            display.setText(String.valueOf(result));
            history.getItems().add(buttonText + "(" + operand1 + ") = " + result);
        }
    }

    // Calculate square root or square
    private void calculateSquareRootOrSquare(String buttonText, String displayText) {
        if (displayText.length() > 0) {
            operand1 = Double.parseDouble(displayText);
            switch (buttonText) {
                case "sqrt" -> result = Math.sqrt(operand1);
                case "sqr" -> result = Math.pow(operand1, 2);
            }
            display.setText(String.valueOf(result));
            history.getItems().add(buttonText + "(" + operand1 + ") = " + result);
        }
    }

    // Calculate logarithm (log, ln)
    private void calculateLogarithm(String buttonText, String displayText) {
        if (displayText.length() > 0) {
            operand1 = Double.parseDouble(displayText);
            switch (buttonText) {
                case "log" -> result = Math.log10(operand1);
                case "ln" -> result = Math.log(operand1);
            }
            display.setText(String.valueOf(result));
            history.getItems().add(buttonText + "(" + operand1 + ") = " + result);
        }
    }

    // Handle memory operations (M+, MR, MC)
    private void handleMemoryButton(String buttonText, String displayText) {
        if (displayText.length() > 0) {
            operand1 = Double.parseDouble(displayText);
            switch (buttonText) {
                case "M+" -> {
                    memory += operand1;
                    memoryList.getItems().add("new memory value: " + memory);
                }
                case "MR" -> {
                    display.setText(String.valueOf(memory));
                    memoryList.getItems().add("Memory recalled");
                }
                case "MC" -> {
                    memory = 0;
                    memoryList.getItems().add("Memory cleared");
                }
            }
        }
    }

    // Calculate and display the result
    private void calculateResult(String displayText) {
        if (displayText.length() > 0) {
            operand2 = Double.parseDouble(displayText);
            switch (operator) {
                case "+" -> result = operand1 + operand2;
                case "-" -> result = operand1 - operand2;
                case "x" -> result = operand1 * operand2;
                case "/" -> result = operand1 / operand2;
            }
            display.setText(String.valueOf(result));
            history.getItems().add(operand1 + " " + operator + " " + operand2 + " = " + result);
            operand1 = result;
        }
    }


    // Append the clicked button text to the display
    private void appendToDisplay(String buttonText, String displayText) {
        if (isOperatorClicked) {
            display.setText(buttonText);
            isOperatorClicked = false;
        } else {
            display.setText(displayText + buttonText);
        }
    }

    // Open the converter window
    private void openConverter() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("converter-view.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Converter");
            stage.setResizable(false);
            Scene scene = new Scene(root1);
            scene.setFill(Color.BLACK);
            scene.getStylesheets().add(Objects.requireNonNull(Calculator.class.getResource("converter-style.css")).toExternalForm());
            stage.setScene(scene);
            stage.show();

            // fade in animation // change background color to black
            FadeTransition ft = new FadeTransition(Duration.millis(500), root1);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();



        } catch (Exception e) {
            System.out.println("Can't load new window");
        }
    }
}
