package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        Student s3;
        s3 = new Student("Mukund", 19, "S-3");


        s3.enrollCourses("Java");
        s3.enrollCourses("DSA");
        s3.enrollCourses("Python");
        s3.enrollCourses("Javascript");

        // System.out.println(s1);
        // s1.printStudentInfo();
        // s2.printStudentInfo();

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        sortByName();
        //  System.out.println(studentList.getFirst());


        Student result = getStudentbyId("S-3");
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
    private static  void sortByName() {
        Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
                /*new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        */

        Collections.sort(studentList,studentNameComparator);
        System.out.println(studentList);
    }
}