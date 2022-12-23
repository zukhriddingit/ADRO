package com.example.adro;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SignUpPageController {

    @FXML
    private Label welcomeText;
    @FXML
    private TextField fullname,email,phoneNum,userName,password,ConfirmPassword;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

}
