import java.util.ArrayList;

public class User {
    private String username;
    private int password;
    private String name;
private ArrayList<CykelTur>cykelturliste=new ArrayList<>();
    ArrayList<Teams> teams = new ArrayList<>();
    Data db;



    public User(String username, int password, String name) {
        this.username = username;
        this.password = password;
        this.name=name;
        this.cykelturliste=new ArrayList<>();

    }

    public void addCykelture(CykelTur cykeltur) {
        cykelturliste.add(cykeltur);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        this.username = username;
    }


    public int getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = password;
    }


    // Her laves get og set metoder for "name"
    public String getName(){return name;}
    public void setname(){this.name=name;}








    public ArrayList<Teams> getTeams() { return teams; }




}



