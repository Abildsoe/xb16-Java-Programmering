package model;

import data.Data;

import java.util.ArrayList;

import model.Cycleweek;

public class User {
    private String username;
    private int password;
    private String name;
    private UserType type;
    private ArrayList<Cycleweek> cycleweeklist = new ArrayList<>();
    private Team team;


    public User(String username, int password, String name, UserType type) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.type = type;
        this.cycleweeklist = new ArrayList<>();
        this.team = team;
    }

    public void addcycleweek(Cycleweek cycleweek) {
        cycleweeklist.add(cycleweek);
    }

    // Her laves get og set metoder for "username"
    public String getUsername() {
        return username;
    }


    // Her laves get metoder for "password"
    public int getPassword() {
        return password;
    }


    // Her laves get og set metoder for "name"
    public String getName() {
        return name;
    }


    // Her oprettes Get metode for "type"
    public UserType getType() {
        return type;
    }


    // Her oprettes en get metode
    public Team getTeam() {
        return team;
    }


    // Her oprettes get for "Cykelturliste"
    public ArrayList<Cycleweek> getCycleweeklist() {
        return cycleweeklist;
    }


    public int getTotalDistance() {

        int totalDistance = 0;


        for (Cycleweek cycleweek : cycleweeklist) {

            totalDistance += cycleweek.getKilometersdriven();

        }
        return totalDistance;
    }

    public int getTotalDays() {

        int totalDays = 0;


        for (Cycleweek cycleweek : cycleweeklist) {

            totalDays += cycleweek.getDaysdriven();

        }
        return totalDays;
    }
}


