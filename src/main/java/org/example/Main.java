package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {

    public static double average(double[] scores)
    {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }

    public static void main(String[] args) {
       //primitive types
       byte b = 10;
       short s = 200;
       int i = 30000;
       long l = 9_000_000_000L;
       float f = 3.5f;
       double d = 3.75;
       char grade = 'A';
       boolean passed = true;

       System.out.println("byte:"+b);
       System.out.println("short:"+s);
       System.out.println("int:"+i);
       System.out.println("long:"+l);
       System.out.println("float:"+f);
       System.out.println("double:"+d);
       System.out.println("char:"+grade);
       System.out.println("boolean:"+passed);

       //GPAs to classify
        double[] gpas = {3.9,3.2,2.8,3.6,1.9};


        System.out.printf("Average GPA:%.2f%n",average(gpas));


        // Step 5: generic repository
        Repository<Student> studentRepo = new Repository<>();
        studentRepo.add(new Student("S001", "Usama", 3.9));
        studentRepo.add(new Student("S002", "Ali", 3.2));
        studentRepo.add(new Student("S003", "Mohamed", 3.6));
        studentRepo.add(new Student("S004", "Mahir", 2.8));

        System.out.println("Stored students: " + studentRepo.size());

        // Step 6: streams
        List<Student> all = studentRepo.findAll();

        System.out.println("--- Sorted by name ---");
        all.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(st -> System.out.println(st.describe()));

        System.out.println("--- Dean's list (GPA >= 3.5) ---");
        List<String> deansList = all.stream()
                .filter(st -> st.getGpa() >= 3.5)
                .sorted(Comparator.comparing(Student::getName))
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(deansList);


        Course cs101 = new Course("CS101", 1);
        Student first = all.get(0);
        Student second = all.get(1);

        try {
            enrol(first, cs101);
            System.out.println("Enrolled " + first.getName());
            enrol(second, cs101);
            System.out.println("Enrolled " + second.getName());
        } catch (EnrolmentException e) {
            System.out.println("Could not enrol: " + e.getMessage());
        } finally {
            System.out.println("Enrolment attempt complete");
        }

// Index by ID
        Map<String, Student> byId = new HashMap<>();
        for (Student st : studentRepo.findAll()) {
            byId.put(st.getId(), st);
        }

        Student found = byId.get("S001");
        System.out.println("Lookup S001: " + found.describe());
        System.out.println(found.toReportLine());


        for (double gpa : gpas) {
            if (gpa >= 3.5) {
                System.out.println(gpa + " -> First Class");
            } else if (gpa >= 3.0) {
                System.out.println(gpa + " -> Second Upper");
            } else if (gpa >= 2.0) {
                System.out.println(gpa + " -> Second Lower");
            } else {
                System.out.println(gpa + " -> Pass/Fail");
            }
        }
    }
    public static void enrol(Student s, Course c) throws EnrolmentException {
        if (c.isFull()) {
            throw new EnrolmentException(c.getTitle() + " is full");
        }
        c.add(s);
    }
}







