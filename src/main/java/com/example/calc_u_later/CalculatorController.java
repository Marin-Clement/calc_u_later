package com.example.calc_u_later;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.EmptyStackException;
import java.util.Stack;

public class CalculatorController {

    @FXML
    private TextField display;

    private Stack<Double> numberStack;
    private Stack<String> operatorStack;
    private boolean decimalClicked;

    @FXML
    private void initialize() {
        numberStack = new Stack<>();
        operatorStack = new Stack<>();
        decimalClicked = false;
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();

        switch (buttonText) {
            case "=":
                calculate();
                break;
            case "CE":
                clearDisplay();
                break;
            case ".":
                handleDecimal();
                break;
            default:
                appendToDisplay(buttonText);
                break;
        }
    }

    private void calculate() {
        String input = display.getText();

        if (input.isEmpty()) {
            return;
        }

        String[] tokens = input.split(" ");

        for (String token : tokens) {
            if (isNumber(token)) {
                numberStack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && hasHigherPrecedence(operatorStack.peek(), token)) {
                    evaluateOperation();
                }
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    evaluateOperation();
                }
                operatorStack.pop();
            }
        }
    }

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private boolean hasHigherPrecedence(String op1, String op2) {
        return (op2.equals("*") || op2.equals("/")) && !op1.equals("(");
    }

    private void evaluateOperation() {
        double operand2 = numberStack.pop();
        double operand1 = numberStack.pop();
        String operator = operatorStack.pop();
        double result = 0;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
        }

        numberStack.push(result);
    }

    private void clearDisplay() {
        display.clear();
        numberStack.clear();
        operatorStack.clear();
        decimalClicked = false;
    }

    private void handleDecimal() {
        if (!decimalClicked) {
            appendToDisplay(".");
            decimalClicked = true;
        }
    }

    private void appendToDisplay(String text) {
        display.appendText(text);
    }
}
