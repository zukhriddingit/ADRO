package com.example.adro;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class CartPageController {
    @FXML
    BorderPane borderPane;

    @FXML
    FlowPane flowPane;

    @FXML
    HBox hBox;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        addLabel(flowPane);
    }

    public void addLabel(FlowPane flowPane){
        Label label1 = new Label();
        label1.setText("Movie Theatre");
        Label label2 = new Label();
        label2.setText("Movie Language");
        Label label3 = new Label();
        label3.setText("Movie Time");
        Label label4 = new Label();
        label4.setText("Tickets");
        Label label5 = new Label();
        label5.setText("Price");
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.BASELINE_CENTER);
        hBox.setSpacing(20);
        hBox.getChildren().add(label1);
        hBox.getChildren().add(label2);
        hBox.getChildren().add(label3);
        hBox.getChildren().add(label4);
        hBox.getChildren().add(label5);
        flowPane.getChildren().add(hBox);
    }
}
