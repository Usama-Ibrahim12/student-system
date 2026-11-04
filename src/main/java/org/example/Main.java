package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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

       //GPAs to classify
        double[] gpas = {3.9,3.2,2.8,3.6,1.9};

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







