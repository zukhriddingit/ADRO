package com.example.adro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignUpPageController implements Initializable {

    private final UserRepository userRepository = new UserRepository();

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
    private VBox imageVbox;

    @FXML
    private DatePicker dateOfBirth;

    @FXML
    private Label errorMsg;


    @FXML
    protected void registerAction(ActionEvent event) throws SQLException, IOException {
        if (!email.getText().contains("@")){
            errorMsg.setText("Email should contain '@'");
        }else if(userRepository.usernameExists(userName.getText(), UserTable.REGISTER)){
            errorMsg.setText("This username already exists!");
        }else {
            String passwordHash = PasswordHasher.hash(password.getText());
            userRepository.createUser(
                    fullname.getText(),
                    email.getText(),
                    phoneNum.getText(),
                    userName.getText(),
                    passwordHash,
                    dateOfBirth.getValue()
            );
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
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Login.fxml")));
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView imageView =new ImageView();
        Image image = new Image(imageUrl("/pictures/black-panther-web.jpg"));
        imageView.setFitHeight(463);
        imageView.setFitWidth(350);
        imageView.setImage(image);
        imageVbox.getChildren().add(imageView);
    }

    private String imageUrl(String resourcePath) {
        return Objects.requireNonNull(getClass().getResource(resourcePath), "Missing resource: " + resourcePath)
                .toExternalForm();
    }
}