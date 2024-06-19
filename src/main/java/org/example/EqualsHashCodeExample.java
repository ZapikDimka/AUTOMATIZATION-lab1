package org.example;

import java.util.HashMap;

public class EqualsHashCodeExample {
    public static void run() {
        // CorrectClass HashMap
        HashMap<CorrectClass, String> correctMap = new HashMap<>();
        correctMap.put(new CorrectClass(1, "Alice"), "Alice Data");
        correctMap.put(new CorrectClass(2, "Bob"), "Bob Data");

        System.out.println("CorrectClass Map: " + correctMap);

        // Attempt to retrieve data
        String aliceDataCorrect = correctMap.get(new CorrectClass(1, "Alice"));
        String bobDataCorrect = correctMap.get(new CorrectClass(2, "Bob"));
        System.out.println("Retrieve Alice (CorrectClass): " + aliceDataCorrect);
        System.out.println("Retrieve Bob (CorrectClass): " + bobDataCorrect);

        // IncorrectClass HashMap
        HashMap<IncorrectClass, String> incorrectMap = new HashMap<>();
        incorrectMap.put(new IncorrectClass(1, "Alice"), "Alice Data");
        incorrectMap.put(new IncorrectClass(2, "Bob"), "Bob Data");

        System.out.println("IncorrectClass Map: " + incorrectMap);

        // Attempt to retrieve data
        String aliceDataIncorrect = incorrectMap.get(new IncorrectClass(1, "Alice"));
        String bobDataIncorrect = incorrectMap.get(new IncorrectClass(2, "Bob"));
        System.out.println("Retrieve Alice (IncorrectClass): " + aliceDataIncorrect);
        System.out.println("Retrieve Bob (IncorrectClass): " + bobDataIncorrect);

        // Adding more entries to IncorrectClass map
        incorrectMap.put(new IncorrectClass(1, "Charlie"), "Charlie Data");
        incorrectMap.put(new IncorrectClass(1, "Alice"), "Updated Alice Data");

        System.out.println("IncorrectClass Map after additional entries: " + incorrectMap);
    }

    public static void main(String[] args) {
        run();
    }
}

class CorrectClass {
    private int id;
    private String name;

    public CorrectClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorrectClass that = (CorrectClass) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return 31 * id + name.hashCode();
    }

    @Override
    public String toString() {
        return "CorrectClass{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}

class IncorrectClass {
    private int id;
    private String name;

    public IncorrectClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return id; // not considering name
    }

    @Override
    public String toString() {
        return "IncorrectClass{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
