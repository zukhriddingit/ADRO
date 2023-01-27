package com.example.adro;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;



public class AsilbeksVersionMyProfileController implements Initializable{

    @FXML
    private ImageView Picture;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File file = new File("src/main/java/pictures");
        ImageView imageView = new ImageView();
        try {
            imageView.setImage(new Image(file.toURI().toURL().toString()+"new_movie3.jpg"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}