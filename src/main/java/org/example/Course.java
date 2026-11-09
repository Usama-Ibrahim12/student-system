package org.example;

public class Course {
    private final String title;
    private final int capacity;
    private int enrolled = 0;

    public Course(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
    }

    public String getTitle() {
        return title;
    }

    public boolean isFull() {
        return enrolled >= capacity;
    }

    public void add(Student s) {
        enrolled++;
    }
}
