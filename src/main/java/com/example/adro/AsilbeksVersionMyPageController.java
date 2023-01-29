package com.example.adro;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;



public class AsilbeksVersionMyPageController implements Initializable{


    @FXML
    private AnchorPane moviepage;

    @FXML
    private AnchorPane movieImage;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/java/pictures");
        ImageView imageView = new ImageView();
        try {
            Image image = new Image(file.toURI().toURL().toString()+"movie_1.jpeg");
            imageView.setImage(image);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Pane container = new Pane();
        container.getChildren().add(imageView);
        container.setPadding(new Insets(10));
        movieImage.getChildren().add(container);




    }
}