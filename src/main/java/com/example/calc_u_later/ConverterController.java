package com.example.calc_u_later;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ConverterController {

    @FXML
    private ComboBox<String> degreesInputComboBox;
    @FXML
    private TextField degreesTextField;
    @FXML
    private ComboBox<String> degreesOutputComboBox;
    @FXML
    private TextField degreesResultTextField;

    @FXML
    private ComboBox<String> lengthComboBox;
    @FXML
    private TextField lengthTextField;
    @FXML
    private ComboBox<String> lengthOutputComboBox;
    @FXML
    private TextField lengthResultTextField;

    @FXML
    private ComboBox<String> weightComboBox;
    @FXML
    private TextField weightTextField;
    @FXML
    private ComboBox<String> weightOutputComboBox;
    @FXML
    private TextField weightResultTextField;

    @FXML
    private ComboBox<String> volumeComboBox;
    @FXML
    private TextField volumeTextField;
    @FXML
    private ComboBox<String> volumeOutputComboBox;
    @FXML
    private TextField volumeResultTextField;

    @FXML
    private void convertDegrees() {
        String inputUnit = degreesInputComboBox.getValue();
        String outputUnit = degreesOutputComboBox.getValue();
        String inputValue = degreesTextField.getText();

        if (inputUnit == null || outputUnit == null || inputValue.isEmpty()) {
            degreesResultTextField.setText("Invalid input");
            return;
        }

        try {
            double input = Double.parseDouble(inputValue);
            double buffer;
            double result;

            switch (inputUnit) {
                case "Celsius" -> buffer = input;
                case "Kelvin" -> buffer = kelvinToCelsius(input);
                case "Fahrenheit" -> buffer = fahrenheitToCelsius(input);
                default -> {
                    degreesResultTextField.setText("Conversion not supported");
                    return;
                }
            }

            switch (outputUnit) {
                case "Celsius" -> result = buffer;
                case "Kelvin" -> result = celsiusToKelvin(buffer);
                case "Fahrenheit" -> result = celsiusToFahrenheit(buffer);
                default -> {
                    degreesResultTextField.setText("Conversion not supported");
                    return;
                }
            }

            degreesResultTextField.setText(String.valueOf(result));

        } catch (NumberFormatException e) {
            degreesResultTextField.setText("Invalid input");
        }
    }

    private double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    private double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    @FXML
    private void convertLength() {
        String inputUnit = lengthComboBox.getValue();
        String outputUnit = lengthOutputComboBox.getValue();
        String inputValue = lengthTextField.getText();

        if (inputUnit == null || outputUnit == null || inputValue.isEmpty()) {
            lengthResultTextField.setText("Invalid input");
            return;
        }

        try {
            double input = Double.parseDouble(inputValue);
            double buffer;
            double result;

            switch (inputUnit) {
                case "Meter" -> buffer = input;
                case "Centimeter" -> buffer = centimeterToMeter(input);
                case "Mile" -> buffer = mileToMeter(input);
                case "Inch" -> buffer = inchToMeter(input);
                default -> {
                    lengthResultTextField.setText("Conversion not supported");
                    return;
                }
            }

            switch (outputUnit) {
                case "Meter" -> result = buffer;
                case "Centimeter" -> result = meterToCentimeter(buffer);
                case "Mile" -> result = meterToMile(buffer);
                case "Inch" -> result = meterToInch(buffer);
                default -> {
                    lengthResultTextField.setText("Conversion not supported");
                    return;
                }
            }

            lengthResultTextField.setText(String.valueOf(result));

        } catch (NumberFormatException e) {
            lengthResultTextField.setText("Invalid input");
        }
    }

    private double centimeterToMeter(double centimeter) {
        return centimeter / 100;
    }

    private double meterToCentimeter(double meter) {
        return meter * 100;
    }

    private double mileToMeter(double mile) {
        return mile * 1609.34;
    }

    private double meterToMile(double meter) {
        return meter / 1609.34;
    }

    private double inchToMeter(double inch) {
        return inch * 0.0254;
    }

    private double meterToInch(double meter) {
        return meter / 0.0254;
    }

    @FXML
    private void convertWeight() {
        String inputUnit = weightComboBox.getValue();
        String outputUnit = weightOutputComboBox.getValue();
        String inputValue = weightTextField.getText();

        if (inputUnit == null || outputUnit == null || inputValue.isEmpty()) {
            weightResultTextField.setText("Invalid input");
            return;
        }

        try {
            double input = Double.parseDouble(inputValue);
            double buffer;
            double result;

            switch (inputUnit) {
                case "Gram" -> buffer = input;
                case "Kilogram" -> buffer = kilogramToGram(input);
                case "Pound" -> buffer = poundToGram(input);
                case "ounces" -> buffer = ouncesToGram(input);
                default -> {
                    weightResultTextField.setText("Conversion not supported");
                    return;
                }
            }

            switch (outputUnit) {
                case "Gram" -> result = buffer;
                case "Kilogram" -> result = gramToKilogram(buffer);
                case "Pound" -> result = gramToPound(buffer);
                case "ounces" -> result = gramToOunces(buffer);
                default -> {
                    weightResultTextField.setText("Conversion not supported");
                    return;
                }
            }

            weightResultTextField.setText(String.valueOf(result));

        } catch (NumberFormatException e) {
            weightResultTextField.setText("Invalid input");
        }
    }

    private double kilogramToGram(double kilogram) {
        return kilogram * 1000;
    }

    private double gramToKilogram(double gram) {
        return gram / 1000;
    }

    private double poundToGram(double pound) {
        return pound * 453.592;
    }

    private double gramToPound(double gram) {
        return gram / 453.592;
    }

    private double ouncesToGram(double ounces) {
        return ounces * 28.3495;
    }

    private double gramToOunces(double gram) {
        return gram / 28.3495;
    }

    @FXML
    private void convertVolume() {
        String inputUnit = volumeComboBox.getValue();
        String outputUnit = volumeOutputComboBox.getValue();
        String inputValue = volumeTextField.getText();

        if (inputUnit == null || outputUnit == null || inputValue.isEmpty()) {
            volumeResultTextField.setText("Invalid input");
            return;
        }

        try {
            double input = Double.parseDouble(inputValue);
            double buffer;
            double result;

            switch (inputUnit) {
                case "Liter" -> buffer = input;
                case "Milliliter" -> buffer = milliliterToLiter(input);
                case "Gallon" -> buffer = gallonToLiter(input);
                case "Cubic Inch" -> buffer = cubicInchToLiter(input);
                default -> {
                    volumeResultTextField.setText("Conversion not supported");
                    return;
                }
            }

            switch (outputUnit) {
                case "Liter" -> result = buffer;
                case "Milliliter" -> result = literToMilliliter(buffer);
                case "Gallon" -> result = literToGallon(buffer);
                case "Cubic Inch" -> result = literToCubicInch(buffer);
                default -> {
                    volumeResultTextField.setText("Conversion not supported");
                    return;
                }
            }

            volumeResultTextField.setText(String.valueOf(result));

        } catch (NumberFormatException e) {
            volumeResultTextField.setText("Invalid input");
        }
    }

    private double milliliterToLiter(double milliliter) {
        return milliliter / 1000;
    }

    private double literToMilliliter(double liter) {
        return liter * 1000;
    }

    private double gallonToLiter(double gallon) {
        return gallon * 3.78541;
    }

    private double literToGallon(double liter) {
        return liter / 3.78541;
    }

    private double cubicInchToLiter(double cubicInch) {
        return cubicInch * 0.0163871;
    }

    private double literToCubicInch(double liter) {
        return liter / 0.0163871;
    }
}
