package com.studentapp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("***************** Student Management System *************");
        System.out.println("****** Welcome *******");
        Student s1 = new Student("Balanand112344",28,"S1");

        s1.enrollCourses("Java");
        s1.enrollCourses("selenium");
        s1.enrollCourses("Postman");
        System.out.println(s1);
      //  s1.printStudentInfo();




    }
}