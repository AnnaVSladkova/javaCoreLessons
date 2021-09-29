package ru.geekbrains.javacore;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Course {

   private String name;
   public String[] course;

   public Map<TeamMember, Integer> results = new HashMap<>();

   public Course(String name) {
       this.name = name;
       this.course = new String[4];
       this.course[0]  = "Овраг";
       this.course[1]  = "Коряги";
       this.course[2]  = "Ручей";
       this.course[3]  = "Финиш";
   }
    public void doIt(Team team){
        Random rnd = new Random();
        results.clear();
        for(TeamMember teamMember: team.teamMembers){
            this.results.put(teamMember, rnd.nextInt(this.course.length));
        }
    }

    public void showAllResults(){
        System.out.println("");
        System.out.println("Общая таблица результатов в соревновании '" + this.name + "':");
        for(Map.Entry<TeamMember, Integer> result: results.entrySet()){
            System.out.println(result.getKey().name + ": " + result.getValue() + " (" +this.course[result.getValue()] + ")");
        }
    }

    public void showCompleteResults(){
        System.out.println("");
        System.out.println("Список участников, прошедших соревнование:");
        for(Map.Entry<TeamMember, Integer> result: results.entrySet()){
            if(result.getValue()==this.course.length-1) {
                System.out.println(result.getKey().name);
            }
        }
    }
}
