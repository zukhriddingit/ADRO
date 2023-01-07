package com.example.adro;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MyProfileController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private Label profile_age;

    @FXML
    private Button profile_editbtn;

    @FXML
    private Label profile_email;

    @FXML
    private Label profile_name;

    @FXML
    private Label profile_password;

    @FXML
    private Label profile_phonenumber;

    @FXML
    private ImageView profile_picture;

    @FXML
    private Label profile_username;
    public void myProfile(){
        Label name = new Label();
        name.setText("SALJ");
        Label dateOfBirth = new Label();
        dateOfBirth.setText("Date of birth");
        VBox vBox = new VBox();
    }
}