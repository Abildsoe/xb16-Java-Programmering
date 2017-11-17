import java.util.ArrayList;
import java.util.Scanner;
public class Data {

    private ArrayList <User> users = new ArrayList<>();
    private ArrayList <CykelTur> cykelturliste = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private User user;

    public Data() {
        this.users = new ArrayList<>();
        this.cykelturliste = new ArrayList<>();

        generateData();
//        opretBruger();

    }

    private void generateData() {
        User user1 = new User("Hans45@gmail.com", 1234,"Hans Hansen",1);
        User user2 = new User("Bente65@gmail.com", 3450, "Bent Andersen",2);
        User user3 = new User("Peter78@gmail.com", 1311, "Peter Andersen",2);
        User user4 = new User("Morten78@gmail.com", 1319, "Morten Andersen",2);
        User user5 = new User("Seda19@gmail.com", 1329, "Seda Soysal",1);
        User user6 = new User("Christian21@gmail.com", 1339, "Christian Andersen",2);
        User user7 = new User("Ahilan25@gmail.com", 1330, "Ahilan Andersen",2);
        User user8 = new User("Alexander20@gmail.com", 1320, "Alexander Abildsø",2);
        User user9 = new User("Martin21@gmail.com", 1314, "Martin Jensen",1);
        User user10 = new User("Sebastian29@gmail.com", 1312, "Sebastian Andersen",2);
        User user11 = new User("Carl12@gmail.com", 1313, "Carl Strauss",2);
        User user12 = new User("Stig59@gmail.com", 1317, "Stig Andersen",2);
        User user13 = new User("Pia55@gmail.com", 1305, "Pia Andersen",1);
        User user14 = new User("Caroline23@gmail.com", 1304, "Caroline Petersen",2);
        User user15 = new User("Dorte43@gmail.com", 1333, "Dorte Hansen",2);
        User user16 = new User("Klaus78@gmail.com", 1334, "Bent Larsen",2);

//        Teams team1 = new Teams("1", "Team Hans", "Hans");

//        user.getTeams().add(team1);


        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
        users.add(user10);
        users.add(user11);
        users.add(user12);
        users.add(user13);
        users.add(user14);
        users.add(user15);
        users.add(user16);

    CykelTur cykelTur1=new CykelTur(45,4);
    CykelTur cykelTur2=new CykelTur(45,4);
    CykelTur cykelTur3=new CykelTur(45,4);
    CykelTur cykelTur4=new CykelTur(45,4);

    user1.addcykeltur(cykelTur1);
    user1.addcykeltur(cykelTur2);
    user1.addcykeltur(cykelTur3);
    user1.addcykeltur(cykelTur4);

//   cykelturliste.add(cykelTur1);
//   cykelturliste.add(cykelTur2);
//   cykelturliste.add(cykelTur3);
//   cykelturliste.add(cykelTur4);

    }

    public void opretBruger() {

        String Email;
        int nytpassword;
        int type;
        String holdid;
        int antalkørtekilometer;
        int antalkørtedage;


        System.out.println("Hvilken e-mail vil du gerne bruge som brugernavn? ");

        Email = input.nextLine();

        System.out.println("Indtast dit nye password");
        nytpassword = input.nextInt();

        System.out.println("Indtast hvor mange kilometer du har kørt:");
        antalkørtekilometer = input.nextInt();

        System.out.println("Indtast antal cyklede dage:");
        antalkørtedage = input.nextInt();


    }


    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<CykelTur> getCykelturliste() {
        return cykelturliste;
    }
}

