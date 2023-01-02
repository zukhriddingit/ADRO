package com.example.adro;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.sql.SQLException;

public class SignUpPageController {

    @FXML
    private Label welcomeText;
    @FXML
    private TextField fullname,dateOfBirth, email,phoneNum,userName,password,ConfirmPassword;

    @FXML
    protected void registerAction() throws SQLException {

        DataBaseConnect dataBaseConnect = new DataBaseConnect();
        String sql = "INSERT INTO `register`(`fullname`, `email`, `phone`, `username`, `password`) VALUES ('"+fullname.getText()+"','"+email.getText()+"','"+phoneNum.getText()+"','"+userName.getText()+"','"+password.getText()+"')";
        dataBaseConnect.insertData(sql);
    }

}
