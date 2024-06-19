package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class SaveHashesToFile {
    public static void run() {
        StringBuilder sb = new StringBuilder();
        String input = "example";
        try {
            // MD5
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            byte[] md5Hash = md5Digest.digest(input.getBytes());
            sb.append("MD5 Hash: ").append(Arrays.toString(md5Hash)).append("\n");

            // SHA-1
            MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");
            byte[] sha1Hash = sha1Digest.digest(input.getBytes());
            sb.append("SHA-1 Hash: ").append(Arrays.toString(sha1Hash)).append("\n");

            // SHA-256
            MessageDigest sha256Digest = MessageDigest.getInstance("SHA-256");
            byte[] sha256Hash = sha256Digest.digest(input.getBytes());
            sb.append("SHA-256 Hash: ").append(Arrays.toString(sha256Hash)).append("\n");

            byte[] randomBytes = new byte[16];

            // SHA1PRNG
            SecureRandom sha1prng = SecureRandom.getInstance("SHA1PRNG");
            sha1prng.nextBytes(randomBytes);
            sb.append("SHA1PRNG Random: ").append(Arrays.toString(randomBytes)).append("\n");

            // Windows-PRNG (if available on your system)
            try {
                SecureRandom windowsPrng = SecureRandom.getInstance("Windows-PRNG");
                windowsPrng.nextBytes(randomBytes);
                sb.append("Windows-PRNG Random: ").append(Arrays.toString(randomBytes)).append("\n");
            } catch (NoSuchAlgorithmException e) {
                sb.append("Windows-PRNG is not available on this system.\n");
            }

            // DRBG
            try {
                SecureRandom drbg = SecureRandom.getInstance("DRBG");
                drbg.nextBytes(randomBytes);
                sb.append("DRBG Random: ").append(Arrays.toString(randomBytes)).append("\n");
            } catch (NoSuchAlgorithmException e) {
                sb.append("DRBG is not available on this system.\n");
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("hashes.txt")) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
