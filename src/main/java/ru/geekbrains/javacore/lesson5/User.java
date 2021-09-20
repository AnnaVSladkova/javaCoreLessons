package ru.geekbrains.javacore.lesson5;

public class User {
    private final String name;
    private final Integer age;
    private final String education;
    private final Integer experience;

    public User(String name, Integer age, String education, Integer experience) {
        this.name = name;
        this.age = age;
        this.education = education;
        this.experience = experience;
    }

    public User(String text) {
        String[] fields = text.split(";");
        this.name = fields[0];
        this.age = Integer.parseInt(fields[1]);
        this.education = fields[2];
        this.experience = Integer.parseInt(fields[3]);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEducation() {
        return education;
    }

    public Integer getExperience() {
        return experience;
    }

    public String print() {
        return String.format("%s;%d;%s;%d", this.name, this.age, this.education, this.experience);
    }
}