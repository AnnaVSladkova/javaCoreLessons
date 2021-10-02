package ru.geekbrains.javacore.lesson9.model;

import ru.geekbrains.javacore.lesson9.Course;

public class CourseEntity implements Course {

    private String name;

    public CourseEntity(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
