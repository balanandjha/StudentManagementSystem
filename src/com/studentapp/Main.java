package com.studentapp;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static List<Student> studentList;

    public static void main(String[] args) {

        System.out.println("***************** Student Management System *************");
        System.out.println("****** Welcome *******");
        studentList = new ArrayList<Student>();
        Student s1;
        s1 = new Student("Balanand", 28, "S-1");
        s1.enrollCourses("Java");
        s1.enrollCourses("selenium");
        s1.enrollCourses("Postman");
        s1.enrollCourses("Postman");

        Student s2;
        s2 = new Student("Sonal", 24, "S-2");


        s2.enrollCourses("Java");
        s2.enrollCourses("DSA");
        s2.enrollCourses("Python");

        // System.out.println(s1);
        // s1.printStudentInfo();
        // s2.printStudentInfo();

        studentList.add(s1);
        studentList.add(s2);
        //  System.out.println(studentList.getFirst());


        Student result = getStudentbyId("S-2");
        System.out.println("Result " + result);

    }

    public static Student getStudentbyId(String studentId) {
        Student result = null;
        try {
            result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
                    .orElseThrow(() -> new RuntimeException("No Data found!!!!"));
        } catch (RuntimeException e) {
            System.err.println("Student with ID " + studentId + " not found!!");
        }
        return result;
    }
}