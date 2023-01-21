package com.example.adro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpPageController {

    private DataBaseConnect dataBaseConnect;

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
    private Label errorMsg;


    @FXML
    protected void registerAction(ActionEvent event) throws SQLException, IOException {

        DataBaseConnect dataBaseConnect = new DataBaseConnect();
        String sql = "INSERT INTO `register`(`fullname`, `email`, `phone`, `username`, `password`, `dateOfBirth`) VALUES ('"+fullname.getText()+"','"+email.getText()+"','"+phoneNum.getText()+"','"+userName.getText()+"','"+password.getText()+"','"+dateOfBirth.getValue()+"')";
        if (!email.getText().contains("@")){
            errorMsg.setText("Email should contain '@'");
        }else if(dataBaseConnect.getInfo(userName.getText())){
            errorMsg.setText("This username already exists!");
        }else {
            dataBaseConnect.insertData(sql);
            Node node = (Node)event.getSource();
            Stage dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Dashboard.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        }

    }

    public void toSignIn(ActionEvent event) throws IOException {
        Node node = (Node)event.getSource();
        Stage dialogStage = (Stage) node.getScene().getWindow();
        dialogStage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("SignIn.fxml")));
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}