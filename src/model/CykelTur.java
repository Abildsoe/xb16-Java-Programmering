package model;

import java.util.ArrayList;

import model.User;

public class CykelTur {

    private int antalkørtekilometer;
    private int antalkørtedage;
    private ArrayList<CykelTur> cykelturliste = new ArrayList<>();


    public CykelTur(int antalkørtekilometer, int antalkørtedage) {
        this.antalkørtekilometer = antalkørtekilometer;
        this.antalkørtedage = antalkørtedage;
        this.cykelturliste = new ArrayList<>();
    }


    public int getAntalkørtekilometer() {
        return antalkørtekilometer;
    }

    public void setAntalkørtekilometer(int antalkørtekilometer) {
        this.antalkørtekilometer = antalkørtekilometer;
    }


    // Her laves get og set metoder for antalkørtedage
    public int getAntalkørtedage() {
        return antalkørtedage;
    }

    public void setAntalkørtedage(int antalkørtedage) {
        this.antalkørtedage = antalkørtedage;
    }

    public ArrayList<CykelTur> getCykelturliste() {
        return cykelturliste;
    }


}