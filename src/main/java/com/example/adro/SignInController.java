package com.example.adro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class SignInController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private HBox hbox;


    public void signInButton(ActionEvent event) throws IOException, SQLException {
        DataBaseConnect db = new DataBaseConnect();
        if (username.getText().isEmpty()){
            System.out.println("error!");
        } else if (password.getText().isEmpty()) {
            System.out.println("error2!");
        } else if (db.checkPassword(username.getText(),password.getText())){
            Node node = (Node)event.getSource();
            Stage dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("AdminPanel.fxml")),1440,780);
            dialogStage.setScene(scene);
            dialogStage.show();
        } else {
            System.out.println("another error!");
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/java/pictures");
        ImageView imageView =new ImageView();
        try {
            Image image = new Image(file.toURI().toURL().toString()+"photo_2023-02-02_16-57-58.jpg");
            imageView.setFitHeight(463);
            imageView.setFitWidth(350);
            imageView.setImage(image);
            hbox.getChildren().add(imageView);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


    }
}
