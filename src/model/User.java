package model;


import java.util.ArrayList;

public class User {
    private String username;
    private int password;
    private String name;
    private UserType type;
    private ArrayList<Cycleweek> cycleweeklist  = new ArrayList<>();
    private Team team;


    public User(String username, int password, String name, UserType type) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.type = type;
        this.cycleweeklist  = new ArrayList<>();
        this.team=team;

    }

    public void addcycleweek(Cycleweek cycleweek) { cycleweeklist.add(cycleweek); }

    // Her laves get og set metoder for "username"
    public String getUsername() {
        return username;
    }


    // Her laves get metoder for "password"
    public int getPassword() { return password; }




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

    public void printInfo() {
//        System.out.println("\n1)Deltager: " + currentUser.getUsername() + "\n2)Brugertype:" + currentUser.getType() +
//                "\n3)Brugerens hold: "
//                + currentUser.getTeam().getTeamID() +
//                "\n4)Brugerens indtastede kilometer: "
//                + currentUser.getCykelturliste().get(0).getKilometersdriven() +
//                "\n5)Brugerens indtastede antal kørte dage: " + currentUser.getCykelturliste().get(0).getAntalkørtedage());
//    }

//    public void printInfo() {
//        System.out.println("\n1)Deltager: " + .getUsername() + "\n2)Brugertype:" + currentUser.getType() +
//                "\n3)Brugerens hold: "
//                + User.getTeam().getTeamID() +
//                "\n4)Brugerens indtastede kilometer: "
//                + currentUser.getCykelturliste().get(0).getKilometersdriven() +
//                "\n5)Brugerens indtastede antal kørte dage: " + currentUser.getCykelturliste().get(0).getAntalkørtedage());
//    }
    }
}