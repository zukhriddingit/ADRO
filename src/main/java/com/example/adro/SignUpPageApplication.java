package com.example.adro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class SignUpPageApplication extends Application {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SignUpPageApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 645);
        stage.setTitle("Cinema Reservation System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
