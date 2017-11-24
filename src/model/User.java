package model;

import data.Data;
import controllers.MemberController;


import java.util.ArrayList;

public class User {
    private String username;
    private int password;
    private String name;
    private UserType type;
    private ArrayList<CykelTur> cykelturliste = new ArrayList<>();
    private Team team;
    private int antalkørtekm;
    private int antalkørtedage;

    public User(String username, int password, String name, UserType type, Team team) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.type = type;
        this.cykelturliste = new ArrayList<>();
        this.team = team;
        this.antalkørtekm = antalkørtekm;
        this.antalkørtedage = antalkørtedage;
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

    //
    public Team getTeam() {
        return team;
    }

    public void setTeam() {
        this.team = team;
    }


    public ArrayList<CykelTur> getCykelturliste() {
        return cykelturliste;
    }

    public void cykelturDageSum() {
        int antalkørtedage = 0;
        for (CykelTur cykeltur : cykelturliste) {
            {
                antalkørtedage += cykeltur.getAntalkørtedage();

                this.antalkørtedage = antalkørtedage;
            }
        }
    }

    public int getCykelturDagesum() {
        return antalkørtedage;
    }

    public void cykelturKMSum() {
        int antalkørtekm = 0;
        for (User user : team.getUsers()) {
            {
                for (CykelTur cykelTur : user.getCykelturliste()) {
                    antalkørtekm += cykelTur.getAntalkørtekilometer();
                }
                this.antalkørtekm = antalkørtekm;
            }
        }
    }

    public int getCykelturKMSum() {
        return antalkørtekm;
    }


    public void printInfo() {
//        System.out.println("\n1)Deltager: " + currentUser.getUsername() + "\n2)Brugertype:" + currentUser.getType() +
//                "\n3)Brugerens hold: "
//                + currentUser.getTeam().getTeamID() +
//                "\n4)Brugerens indtastede kilometer: "
//                + currentUser.getCykelturliste().get(0).getAntalkørtekilometer() +
//                "\n5)Brugerens indtastede antal kørte dage: " + currentUser.getCykelturliste().get(0).getAntalkørtedage());
//    }

//    public void printInfo() {
//        System.out.println("\n1)Deltager: " + .getUsername() + "\n2)Brugertype:" + currentUser.getType() +
//                "\n3)Brugerens hold: "
//                + User.getTeam().getTeamID() +
//                "\n4)Brugerens indtastede kilometer: "
//                + currentUser.getCykelturliste().get(0).getAntalkørtekilometer() +
//                "\n5)Brugerens indtastede antal kørte dage: " + currentUser.getCykelturliste().get(0).getAntalkørtedage());
//    }
    }
}


//  returne getsum af kørte dage og kørte km
