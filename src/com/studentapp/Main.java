package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static List<Student> studentList;

    public static void main(String[] args) {
        System.out.println("***************** Student Management System *************");
        System.out.println("****** Welcome *******");
        studentList = new ArrayList<>();
        Student s1 = new Student("Balanand", 28, "S-1");
        s1.enrollCourses("Java");
        s1.enrollCourses("selenium"); // Will print error for invalid course
        s1.enrollCourses("Postman");
        s1.enrollCourses("Postman"); // Will print error for duplicate

        Student s2 = new Student("Sonal", 24, "S-2");
        s2.enrollCourses("Java");
        s2.enrollCourses("DSA");
        s2.enrollCourses("Python");

        Student s3 = new Student("Mukund", 19, "S-3");
        s3.enrollCourses("Java");
        s3.enrollCourses("DSA");
        s3.enrollCourses("Python");
        s3.enrollCourses("Javascript"); // Will print error for invalid course

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        sortByName();
        System.out.println("\n--- All Students ---");
        for (Student s : studentList) {
            s.printStudentInfo();
        }
        Student result = getStudentById("S-3");
        if (result != null) {
            System.out.println("\n--- Search Result ---");
            result.printStudentInfo();
        }
    }

    public static Student getStudentById(String studentId) {
        try {
            return studentList.stream()
                    .filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No Data found!"));
        } catch (RuntimeException e) {
            System.err.println("Student with ID " + studentId + " not found!");
            return null;
        }
    }

    private static void sortByName() {
        studentList.sort(Comparator.comparing(Student::getName));
    }
}