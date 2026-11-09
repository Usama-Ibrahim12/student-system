package org.example;

public abstract class Person {
    protected final String name;

    protected Person(String name) {
       if (name == null || name.isBlank()) {
           throw new IllegalArgumentException("Name cannot be null or blank");
       }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public abstract String role();

    public String describe() {
        return name + " - " + role();

    }
}
