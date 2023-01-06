package com.example.adro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpPageController {

    @FXML
    private Label welcomeText;

    @FXML
    private TextField fullname;
    @FXML
    private TextField email;
    @FXML
    private TextField phoneNum;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;

    @FXML
    private DatePicker dateOfBirth;

    @FXML
    protected void registerAction(ActionEvent event) throws SQLException, IOException {

        DataBaseConnect dataBaseConnect = new DataBaseConnect();
        String sql = "INSERT INTO `register`(`fullname`, `email`, `phone`, `username`, `password`, `dateOfBirth`) VALUES ('"+fullname.getText()+"','"+email.getText()+"','"+phoneNum.getText()+"','"+userName.getText()+"','"+password.getText()+"','"+dateOfBirth.getValue()+"')";
        dataBaseConnect.insertData(sql);
        Node node = (Node)event.getSource();
        Stage dialogStage = (Stage) node.getScene().getWindow();
        dialogStage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Dashboard.fxml")));
        dialogStage.setScene(scene);
        dialogStage.show();

    }

}