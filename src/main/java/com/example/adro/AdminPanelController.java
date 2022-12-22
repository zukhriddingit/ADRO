package com.example.adro;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AdminPanelController {

    @FXML
    private TableColumn<?, ?> ID;

    @FXML
    private TableColumn<?, ?> MovieTitle;

    @FXML
    private TableColumn<?, ?> NumberOfTickets;

    @FXML
    private DatePicker movieDate;

    @FXML
    private TextArea movieDescription;

    @FXML
    private ChoiceBox<String> movieGenre;

    @FXML
    private ChoiceBox<String> movieLanguage;

    @FXML
    private TextField movieTitle;

    @FXML
    private TableView<?> table;

    @FXML
    private Label welcomeText;


    public ChoiceBox<?> getMovieGenre() {
        movieGenre.getItems().add("Action");
        movieGenre.getItems().add("Thriller");
        return movieGenre;
    }

}
