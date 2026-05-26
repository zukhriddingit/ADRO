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
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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

        String basePath = "/pictures/";
        HBox hBox = new HBox(); // for scrollpane
        hBox.setAlignment(Pos.BASELINE_CENTER);

        hBox.getChildren().addAll(
                createCustomNode("TOP GUN", "top gun", imageUrl(basePath + "movie_1.jpeg"), "image1"),
                createCustomNode("Matrix", "matrix", imageUrl(basePath + "movie_3.jpeg"), "image3"),
                createCustomNode("Interstellar", "interstellar", imageUrl(basePath + "movie_4.jpg"), "image4"),
                createCustomNode("Inception", "inception", imageUrl(basePath + "movie_5.jpg"), "image5"),
                createCustomNode("The Dark Knight", "TheDarkKnight", imageUrl(basePath + "movie_6.jpg"), "image6"),
                createCustomNode("LUCY", "lucy", imageUrl(basePath + "movie_7.jpg"), "image7"),
                createCustomNode("WEDNESDAY", "wednesday", imageUrl(basePath + "movie_8.jpg"), "image8"),
                createCustomNode("Forrest Gump", "ForrestGump", imageUrl(basePath + "movie_10.jpg"), "image9"),
                createCustomNode("Nope", "nope", imageUrl(basePath + "verMovie_2.jpeg"), "image"));
        scrollPane_TopMovies.setContent(hBox);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BASELINE_CENTER);
        hbox.getChildren().addAll(
                createCustomNode("Puss in Boots", "pussInBoots", imageUrl(basePath + "new_movie1.jpg"), "new_image1"),
                createCustomNode("Avatar II ", "avatar2", imageUrl(basePath + "new_movie2.jpg"), "new_image2"),
                createCustomNode("High Heat", "HighHeat", imageUrl(basePath + "new_movie3.jpg"), "new_image3"),
                createCustomNode("Violent Night", "ViolentNight", imageUrl(basePath + "new_movie4.jpg"), "new_image4"),
                createCustomNode("Troll", "troll", imageUrl(basePath + "new_movie5.jpg"), "new_image5"),
                createCustomNode("Wakanda Forever", "WakandaForever", imageUrl(basePath + "new_movie6.jpg"), "new_image6"),
                createCustomNode("Detective Knight", "DetectiveKnight", imageUrl(basePath + "new_movie7.jpg"), "new_image7"),
                createCustomNode("The Woman King", "WomanKing", imageUrl(basePath + "new_movie8.jpg"), "new_image8"),
                createCustomNode("All Quiet on the Western Front", "WesternFront", imageUrl(basePath + "movie_9.jpg"), "new_image9"));
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
                    fxml = FXMLLoader.load(getClass().getResource("Asilbek's_Version_MoviePage.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                dashboardPane.getChildren().removeAll();
                dashboardPane.getChildren().setAll(fxml);

            }
        });
        return vBox1;
    }

    private String imageUrl(String resourcePath) {
        return Objects.requireNonNull(getClass().getResource(resourcePath)).toExternalForm();
    }
}
