package org.example;

public class Main {
    public static void main(String[] args) {
        // Запуск MessageDigestExample
        System.out.println("Running MessageDigestExample...");
        MessageDigestExample.run();
        System.out.println();

        // Запуск SecureRandomExample
        System.out.println("Running SecureRandomExample...");
        SecureRandomExample.run();
        System.out.println();

        // Запуск EqualsHashCodeExample
        System.out.println("Running EqualsHashCodeExample...");
        EqualsHashCodeExample.run();
        System.out.println();

        // Запуск SaveHashesToFile
        System.out.println("Running SaveHashesToFile...");
        SaveHashesToFile.run();
        System.out.println();
    }
}
