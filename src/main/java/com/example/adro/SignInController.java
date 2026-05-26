package com.example.adro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;


public class SignInController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private HBox hbox;
    @FXML
    private Label label;
    @FXML
    private ComboBox<String> comboBox;






    public void signInButton(ActionEvent event) throws IOException, SQLException {
        AuthService authService = new AuthService();
        UserTable table = UserTable.fromSelection(comboBox.getValue());
        String pageName = (table == UserTable.REGISTER) ? "Dashboard" : "AdminPanel";
        if (username.getText().isEmpty()){
            label.setText("User Name is Empty!");
        } else if (password.getText().isEmpty()) {
           label.setText("Password is Empty!");
        } else if (authService.authenticate(username.getText(), password.getText(), table)){
            Node node = (Node)event.getSource();
            Stage dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource(pageName+".fxml")),1366,700);
            dialogStage.setScene(scene);
            dialogStage.show();
        } else {
            label.setText("error!");
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView imageView =new ImageView();
        Image image = new Image(imageUrl("/pictures/photo_2023-02-02_16-57-58.jpg"));
        imageView.setFitHeight(463);
        imageView.setFitWidth(350);
        imageView.setImage(image);
        hbox.getChildren().add(imageView);
        String[] combo = {"ADROMAN", "ADMIN"};
        comboBox.getItems().addAll(combo);
        comboBox.setValue("ADROMAN");


    }

    private String imageUrl(String resourcePath) {
        return Objects.requireNonNull(getClass().getResource(resourcePath)).toExternalForm();
    }
}
