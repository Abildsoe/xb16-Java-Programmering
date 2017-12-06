package model;

import java.util.ArrayList;

public class Cycleweek {

    private double kilometersdriven;
    private int weeknumber;
    private int daysdriven;


    public Cycleweek(double kilometersdriven, int weeknumber, int daysdriven) {
        this.kilometersdriven = kilometersdriven;
        this.weeknumber = weeknumber;
        this.daysdriven = daysdriven;
    }


    // Her laves get og set metoder for kilometersdriven
    public double getKilometersdriven() {
        return kilometersdriven;
    }

    public void setKilometersdriven(double kilometersdriven) {
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
}