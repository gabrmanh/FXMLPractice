package com.example.fxmlpractice;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InputErrorController {

    @FXML
    private Label lbError;
    @FXML
    public void setMessage(String message){
        lbError.setText(message);
    }

    @FXML
    private void closeWindow(){
        final Stage stage = (Stage) lbError.getScene().getWindow();
        stage.close();
    }

}
