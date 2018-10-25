package com.bheemapps.cvvalidator.utilityapp;

public class Student {

    private String name;
    private int age;

    private static Student student;

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Student getInstance() {
        if (student == null) {
            student = new Student("Shyam", 20);
        }
        return student;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
