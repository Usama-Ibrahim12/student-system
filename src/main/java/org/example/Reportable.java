package org.example;

public interface Reportable {
    String toReportLine();

    default String header() {
        return "=== Student Report ===";
    }
}