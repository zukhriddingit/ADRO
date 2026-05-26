package com.example.adro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminPanelController implements Initializable {
    @FXML
    private TableView<AdminMovie> tableAdmin;

    @FXML
    private TableColumn<AdminMovie, String> MovieTitle;

    @FXML
    private TableColumn<AdminMovie,String> MovieDescription;

    @FXML
    private TableColumn<AdminMovie,String> Genre;

    @FXML
    private TableColumn<AdminMovie,String> Lang;

    @FXML
    private TableColumn<AdminMovie,String> Duration;

    @FXML
    private TableColumn<AdminMovie,String> NumberTickets;

    @FXML
    private TableColumn<AdminMovie,String> Session;

    @FXML
    private TableColumn<AdminMovie,String> StartDate;

    @FXML
    private TableColumn<AdminMovie, String> EndDate;

    @FXML
    private TableColumn<AdminMovie,String> Price;
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
    private TextField numberTickets;

    @FXML
    private DatePicker movieEndDate;

    @FXML
    private TextField moviePrice;

    @FXML
    private DatePicker movieStartDate;

    @FXML
    private TextField movieTitle;



    @FXML
    private Label welcomeText;

    // for database and table
    private final MovieRepository movieRepository = new MovieRepository();
    ObservableList<AdminMovie> MovielistAdmin = FXCollections.observableArrayList();

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
        loadData();
    }

    public void addAction(ActionEvent event) throws SQLException {
        if (isNumeric(movieDuration.getText())&&isNumeric(moviePrice.getText())&&isNumeric(numberTickets.getText())){
            AdminMovie movie = new AdminMovie(
                    movieTitle.getText(),
                    movieDescription.getText(),
                    combo_genre.getValue(),
                    combo_languages.getValue(),
                    Integer.parseInt(movieDuration.getText()),
                    Integer.parseInt(numberTickets.getText()),
                    combo_session.getValue(),
                    movieStartDate.getValue() == null ? null : Date.valueOf(movieStartDate.getValue()),
                    movieEndDate.getValue() == null ? null : Date.valueOf(movieEndDate.getValue()),
                    Integer.parseInt(moviePrice.getText())
            );
            movieRepository.addMovie(movie);
            loadData();
        }else System.out.println("Something went wrong");
    }

    public boolean isNumeric(String val){
        try{
            Integer.valueOf(val);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    // for Table
    private void refreshable() throws SQLException {
        MovielistAdmin.clear();
        MovielistAdmin.addAll(movieRepository.fetchMovies());
        tableAdmin.setItems(MovielistAdmin);
    }

    private void loadData() {
        try {
            refreshable();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("tralala");
        }

        MovieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        MovieDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        Genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        Lang.setCellValueFactory(new PropertyValueFactory<>("language"));
        Session.setCellValueFactory(new PropertyValueFactory<>("session"));
        NumberTickets.setCellValueFactory(new PropertyValueFactory<>("numberTickets"));
        Duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        StartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        EndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
    }
}