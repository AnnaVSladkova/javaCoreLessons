package ru.geekbrains.javacore.lesson9.model;

import ru.geekbrains.javacore.lesson9.Course;
import ru.geekbrains.javacore.lesson9.Student;

import java.util.List;

public class StudentEntity implements Student {

    private String name;
    private List<Course> courses;

    public StudentEntity(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Course> getAllCourses() {
        return this.courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
