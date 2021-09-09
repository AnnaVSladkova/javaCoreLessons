package ru.geekbrains.javacore;

public class Team {
    public String teamName;
    public TeamMember[] teamMembers;

     public Team(String teamName) {
        this.teamName = teamName;
        this.teamMembers = new TeamMember[4];
        this.teamMembers[0] = new TeamMember("Павел Евсеев", 25);
        this.teamMembers[1] = new TeamMember("Александр Сидоров", 28);
        this.teamMembers[2] = new TeamMember("Сергей Борщёв", 34);
        this.teamMembers[3] = new TeamMember("Агафон Дмитриев", 32);
    }

    public void teamMemberInfo() {
        System.out.println("Состав команды '" + this.teamName + "':");
        for(TeamMember teamMember: teamMembers) {
            System.out.println("Участник команды " + teamMember.name + ", возраст " + teamMember.age);
        }
    }
}


