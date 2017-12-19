package model;

import java.util.ArrayList;

public class User {
    private String username;
    private int password;
    private String name;
    private UserType type;
    private ArrayList<Cycleweek> cycleweeklist;


    public User(String username, int password, String name, UserType type) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.type = type;
        this.cycleweeklist = new ArrayList<>();
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


    // Her oprettes get for "Cykelturliste"
    public ArrayList<Cycleweek> getCycleweeklist() {
        return cycleweeklist;
    }


    //Her opretter vi vores metode som skal kunne hente total antal kørte dage for en users cykeluge array

    public double getTotalDistance() {

        double totalDistance = 0;

        //itterer igennem cycleweek arrayet

        for (Cycleweek cycleweek : cycleweeklist) {

            //når vi får fat på data'en i arrayet beder vi programmet lægge det sammen med vores variable 'totalday', hvilket betyder at vi får det totale resultat
            totalDistance += cycleweek.getKilometersdriven();

        }
        return totalDistance;
    }

    //Det samme gælder denne metode som 'getTotalDistance', dog er vores variable her en int, da dage ikke kan være halve, så det skal være heltal
    public int getTotalDays() {

        int totalDays = 0;

        for (Cycleweek cycleweek : cycleweeklist) {

            totalDays += cycleweek.getDaysdriven();

        }
        return totalDays;
    }
}


