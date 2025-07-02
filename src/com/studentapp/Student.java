package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    //Instance variable
    private  String name;
    private int age;
    private String studentId;
    private List<String> courses;

    //Constructor

    public Student(String name, int age, String studentId) {
        if(validateAge(age) && validateName(name) && validateId(studentId)) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;
            courses = new ArrayList<String>(); // Initialization of courses
        }

    }
    public void enrollCourses(String course) {
        courses.add(course);
        System.out.println("Student is enrolled to the course successfully.");
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
        System.out.println("Student Name: "+name);
        System.out.println("Student Age: "+age);
        System.out.println("Student Id: "+studentId);
        System.out.println("Enrolled for: "+courses);
    }

    //Validation Methods
    public boolean validateAge(int age) {
        if(age>=19 && age<=35) {
            return true;
        } else {
            System.err.println("Invalid age!!!! Student age should be between 19 and 35");
            return false;
        }
    }

    public boolean validateName(String name) {
        String nameRegex = "^[a-zA-Z\\s]+$";
       Pattern namePattern =  Pattern.compile(nameRegex);
      Matcher mtch = namePattern.matcher(name);
      if(mtch.matches()){
          return true;
      } else{
          System.err.println("Invalid Name !!!!! please enter alphabets on");
          return  false;
      }
    }

    public boolean validateId(String studentId){
        String studentIdRegEx = "S-\\d+$";
        Pattern studentIdPattern = Pattern.compile(studentIdRegEx);
        Matcher studentIdMatch = studentIdPattern.matcher(studentId);
        if(studentIdMatch.matches()) {
            return true;
        } else {
            System.err.println("Invalid Id");
            return  false;
        }
    }
}
