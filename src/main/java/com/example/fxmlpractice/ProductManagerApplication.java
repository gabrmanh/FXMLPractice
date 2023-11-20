package com.example.fxmlpractice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ProductManagerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        final Pane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("productmanager.fxml")));
        Scene scene = new Scene(pane, 600, 410);
        stage.setTitle("Product Manager");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}