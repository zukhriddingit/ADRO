package com.example.adro;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class UserRepository {
    public boolean usernameExists(String username, UserTable table) throws SQLException {
        try (Connection connection = DataBaseConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(usernameExistsSql(table))) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    public Optional<String> findPassword(String username, UserTable table) throws SQLException {
        try (Connection connection = DataBaseConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(passwordLookupSql(table))) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.ofNullable(resultSet.getString("password"));
                }
                return Optional.empty();
            }
        }
    }

    public void createUser(String fullname, String email, String phone, String username, String passwordHash, LocalDate dateOfBirth)
            throws SQLException {
        String sql = "INSERT INTO register (fullname, email, phone, username, password, dateOfBirth) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DataBaseConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, fullname);
            statement.setString(2, email);
            statement.setString(3, phone);
            statement.setString(4, username);
            statement.setString(5, passwordHash);
            if (dateOfBirth == null) {
                statement.setNull(6, java.sql.Types.DATE);
            } else {
                statement.setDate(6, Date.valueOf(dateOfBirth));
            }
            statement.executeUpdate();
        }
    }

    private String usernameExistsSql(UserTable table) {
        return switch (table) {
            case REGISTER -> "SELECT 1 FROM register WHERE username = ?";
            case ADMIN -> "SELECT 1 FROM admin WHERE username = ?";
        };
    }

    private String passwordLookupSql(UserTable table) {
        return switch (table) {
            case REGISTER -> "SELECT password FROM register WHERE username = ?";
            case ADMIN -> "SELECT password FROM admin WHERE username = ?";
        };
    }
}
