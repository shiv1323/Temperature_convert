package com.Shiv1323;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Label welcomeLabel;
    @FXML
    public ChoiceBox<String> choiceLabel;
    @FXML
    public TextField inputLabel;
    @FXML
    public Button covertLabel;
    private static final String C_TO_F = "Celsius to Fahrenheit";
    private static final String F_TO_C = "Fahrenheit to Celsius";
    private boolean isC_TO_F = true;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choiceLabel.getItems().add(C_TO_F);
        choiceLabel.getItems().add(F_TO_C);
        choiceLabel.setValue(C_TO_F);
        choiceLabel.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) ->
                        {
                            if (newValue.equals(isC_TO_F)) isC_TO_F = true;
                            else isC_TO_F = false;
                        }
                );


        covertLabel.setOnAction(event -> {
            covert();
        });
    }

    
    private void covert() {
        String input = inputLabel.getText();
        float inputCovert = 0.0f;
        try{
            inputCovert = Float.parseFloat(input);
        }
        catch (Exception e){
            warnUser();
            return;
        }

        float newTemperature = 0.0f;
        if (isC_TO_F){
            newTemperature = (inputCovert*9/5)+32;
        }
        else {
            newTemperature = (inputCovert-32)*5/9;
        }
        display(newTemperature);
    }

    private void warnUser() {
        Alert alertDialog = new Alert(Alert.AlertType.ERROR);
        alertDialog.setTitle("Error occurred");
        alertDialog.setHeaderText("Invalid Temperature Entered");
        alertDialog.setContentText("Please enter a valid temperature");
        alertDialog.show();
    }

    private void display(float newTemperature) {
        String unit = isC_TO_F?"F":"C";
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("Result");
        alertDialog.setContentText(newTemperature+unit);
        alertDialog.show();
    }
}
