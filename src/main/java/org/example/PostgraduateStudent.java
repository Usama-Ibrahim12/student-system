package org.example;

public class PostgraduateStudent extends Student {
    private final String supervisor;

    public PostgraduateStudent(String id, String name, double gpa, String supervisor) {
        super(id, name, gpa);
        this.supervisor = supervisor;
    }

    public String getSupervisor() {
        return supervisor;
    }

    @Override
    public String role() {
        return "Postgraduate Student";
    }

    @Override
    public String toReportLine() {
        return super.toReportLine() + "," + supervisor;
    }
}
