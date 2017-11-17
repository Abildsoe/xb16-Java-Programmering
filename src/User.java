import java.util.ArrayList;

public class User {
    private String username;
    private int password;
    private String name;
    private int type;
    private ArrayList<CykelTur>cykelturliste=new ArrayList<>();
//    private Data db;



    public User(String username, int password, String name, int type) {
        this.username = username;
        this.password = password;
        this.name=name;
        this.type=type;
        this.cykelturliste=new ArrayList<>();
// this.db=db;



    }
    public void addcykeltur(CykelTur cykelTur){
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
    public String getName(){return name;}
    public void setname(){this.name=name;}


//
    public int getType(){return type;}
    public void setType(){this.type=type;}





    public ArrayList<CykelTur> getCykelturliste() {
        return cykelturliste;
    }
}



