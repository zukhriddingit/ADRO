package com.example.adro;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardPaneController implements Initializable {
    @FXML
    private ScrollPane scrollPane_NewMovies2;

    @FXML
    private ScrollPane scrollPane_TopMovies2;

    @FXML
    private Pane dashboardPane;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        movie(scrollPane_TopMovies2,scrollPane_NewMovies2);


    }
    public  void movie(ScrollPane scrollPane_TopMovies,ScrollPane scrollPane_NewMovies){

        File file = new File("src/main/java/pictures");
        HBox hBox = new HBox(); // for scrollpane
        hBox.setAlignment(Pos.BASELINE_CENTER);

        try {
            hBox.getChildren().addAll(
                    createCustomNode("TOP GUN", "top gun", file.toURI().toURL().toString() + "movie_1.jpeg", "image1"),
                    createCustomNode("Matrix", "matrix", file.toURI().toURL().toString() + "movie_3.jpeg", "image3"),
                    createCustomNode("Interstellar", "interstellar", file.toURI().toURL().toString() + "movie_4.jpg", "image4"),
                    createCustomNode("Inception", "inception", file.toURI().toURL().toString() + "movie_5.jpg", "image5"),
                    createCustomNode("The Dark Knight", "TheDarkKnight", file.toURI().toURL().toString() + "movie_6.jpg", "image6"),
                    createCustomNode("LUCY", "lucy", file.toURI().toURL().toString() + "movie_7.jpg", "image7"),
                    createCustomNode("WEDNESDAY", "wednesday", file.toURI().toURL().toString() + "movie_8.jpg", "image8"),
                    createCustomNode("Forrest Gump", "ForrestGump", file.toURI().toURL().toString() + "movie_10.jpg", "image9"),
                    createCustomNode("Nope", "nope", file.toURI().toURL().toString() + "verMovie_2.jpeg", "image"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        scrollPane_TopMovies.setContent(hBox);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BASELINE_CENTER);
        try {
            hbox.getChildren().addAll(
                    createCustomNode("Puss in Boots", "pussInBoots", file.toURI().toURL().toString() + "new_movie1.jpg", "new_image1"),
                    createCustomNode("Avatar II ", "avatar2", file.toURI().toURL().toString() + "new_movie2.jpg", "new_image2"),
                    createCustomNode("High Heat", "HighHeat", file.toURI().toURL().toString() + "new_movie3.jpg", "new_image3"),
                    createCustomNode("Violent Night", "ViolentNight", file.toURI().toURL().toString() + "new_movie4.jpg", "new_image4"),
                    createCustomNode("Troll", "troll", file.toURI().toURL().toString() + "new_movie5.jpg", "new_image5"),
                    createCustomNode("Wakanda Forever", "WakandaForever", file.toURI().toURL().toString() + "new_movie6.jpg", "new_image6"),
                    createCustomNode("Detective Knight", "DetectiveKnight", file.toURI().toURL().toString() + "new_movie7.jpg", "new_image7"),
                    createCustomNode("The Woman King", "WomanKing", file.toURI().toURL().toString() + "new_movie8.jpg", "new_image8"),
                    createCustomNode("All Quiet on the Western Front", "WesternFront", file.toURI().toURL().toString() + "movie_9.jpg", "new_image9"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        scrollPane_NewMovies.setContent(hbox);
    }

    public Node createCustomNode(String movieName, String movieID, String imageLink, String imageID) {
        ImageView imageView = new ImageView();
        imageView.setImage(new Image(imageLink));
        imageView.setFitHeight(200);
        imageView.setFitWidth(150);
        imageView.setId(imageID);

        // For 1 vertical column
        VBox vBox1 = new VBox();
        Button button = new Button();
        button.setMaxWidth(150);
        button.setMaxHeight(210);
        button.setGraphic(imageView);
        button.setStyle("-fx-background-color: transparent;" + "-fx-cursor:hand;");

        Label label = new Label(movieName);
        label.setStyle("-fx-text-fill:white;" + "-fx-font-weight: 700;");
        vBox1.setSpacing(10);
        vBox1.getChildren().add(button);
        vBox1.getChildren().add(label);
        vBox1.setStyle("-fx-padding: 5;");
        vBox1.setAlignment(Pos.CENTER);


        //Giving onAction command to the movie  button

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Parent fxml;
                try {
                    fxml = FXMLLoader.load(getClass().getResource("AsilbeksVersionMoviePage.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                dashboardPane.getChildren().removeAll();
                dashboardPane.getChildren().setAll(fxml);

            }
        });
        return vBox1;
    }
}
