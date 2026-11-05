package org.example;

public class Student extends Person implements Reportable {
    private final String id;
    private double gpa;

    public Student(String id, String name, double gpa) {
        super(name);
        this.id = id;
        setGpa(gpa);
    }

    public String getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0: " + gpa);
        }
        this.gpa = gpa;
    }

    @Override
    public String role() {
        return "Student";
    }

    @Override
    public String toReportLine() {
        return id + "," + name + "," + gpa;
    }
}