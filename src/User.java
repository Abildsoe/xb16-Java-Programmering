import java.util.ArrayList;

public class User {
    private String username;
    private int password;
    private int type;
    private String name;





    public User(String username, int password, int type, String name) {
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

   public void printInfo(){
       System.out.println("\n1)Deltager: " + currentUser.getUsername() + "\n2)Brugertype:" + currentUser.getType() +
               "\n3)Brugerens hold: "
               + currentUser.getHoldid() +
               "\n4)Brugerens indtastede kilometer: "
               + currentUser.getAntalkørtekilometer() +
               "\n5)Brugerens indtastede antal kørte dage: " + currentUser.getAntalkørtedage());
   }

}



