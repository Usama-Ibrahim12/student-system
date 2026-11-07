package org.example;

public abstract class Person {
    protected final String name;

    protected Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String role();

    public String describe() {
        return name + " - " + role();

    }
}
