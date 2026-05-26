package com.example.adro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CartPageController implements Initializable {

    @FXML
    private TableView<Movie> movieTable;
    @FXML
    private TableColumn<Movie, String> nameCol;
    @FXML
    private TableColumn<Movie, String> theatreCol;
    @FXML
    private TableColumn<Movie, String> idCol;
    @FXML
    private TableColumn<Movie, String> languageCol;
    @FXML
    private TableColumn<Movie, String> timeCol;
    @FXML
    private TableColumn<Movie, String> ticketsCol;
    @FXML
    private TableColumn<Movie, String> priceCol;



    @Override
    public void initialize(URL url, ResourceBundle rb){
        loadDate();
    }

    private final CartRepository cartRepository = new CartRepository();
    ObservableList<Movie> Movielist = FXCollections.observableArrayList();

    private void refreshable() throws SQLException {
        Movielist.clear();
        Movielist.addAll(cartRepository.fetchCartMovies());
        movieTable.setItems(Movielist);
    }

    private void loadDate() {
        try {
            refreshable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        theatreCol.setCellValueFactory(new PropertyValueFactory<>("theatre"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        languageCol.setCellValueFactory(new PropertyValueFactory<>("language"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        ticketsCol.setCellValueFactory(new PropertyValueFactory<>("tickets_num"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    @FXML
    private void deleteRow(ActionEvent event){
        movieTable.getItems().removeAll(movieTable.getSelectionModel().getSelectedItem());
    }

}
