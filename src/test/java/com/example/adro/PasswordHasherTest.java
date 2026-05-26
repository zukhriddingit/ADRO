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

    @Test
    void hashesSamePasswordDifferently() {
        String first = PasswordHasher.hash("secret123");
        String second = PasswordHasher.hash("secret123");

        assertFalse(first.equals(second));
    }

    @Test
    void handlesEmptyAndSpecialCharacters() {
        String emptyHash = PasswordHasher.hash("");
        String specialHash = PasswordHasher.hash("pässw0rd!@#");

        assertTrue(PasswordHasher.matches("", emptyHash));
        assertTrue(PasswordHasher.matches("pässw0rd!@#", specialHash));
    }

    @Test
    void rejectsNonHashedValues() {
        assertFalse(PasswordHasher.isHashed(null));
        assertFalse(PasswordHasher.matches("secret123", "not-a-hash"));
    }
}
