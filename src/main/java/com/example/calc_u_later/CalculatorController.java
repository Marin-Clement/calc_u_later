package com.example.calc_u_later;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.util.Stack;

public class CalculatorController {
    @FXML
    private TextField display;

    @FXML
    private ListView<String> history;

    @FXML
    private ListView<String> memoryList;

    private double operand1;
    private double operand2;
    private String operator;
    private boolean isOperatorClicked;
    private double memory;
    private double result;

    @FXML
    private void initialize() {
        operand1 = 0;
        operand2 = 0;
        operator = "";
        result = 0;
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        String displayText = display.getText();

        switch (buttonText) {
            case "CE" -> clearDisplay();
            case "+/-" -> negateDisplay();
            case "." -> addDecimalPoint();
            case "+", "-", "x", "/" -> handleOperatorButton(buttonText, displayText);
            case "P" -> calculatePercentage(displayText);
            case "sin", "cos", "tan" -> calculateTrigonometricFunction(buttonText, displayText);
            case "asin", "acos", "atan" -> calculateInverseTrigonometricFunction(buttonText, displayText);
            case "sqrt", "sqr" -> calculateSquareRootOrSquare(buttonText, displayText);
            case "log", "ln" -> calculateLogarithm(buttonText, displayText);
            case "M+", "MR", "MC" -> handleMemoryButton(buttonText, displayText);
            case "=" -> calculateResult(displayText);
            case "Converter" -> openConverter();
            default -> appendToDisplay(buttonText, displayText);
        }
    }

    private void clearDisplay() {
        display.setText("");
        operand1 = 0;
        operand2 = 0;
        operator = "";
        isOperatorClicked = false;
    }

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

    private void addDecimalPoint() {
        String displayText = display.getText();
        if (displayText.length() > 0 && !displayText.contains(".")) {
            display.setText(displayText + ".");
        }
    }

    private void handleOperatorButton(String buttonText, String displayText) {
        if (displayText.length() > 0) {
            operand1 = Double.parseDouble(displayText);
            operator = buttonText;
            isOperatorClicked = true;
        }
    }

    private void calculatePercentage(String displayText) {
        if (displayText.length() > 0) {
            operand1 = Double.parseDouble(displayText);
            result = operand1 / 100;
            display.setText(String.valueOf(result));
            history.getItems().add(operand1 + " % = " + result);
        }
    }

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

    private void handleMemoryButton(String buttonText, String displayText) {
        if (displayText.length() > 0) {
            operand1 = Double.parseDouble(displayText);
            switch (buttonText) {
                case "M+" -> {
                    memory = operand1;
                    memoryList.getItems().add(memory + " added to memory");
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
        }
    }

    private void appendToDisplay(String buttonText, String displayText) {
        if (isOperatorClicked) {
            display.setText(buttonText);
            isOperatorClicked = false;
        } else {
            display.setText(displayText + buttonText);
        }
    }

    private void openConverter(){
        System.out.println("oui");
    }
}
