public class CykelTur {

    private int antalkørtekilometer;
    private int antalkørtedage;

    public CykelTur(int antalkørtekilometer, int antalkørtedage) {
        this.antalkørtekilometer = antalkørtekilometer;
        this.antalkørtedage = antalkørtedage;

    }
    public int getAntalkørtekilometer() {
        return antalkørtekilometer;
    }

    public void setAntalkørtekilometer(int antalkørtekilometer) {
        this.antalkørtekilometer = antalkørtekilometer;
    }



    public int getAntalkørtedage() {
        return antalkørtedage;
    }

    public void setAntalkørtedage(int antalkørtedage) {
        this.antalkørtedage = antalkørtedage;
    }
}