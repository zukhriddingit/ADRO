package com.example.adro;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class MoviePageController {
    @FXML
    private Label welcomeText;
    public AnchorPane cartMessagePane;
    private Button cartButton;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void addedMessage(){
        Label cartMessage = new Label();
        cartMessage.setText("ADDED TO CART");
        cartMessagePane.getChildren().add(cartMessage);

    }
}