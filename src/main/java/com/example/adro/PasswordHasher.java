package com.example.adro;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public final class PasswordHasher {
    private static final String PREFIX = "pbkdf2";
    private static final String DELIMITER = "$";
    private static final int ITERATIONS = 65536;
    private static final int SALT_LENGTH = 16;
    private static final int KEY_LENGTH = 256;

    private PasswordHasher() {
    }

    public static String hash(String password) {
        byte[] salt = new byte[SALT_LENGTH];
        new SecureRandom().nextBytes(salt);
        byte[] hash = pbkdf2(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        return PREFIX + DELIMITER + ITERATIONS + DELIMITER
                + Base64.getEncoder().encodeToString(salt) + DELIMITER
                + Base64.getEncoder().encodeToString(hash);
    }

    public static boolean matches(String password, String storedValue) {
        if (storedValue == null || !storedValue.startsWith(PREFIX + DELIMITER)) {
            return false;
        }
        String[] parts = storedValue.split("\\$");
        if (parts.length != 4) {
            return false;
        }
        try {
            int iterations = Integer.parseInt(parts[1]);
            byte[] salt = Base64.getDecoder().decode(parts[2]);
            byte[] expectedHash = Base64.getDecoder().decode(parts[3]);
            byte[] actualHash = pbkdf2(password.toCharArray(), salt, iterations, expectedHash.length * 8);
            return MessageDigest.isEqual(expectedHash, actualHash);
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public static boolean isHashed(String storedValue) {
        return storedValue != null && storedValue.startsWith(PREFIX + DELIMITER);
    }

    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int keyLength) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            return factory.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException | java.security.NoSuchAlgorithmException ex) {
            throw new IllegalStateException("Password hashing failed using PBKDF2WithHmacSHA256", ex);
        } finally {
            spec.clearPassword();
        }
    }
}
