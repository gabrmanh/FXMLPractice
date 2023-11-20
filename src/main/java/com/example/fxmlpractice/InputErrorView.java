package com.example.fxmlpractice;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InputErrorView {
    public void show(Exception error){
        try{
            FXMLLoader loader = new FXMLLoader();
            final Pane pane = loader.load(Objects.requireNonNull(getClass().getResource("inputerror.fxml")).openStream());

            final InputErrorController controller = loader.getController();
            if(!(error instanceof InvalidInputException)){
                String message = error.getClass().getSimpleName();
                controller.setMessage(message);
            } else {
                controller.setMessage(error.getMessage());
            }

            final Scene scene = new Scene(pane, 500, 100);
            final Stage stage = new Stage();

            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
