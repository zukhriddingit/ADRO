package com.example.adro;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class DashboardController {

    @FXML
    private FlowPane FlowPaneId;

    @FXML
    protected void onHelloButtonClick() {
            loadMovie(FlowPaneId);
    }



    private void loadMovie(FlowPane flowPane){
        // image inside button
        Button button = new Button();
        Image img = new Image("");
        ImageView imgview = new ImageView(img);
        button.setGraphic(imgview);
        //Label
        Label label = new Label();
        label.setText("Movie discription");
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.BASELINE_CENTER);
        vbox.getChildren().add(button);
        vbox.getChildren().add(label);
        FlowPaneId.getChildren().add(vbox);



    }
}
