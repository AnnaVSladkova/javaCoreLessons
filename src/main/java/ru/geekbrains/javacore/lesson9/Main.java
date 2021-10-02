package ru.geekbrains.javacore.lesson9;

import ru.geekbrains.javacore.lesson9.model.CourseEntity;
import ru.geekbrains.javacore.lesson9.model.StudentEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Course c1 = new CourseEntity("Химия");
        Course c2 = new CourseEntity("Физика");
        Course c3 = new CourseEntity("Литература");
        Course c4 = new CourseEntity("Математика");
        Course c5 = new CourseEntity("Биология");

        Student s1 = new StudentEntity("Иван", Arrays.asList(c1, c2));
        Student s2 = new StudentEntity("Маша", Arrays.asList(c2));
        Student s3 = new StudentEntity("Костя", Arrays.asList(c3, c2));
        Student s4 = new StudentEntity("Аня", Arrays.asList(c5, c3, c1, c4));
        Student s5 = new StudentEntity("Дима", Arrays.asList(c2, c5, c3));
        Student s6 = new StudentEntity("Коля", Arrays.asList(c5));
        Student s7 = new StudentEntity("Вера", Arrays.asList(c1, c2, c3, c4, c5));
        List<Student> students = Arrays.asList(s1, s2, s3, s4, s5, s6, s7);

        List<Course> uniqCources = Main.getUniqCources.apply(students);
        System.out.println("unique cstudentsByCourseources=" + uniqCources);

        List<Student> top3 = Main.getTop3Students.apply(students);
        System.out.println("Top 3 of students: " + top3);

        List<Student> studentsByCourse = Main.getStudentsByCourse.apply(students, c1);
        System.out.println("Students by course: " + studentsByCourse);
    }

    private final static Function<List<Student>, List<Course>> getUniqCources = students ->{
        return students.stream()
                .map(Student::getAllCourses)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    };

    private final static Function<List<Student>, List<Student>> getTop3Students = students -> {
        return students.stream()
                .sorted((o1, o2) -> new Integer(o2.getAllCourses().size()).compareTo(o1.getAllCourses().size()))
                .limit(3)
                .collect(Collectors.toList());
    };

    private final static BiFunction<List<Student>, Course, List<Student>> getStudentsByCourse = (students, course) -> {
        return students.stream()
                .filter(stud -> stud.getAllCourses().contains(course))
                .collect(Collectors.toList());
    };
}
