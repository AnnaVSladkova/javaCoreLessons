package ru.geekbrains.javacore.lesson5;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main (String[]args) {
        File file = new File("test123.csv");
        writeData(file);
        readData(file);
    }

    private static void writeData(File file){
        ArrayList<User> applicants = new ArrayList<>();
        applicants.add(new User("Иван", 23, "высшее", 2));
        applicants.add(new User("Анна", 25, "высшее", 5));
        applicants.add(new User("Геннадий", 16, "среднее", 0));
        applicants.add(new User("Карл", 77, " полное высшее", 60));
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            out.write("user;age;education;experience");
            for(User applicant: applicants){
                out.newLine();
                out.write(applicant.print());
            }
            System.out.println("Data successfully saved in file " + file);
        }catch (IOException ex){
            System.out.println(ex);
        }
    }

    private static void readData(File file){
        ArrayList<User> applicants = new ArrayList<>();
        System.out.println("Try to read file " + file);
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String result = in.readLine();
            System.out.println("Header of file is '"+result+"'");
            while ((result = in.readLine()) != null) {
                User user = new User(result);
                applicants.add(user);
            }
        }catch (IOException ex){
            System.out.println(ex);
        }
        for (User applicant : applicants) {
            System.out.println(applicant.getName() + ", " + applicant.getAge() + ", " + applicant.getEducation() + ", " + applicant.getExperience());
        }
    }
}
