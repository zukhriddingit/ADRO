package com.example.adro;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MyProfileController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    public void myProfile(){
        Label name = new Label();
        name.setText("SALJ");
        Label dateOfBirth = new Label();
        dateOfBirth.setText("Date of birth");
        VBox vBox = new VBox();
    }
}
