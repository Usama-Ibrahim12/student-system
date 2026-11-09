package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentRegistry {
    private static final Repository<Student> repo = new Repository<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            String choice = in.nextLine().trim();
            switch (choice) {
                case "1" -> addStudent(in);
                case "2" -> listAll();
                case "3" -> searchById(in);
                case "4" -> running = false;
                default -> System.out.println("Invalid option, choose 1-4.");
            }
        }
        System.out.println("Goodbye.");
    }

    private static void printMenu() {
        System.out.println("\n1. Add student\n2. List all\n3. Search by ID\n4. Quit");
        System.out.print("Choose: ");
    }

    private static void addStudent(Scanner in) {
        try {
            System.out.print("ID: ");
            String id = in.nextLine().trim();
            if (id.isEmpty()) {
                throw new IllegalArgumentException("ID cannot be blank");
            }
            System.out.print("Name: ");
            String name = in.nextLine();
            System.out.print("GPA (0.0-4.0): ");
            double gpa = parseGpa(in.nextLine());
            System.out.print("Postgraduate? (y/n): ");
            boolean postgrad = in.nextLine().trim().equalsIgnoreCase("y");

            Student s;
            if (postgrad) {
                System.out.print("Supervisor: ");
                s = new PostgraduateStudent(id, name, gpa, in.nextLine().trim());
            } else {
                s = new Student(id, name, gpa);
            }
            repo.add(s);
            System.out.println("Added: " + s.describe());
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }

    private static double parseGpa(String text) {
        try {
            return Double.parseDouble(text.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("GPA must be a number: " + text);
        }
    }

    private static void listAll() {
        List<Student> all = repo.findAll().stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();
        if (all.isEmpty()) {
            System.out.println("No students yet.");
            return;
        }
        all.forEach(s -> System.out.println(s.describe() + " | GPA " + s.getGpa()));
    }

    private static void searchById(Scanner in) {
        System.out.print("Enter ID: ");
        String id = in.nextLine().trim();
        repo.findAll().stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(
                        s -> System.out.println("Found: " + s.toReportLine()),
                        () -> System.out.println("No student with ID " + id));
    }
}
