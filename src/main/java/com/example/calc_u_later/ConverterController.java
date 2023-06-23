package com.example.calc_u_later;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ConverterController {

    @FXML
    private ComboBox<String> degresInputComboBox;
    @FXML
    private TextField degresTextField;
    @FXML
    private ComboBox<String> degresOutputComboBox;
    @FXML
    private TextField degresResultTextField;

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
        String inputUnit = degresInputComboBox.getValue();
        String outputUnit = degresOutputComboBox.getValue();
        String inputValue = degresTextField.getText();

        // Vérifier que les champs requis sont sélectionnés ou remplis
        if (inputUnit == null || outputUnit == null || inputValue.isEmpty()) {
            degresResultTextField.setText("Invalid input");
            return;
        }

        try {
            double input = Double.parseDouble(inputValue);
            double buffer;
            double result = 0;

            switch (inputUnit) {
                case "Celsius":
                    buffer = input;
                    break;
                case "Kelvin":
                    buffer = kelvinToCelsius(input);
                    break;
                case "Fahrenheit":
                    buffer = fahrenheitToCelsius(input);
                    break;
                default:
                    degresResultTextField.setText("Conversion not supported");
                    return;
            }

            switch (outputUnit) {
                case "Celsius":
                    result = buffer;
                    break;
                case "Kelvin":
                    result = celsiusToKelvin(buffer);
                    break;
                case "Fahrenheit":
                    result = celsiusToFahrenheit(buffer);
                    break;
                default:
                    degresResultTextField.setText("Conversion not supported");
                    return;
            }

            degresResultTextField.setText(String.valueOf(result));

        } catch (NumberFormatException e) {
            degresResultTextField.setText("Invalid input");
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

        // Vérifier que les champs requis sont sélectionnés ou remplis
        if (inputUnit == null || outputUnit == null || inputValue.isEmpty()) {
            lengthResultTextField.setText("Invalid input");
            return;
        }

        try {
            double input = Double.parseDouble(inputValue);
            double buffer;
            double result = 0;

            switch (inputUnit) {
                case "Meter":
                    buffer = input;
                    break;
                case "Centimeter":
                    buffer = centimeterToMeter(input);
                    break;
                case "Mile":
                    buffer = mileToMeter(input);
                    break;
                case "Inch":
                    buffer = inchToMeter(input);
                    break;
                default:
                    lengthResultTextField.setText("Conversion not supported");
                    return;
            }

            switch (outputUnit) {
                case "Meter":
                    result = buffer;
                    break;
                case "Centimeter":
                    result = meterToCentimeter(buffer);
                    break;
                case "Mile":
                    result = meterToMile(buffer);
                    break;
                case "Inch":
                    result = meterToInch(buffer);
                    break;
                default:
                    lengthResultTextField.setText("Conversion not supported");
                    return;
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

        // Vérifier que les champs requis sont sélectionnés ou remplis
        if (inputUnit == null || outputUnit == null || inputValue.isEmpty()) {
            weightResultTextField.setText("Invalid input");
            return;
        }

        try {
            double input = Double.parseDouble(inputValue);
            double buffer;
            double result = 0;

            switch (inputUnit) {
                case "Gram":
                    buffer = input;
                    break;
                case "Kilogram":
                    buffer = kilogramToGram(input);
                    break;
                case "Pound":
                    buffer = poundToGram(input);
                    break;
                case "ounces":
                    buffer = ouncesToGram(input);
                    break;
                default:
                    weightResultTextField.setText("Conversion not supported");
                    return;
            }

            switch (outputUnit) {
                case "Gram":
                    result = buffer;
                    break;
                case "Kilogram":
                    result = gramToKilogram(buffer);
                    break;
                case "Pound":
                    result = gramToPound(buffer);
                    break;
                case "ounces":
                    result = gramToOunces(buffer);
                    break;
                default:
                    weightResultTextField.setText("Conversion not supported");
                    return;
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

        // Vérifier que les champs requis sont sélectionnés ou remplis
        if (inputUnit == null || outputUnit == null || inputValue.isEmpty()) {
            volumeResultTextField.setText("Invalid input");
            return;
        }

        try {
            double input = Double.parseDouble(inputValue);
            double buffer;
            double result = 0;

            switch (inputUnit) {
                case "Liter":
                    buffer = input;
                    break;
                case "Cubic":
                    buffer = cubicToLiter(input);
                    break;
                case "Gallon":
                    buffer = gallonToLiter(input);
                    break;
                case "Cubic feet":
                    buffer = cubicFeetToLiter(input);
                    break;
                default:
                    volumeResultTextField.setText("Conversion not supported");
                    return;
            }

            switch (outputUnit) {
                case "Liter":
                    result = buffer;
                    break;
                case "Cubic":
                    result = literToCubic(buffer);
                    break;
                case "Gallon":
                    result = literToGallon(buffer);
                    break;
                case "Cubic feet":
                    result = literToCubicFeet(buffer);
                    break;
                default:
                    volumeResultTextField.setText("Conversion not supported");
                    return;
            }

            volumeResultTextField.setText(String.valueOf(result));

        } catch (NumberFormatException e) {
            volumeResultTextField.setText("Invalid input");
        }
    }

    private double cubicToLiter(double cubic) {
        return cubic * 1000;
    }

    private double literToCubic(double liter) {
        return liter / 1000;
    }

    private double gallonToLiter(double gallon) {
        return gallon * 3.78541;
    }

    private double literToGallon(double liter) {
        return liter / 3.78541;
    }

    private double cubicFeetToLiter(double cubicFeet) {
        return cubicFeet * 28.3168;
    }

    private double literToCubicFeet(double liter) {
        return liter / 28.3168;
    }

}
