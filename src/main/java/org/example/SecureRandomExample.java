package org.example;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecureRandomExample {
    public static void run() {
        try {
            byte[] randomBytes = new byte[16];

            // SHA1PRNG
            SecureRandom sha1prng = SecureRandom.getInstance("SHA1PRNG");
            sha1prng.nextBytes(randomBytes);
            System.out.println("SHA1PRNG Random: " + bytesToHex(randomBytes));

            // Windows-PRNG (if available on your system)
            try {
                SecureRandom windowsPrng = SecureRandom.getInstance("Windows-PRNG");
                windowsPrng.nextBytes(randomBytes);
                System.out.println("Windows-PRNG Random: " + bytesToHex(randomBytes));
            } catch (NoSuchAlgorithmException e) {
                System.out.println("Windows-PRNG is not available on this system.");
            }

            // DRBG
            try {
                SecureRandom drbg = SecureRandom.getInstance("DRBG");
                drbg.nextBytes(randomBytes);
                System.out.println("DRBG Random: " + bytesToHex(randomBytes));
            } catch (NoSuchAlgorithmException e) {
                System.out.println("DRBG is not available on this system.");
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Метод для конвертації байтів у шістнадцятковий рядок
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
