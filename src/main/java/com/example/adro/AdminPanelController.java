package com.example.adro;

import com.dlsc.formsfx.model.structure.IntegerField;
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
import java.sql.*;
import java.util.ResourceBundle;

public class AdminPanelController implements Initializable {

    @FXML
    private TableColumn<AdminMovie, String> MovieTitle;

    @FXML
    private TableColumn<AdminMovie,String> MovieDescription;

    @FXML
    private TableColumn<AdminMovie,String> Genre;

    @FXML
    private TableColumn<AdminMovie,String> Lang;

    @FXML
    private TableColumn<AdminMovie,Integer> Duration;

    @FXML
    private TableColumn<AdminMovie,String> Session;

    @FXML
    private TableColumn<AdminMovie,Date> StartDate;

    @FXML
    private TableColumn<AdminMovie, Date> EndDate;

    @FXML
    private TableColumn<AdminMovie,Integer> Price;
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
    private TableView<AdminMovie> tableAdmin;

    @FXML
    private Label welcomeText;

    // for database and table
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Movie movie = null;
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

    }

    public void addAction(ActionEvent event) throws SQLException {
        DataBaseConnect dataCon = new DataBaseConnect();
        if (isNumeric(movieDuration.getText())&&isNumeric(moviePrice.getText())){
            String sql = "INSERT INTO `movies` (`title`, `description`, `genre`, `language`, `duration`, `session`, `start_date`, `end_date`, `price`) VALUES ('"+movieTitle.getText()+"','"+movieDescription.getText()+"','"+combo_genre.getValue()+"','"+combo_languages.getValue()+"','"+Integer.valueOf(movieDuration.getText())+"','"+combo_session.getValue()+"','"+movieStartDate.getValue()+"','"+movieEndDate.getValue()+"','"+Integer.valueOf(moviePrice.getText())+"')";
            dataCon.insertData(sql);
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

        query = "SELECT * FROM movies";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            MovielistAdmin.add(new AdminMovie(
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    resultSet.getString("genre"),
                    resultSet.getString("language"),
                    resultSet.getString("session"),
                    resultSet.getInt("duration"),
                    resultSet.getInt("price"),
                    resultSet.getDate("start_date"),
                    resultSet.getDate("end_date")
                    ));
            tableAdmin.setItems(MovielistAdmin);
        }
    }

    private void loadDate() {
        connection = DataBaseConnect.getConnect();
        try {
            refreshable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        MovieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        MovieDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        Genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        Lang.setCellValueFactory(new PropertyValueFactory<>("language"));
        Session.setCellValueFactory(new PropertyValueFactory<>("session"));
        Duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        StartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        EndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
    }
}