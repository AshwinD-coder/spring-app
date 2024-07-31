package org.example.ecom.platform.helper;

public class HelperUtils {
    public static boolean isBlankOrNull(String str) {
        if (str == null)
            return true;
        return str.isEmpty() || str.isBlank();
    }
}
