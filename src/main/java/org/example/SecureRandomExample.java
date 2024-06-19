package org.example;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class SecureRandomExample {
    public static void run() {
        try {
            byte[] randomBytes = new byte[16];

            // SHA1PRNG
            SecureRandom sha1prng = SecureRandom.getInstance("SHA1PRNG");
            sha1prng.nextBytes(randomBytes);
            System.out.println("SHA1PRNG Random: " + Arrays.toString(randomBytes));

            // Windows-PRNG (if available on your system)
            try {
                SecureRandom windowsPrng = SecureRandom.getInstance("Windows-PRNG");
                windowsPrng.nextBytes(randomBytes);
                System.out.println("Windows-PRNG Random: " + Arrays.toString(randomBytes));
            } catch (NoSuchAlgorithmException e) {
                System.out.println("Windows-PRNG is not available on this system.");
            }

            // DRBG
            try {
                SecureRandom drbg = SecureRandom.getInstance("DRBG");
                drbg.nextBytes(randomBytes);
                System.out.println("DRBG Random: " + Arrays.toString(randomBytes));
            } catch (NoSuchAlgorithmException e) {
                System.out.println("DRBG is not available on this system.");
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
