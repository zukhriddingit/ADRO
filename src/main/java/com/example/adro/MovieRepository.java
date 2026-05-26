package com.example.adro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    public void addMovie(AdminMovie movie) throws SQLException {
        String sql = "INSERT INTO movies (title, description, genre, language, duration, number_tickets, session, start_date, end_date, price) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DataBaseConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getDescription());
            statement.setString(3, movie.getGenre());
            statement.setString(4, movie.getLanguage());
            statement.setInt(5, movie.getDuration());
            statement.setInt(6, movie.getNumberTickets());
            statement.setString(7, movie.getSession());
            if (movie.getStartDate() == null) {
                statement.setNull(8, Types.DATE);
            } else {
                statement.setDate(8, movie.getStartDate());
            }
            if (movie.getEndDate() == null) {
                statement.setNull(9, Types.DATE);
            } else {
                statement.setDate(9, movie.getEndDate());
            }
            statement.setInt(10, movie.getPrice());
            statement.executeUpdate();
        }
    }

    public List<AdminMovie> fetchMovies() throws SQLException {
        String sql = "SELECT * FROM movies";
        List<AdminMovie> movies = new ArrayList<>();
        try (Connection connection = DataBaseConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                movies.add(new AdminMovie(
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("genre"),
                        resultSet.getString("language"),
                        resultSet.getInt("duration"),
                        resultSet.getInt("number_tickets"),
                        resultSet.getString("session"),
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date"),
                        resultSet.getInt("price")
                ));
            }
        }
        return movies;
    }
}
