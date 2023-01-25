package com.example.adro;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminPanelController implements Initializable {

    @FXML
    private TableColumn<?, ?> ID;

    @FXML
    private TableColumn<?, ?> MovieTitle;

    @FXML
    private TableColumn<?, ?> NumberOfTickets;

    @FXML
    private Button addMovieBtn;

    @FXML
    private ComboBox<String> combo_genre;

    @FXML
    private ComboBox<String> combo_languages;

    @FXML
    private DatePicker movieDate;

    @FXML
    private TextArea movieDescription;

    @FXML
    private TextField movieDuration;

    @FXML
    private TextField moviePrice;

    @FXML
    private TextField movieTitle;

    @FXML
    private TableView<?> table;

    @FXML
    private Label welcomeText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] choice = {"Action", "Thriller", "Comedy"};
        combo_genre.getItems().addAll(choice);
        String[] languages = {"English", "Russian", "Uzbek"};
        combo_languages.getItems().addAll(languages);
    }
}
