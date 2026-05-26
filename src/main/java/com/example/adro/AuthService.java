package com.example.adro;

import java.sql.SQLException;
import java.util.Optional;

public class AuthService {
    private final UserRepository userRepository = new UserRepository();

    public boolean authenticate(String username, String password, UserTable table) throws SQLException {
        Optional<String> storedPassword = userRepository.findPassword(username, table);
        if (storedPassword.isEmpty()) {
            return false;
        }
        String storedValue = storedPassword.get();
        if (PasswordHasher.isHashed(storedValue)) {
            return PasswordHasher.matches(password, storedValue);
        }
        return storedValue.equals(password);
    }
}
