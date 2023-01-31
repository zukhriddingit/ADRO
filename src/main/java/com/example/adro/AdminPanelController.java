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
    private Button addMovieBtn1;

    @FXML
    private Button addMovieBtn11;

    @FXML
    private Button addMovieBtn21;

    @FXML
    private ComboBox<String> combo_genre;

    @FXML
    private ComboBox<String> combo_languages;

    @FXML
    private ComboBox<String> combo_session;

    @FXML
    private TextArea movieDescription;

    @FXML
    private TextField movieDuration;

    @FXML
    private DatePicker movieEndDate;

    @FXML
    private TextField moviePrice;

    @FXML
    private DatePicker movieStartDate;

    @FXML
    private TextField movieTitle;

    @FXML
    private TableView<?> table;

    @FXML
    private Label welcomeText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] genres = {"Action", "Thriller", "Comedy", "Horror"};
        combo_genre.getItems().addAll(genres);
        String[] languages = {"English", "Russian", "Uzbek"};
        combo_languages.getItems().addAll(languages);
        String[] sessions = {"10:00", "12:00", "15:00", "18:00", "21:00"};
        combo_session.getItems().addAll(sessions);
    }
}