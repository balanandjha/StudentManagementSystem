package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    // Instance variables
    private String name;
    private int age;
    private String studentId;
    private List<String> courses;
    private static final Set<String> VALID_COURSES = new HashSet<>();
    static {
        Collections.addAll(VALID_COURSES, "Java", "Python", "DSA", "Postman");
    }

    // Constructor
    public Student(String name, int age, String studentId) {
        if (!validateName(name)) {
            throw new IllegalArgumentException("Invalid Name! Please enter alphabets only.");
        }
        if (!validateAge(age)) {
            throw new IllegalArgumentException("Invalid age! Student age should be between 19 and 35.");
        }
        if (!validateId(studentId)) {
            throw new IllegalArgumentException("Invalid Id! Format should be S-<number>.");
        }
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.courses = new ArrayList<>();
    }

    public void enrollCourses(String course) {
        if (!validateCourseName(course)) {
            System.err.println(course + " course is not from the list. Please select Java, Python, DSA or Postman");
            return;
        }
        if (!courses.contains(course)) {
            courses.add(course);
            System.out.println("Student is enrolled to the course " + course + " successfully.");
        } else {
            System.err.println("Student is already enrolled to the course " + course);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId='" + studentId + '\'' +
                ", courses=" + courses +
                '}';
    }

    public void printStudentInfo() {
        System.out.println("========= Student Information ============");
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student Id: " + studentId);
        System.out.println("Enrolled for: " + courses);
    }

    // Validation Methods
    private static boolean validateAge(int age) {
        return age >= 19 && age <= 35;
    }

    private static boolean validateName(String name) {
        String nameRegex = "^[a-zA-Z\\s]+$";
        Pattern namePattern = Pattern.compile(nameRegex);
        Matcher mtch = namePattern.matcher(name);
        return mtch.matches();
    }

    private static boolean validateId(String studentId) {
        String studentIdRegEx = "S-\\d+$";
        Pattern studentIdPattern = Pattern.compile(studentIdRegEx);
        Matcher studentIdMatch = studentIdPattern.matcher(studentId);
        return studentIdMatch.matches();
    }

    private static boolean validateCourseName(String courseName) {
        return VALID_COURSES.contains(courseName);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<String> getCourses() {
        return new ArrayList<>(courses);
    }
}
