package com.example.adro;

import javafx.event.ActionEvent;
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
    private Button deleteButton;

    @FXML
    private Button editButton;

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


    public void editAction(ActionEvent event) {

    }

    public void deleteAction(ActionEvent event) {

    }

    public void addAction(ActionEvent event) {
        String sql = "INSERT INTO `movie` (`title`, `description`, `genre`, `language`, `duration`, `session`, `start_date`, `end_date`, `price`) VALUES ('"+movieTitle+"','"+movieDescription+"','"+combo_genre+"','"+combo_languages+"','"+movieDuration+"','"+combo_session+"','"+movieStartDate+"','"+movieEndDate+"','"+moviePrice+"')";

    }
}