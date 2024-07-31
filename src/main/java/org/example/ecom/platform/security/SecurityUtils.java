package org.example.ecom.platform.security;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class SecurityUtils {

    /**
     * @param password string required for hashing
     * @param salt     additional salt string for multiple level hash
     * @return hashed string
     */
    public static String hashPassword(String password, String salt) {
        String firstHash = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        String finalHash = "";
        if (salt != null) {
            finalHash = Hashing.sha256().hashString(firstHash + salt, StandardCharsets.UTF_8).toString();
            return finalHash;
        }
        return firstHash;
    }

    /**
     * @param password       - password to be validated
     * @param username       - username for whose password is to be validated
     * @param userDbPassword - actual password
     * @return true or false depending on the validity of the password
     * @implNote Depends on hashPassword function withing the same class
     */
    public static boolean isPasswordValid(String password, String username, String userDbPassword) {
        return hashPassword(password, username).equals(userDbPassword);
    }
}
