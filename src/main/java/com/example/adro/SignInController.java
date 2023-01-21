package com.example.adro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class SignInController {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
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
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Dashboard.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        } else {
            System.out.println("another error!");
        }

    }
}
