package model;

import data.Data;

import java.util.ArrayList;

public class Cycleweek {

    private int kilometersdriven;
    private int weeknumber;
    private int daysdriven;
    private ArrayList<Cycleweek> cycleweeklist = new ArrayList<>();



    public Cycleweek(int kilometersdriven, int weeknumber, int daysdriven) {
        this.kilometersdriven = kilometersdriven;
        this.weeknumber = weeknumber;
        this.daysdriven = daysdriven;
        this.cycleweeklist = new ArrayList<>();
    }


    // Her laves get og set metoder for kilometersdriven
    public int getKilometersdriven() {
        return kilometersdriven;
    }

    public void setKilometersdriven(int kilometersdriven) {
        this.kilometersdriven = kilometersdriven;
    }


    // Her laves get og set metoder for weeknumber
    public int getWeeknumber() {
        return weeknumber;
    }

    public void setWeeknumber(int weeknumber) {
        this.weeknumber = weeknumber;
    }


    // Her oprettes get og set metoder for "daysdriven"
    public int getDaysdriven() {
        return daysdriven;
    }

    public void setDaysdriven(int daysdriven) {
        this.daysdriven = daysdriven;
    }

    public ArrayList<Cycleweek> getCykelugeliste() {
        return cycleweeklist;
    }

}






