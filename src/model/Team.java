package model;

import java.util.ArrayList;

public class Team {

    private ArrayList<User> users = new ArrayList<>();
    private int teamID;
    private String teamName;
    private String teamLeader;


    public Team(int teamID, String teamName, String teamLeader) {

        this.teamID = teamID;
        this.teamName = teamName;
        this.teamLeader = teamLeader;
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);

    }

    //Her laves get og set metoder for "teamid"
    public int getTeamID() {
        return teamID;
    }



    // Her laves get og set metoder for "teamname"
    public String getTeamName() {
        return teamName;
    }



    // Her laves get og set metoder for "teamleader"
    public String getTeamLeader() {
        return teamLeader;
    }



    public ArrayList<User> getUsers() {
        return users;
    }

}

