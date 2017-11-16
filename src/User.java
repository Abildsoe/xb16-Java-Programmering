import java.util.ArrayList;

public class User {
    private String username;
    private int password;
    private int type;
    private String name;

    ArrayList<Teams> teams = new ArrayList<>();
    Data db;


    public User(String username, int password, int type, String name, String holdid, int antalkørtekilometer, int antalkørtedage) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.name=name;

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


    public int getType() {
        return type;
    }

    public void setType() {
        this.type = type;
    }

    // Her laves get og set metoder for "name"
    public String getName(){return name;}
    public void setname(){this.name=name;}








    public ArrayList<Teams> getTeams() { return teams; }




}



