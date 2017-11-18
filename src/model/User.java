package model;

import java.util.ArrayList;

public class User {
    private String username;
    private int password;
    private String name;
    private UserType type;
    private ArrayList<CykelTur> cykelturliste = new ArrayList<>();
    private Team team;
//    private data.data db;


    public User(String username, int password, String name, UserType type, Team team) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.type = type;
        this.cykelturliste = new ArrayList<>();
// this.db=db;
        this.team = team;


    }

    public void addcykeltur(CykelTur cykelTur) {
        cykelturliste.add(cykelTur);

    }
    // Her laves get og set metoder for "username"

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        this.username = username;
    }

    // Her laves get og set metoder for "password"
    public int getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = password;
    }


    // Her laves get og set metoder for "name"
    public String getName() {
        return name;
    }

    public void setname() {
        this.name = name;
    }


    //
    public UserType getType() {
        return type;
    }

    public void setType() {
        this.type = type;
    }


    public Team getTeam() {
        return team;
    }

    public void setTeam() {
        this.team = team;
    }


    public ArrayList<CykelTur> getCykelturliste() {
        return cykelturliste;
    }
}



