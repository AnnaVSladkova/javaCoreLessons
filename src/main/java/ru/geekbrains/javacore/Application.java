package ru.geekbrains.javacore;

public class Application {

    public static void main(String[] args)
    {
        Team team = new Team("Байкеры");
        team.teamMemberInfo();

        Course course = new Course("Полоса препятствий");
        course.doIt(team);
        course.showAllResults();
        course.showCompleteResults();
    }

}
