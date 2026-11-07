package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

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
}







