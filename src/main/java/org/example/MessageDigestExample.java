package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestExample {
    public static void run() {
        try {
            String input = "example";

            // MD5
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            byte[] md5Hash = md5Digest.digest(input.getBytes());
            System.out.println("MD5 Hash: " + bytesToHex(md5Hash));

            // SHA-1
            MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");
            byte[] sha1Hash = sha1Digest.digest(input.getBytes());
            System.out.println("SHA-1 Hash: " + bytesToHex(sha1Hash));

            // SHA-256
            MessageDigest sha256Digest = MessageDigest.getInstance("SHA-256");
            byte[] sha256Hash = sha256Digest.digest(input.getBytes());
            System.out.println("SHA-256 Hash: " + bytesToHex(sha256Hash));

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
