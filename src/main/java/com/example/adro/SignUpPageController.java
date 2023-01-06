package com.example.adro;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

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
    protected void registerAction() throws SQLException {

        DataBaseConnect dataBaseConnect = new DataBaseConnect();
        String sql = "INSERT INTO `register`(`fullname`, `email`, `phone`, `username`, `password`, `dateOfBirth`) VALUES ('"+fullname.getText()+"','"+email.getText()+"','"+phoneNum.getText()+"','"+userName.getText()+"','"+password.getText()+"','"+dateOfBirth.getValue()+"')";
        dataBaseConnect.insertData(sql);
    }

}