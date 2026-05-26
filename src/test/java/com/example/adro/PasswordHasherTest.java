package com.example.adro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordHasherTest {
    @Test
    void hashesAndVerifiesPassword() {
        String hash = PasswordHasher.hash("secret123");

        assertTrue(PasswordHasher.isHashed(hash));
        assertTrue(PasswordHasher.matches("secret123", hash));
        assertFalse(PasswordHasher.matches("wrong", hash));
    }
}
