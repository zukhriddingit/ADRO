package com.example.adro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    public List<Movie> fetchCartMovies() throws SQLException {
        String sql = "SELECT * FROM cart";
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = DataBaseConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                movies.add(new Movie(
                        resultSet.getString("Movie_name"),
                        resultSet.getString("Movie_theatre"),
                        resultSet.getString("Movie_id"),
                        resultSet.getString("Language"),
                        resultSet.getDate("Movie_time"),
                        resultSet.getInt("Tickets_num"),
                        resultSet.getString("Price")
                ));
            }
        }
        return movies;
    }
}
