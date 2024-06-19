package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MessageDigestExample {
    public static void run() {
        try {
            String input = "example";

            // MD5
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            byte[] md5Hash = md5Digest.digest(input.getBytes());
            System.out.println("MD5 Hash: " + Arrays.toString(md5Hash));

            // SHA-1
            MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");
            byte[] sha1Hash = sha1Digest.digest(input.getBytes());
            System.out.println("SHA-1 Hash: " + Arrays.toString(sha1Hash));

            // SHA-256
            MessageDigest sha256Digest = MessageDigest.getInstance("SHA-256");
            byte[] sha256Hash = sha256Digest.digest(input.getBytes());
            System.out.println("SHA-256 Hash: " + Arrays.toString(sha256Hash));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
