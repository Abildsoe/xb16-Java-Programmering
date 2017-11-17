import java.util.ArrayList;
import java.util.Scanner;
public class Data {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<CykelTur>cykelturliste=new ArrayList<>();
    Scanner input = new Scanner(System.in);
    User user;

    public Data() {
        this.users = new ArrayList<>();

        createUsers();
//        opretBruger();

    }

    private void createUsers() {
        User user = new User("Hans45@gmail.com", 1234,"Hans Hansen");
        User user1 = new User("Bente65@gmail.com", 3450, "Bent Andersen");
        User user2 = new User("Peter78@gmail.com", 1311, "Peter Andersen");
        User user3 = new User("Morten78@gmail.com", 1319, "Morten Andersen");
        User user4 = new User("Seda19@gmail.com", 1329, "Seda Soysal");
        User user5 = new User("Christian21@gmail.com", 1339, "Christian Andersen");
        User user6 = new User("Ahilan25@gmail.com", 1330, "Ahilan Andersen");
        User user7 = new User("Alexander20@gmail.com", 1320, "Alexander Abildsø");
        User user8 = new User("Martin21@gmail.com", 1314, "Martin Jensen");
        User user9 = new User("Sebastian29@gmail.com", 1312, "Sebastian Andersen");
        User user10 = new User("Carl12@gmail.com", 1313, "Carl Strauss");
        User user11 = new User("Stig59@gmail.com", 1317, "Stig Andersen");
        User user12 = new User("Pia55@gmail.com", 1305, "Pia Andersen");
        User user13 = new User("Caroline23@gmail.com", 1304, "Caroline Petersen");
        User user14 = new User("Dorte43@gmail.com", 1333, "Dorte Hansen");
        User user15 = new User("Klaus78@gmail.com", 1334, "Bent Larsen");

        Teams team1 = new Teams("1", "Team Hans", "Hans");

        user.getTeams().add(team1);


        users.add(user);
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

CykelTur cykelTur1=new CykelTur(45,4);
CykelTur cykelTur2=new CykelTur(45,4);
CykelTur cykelTur3=new CykelTur(45,4);
CykelTur cykelTur4=new CykelTur(45,4);

user1.addCykelture(cykelTur1);
        user1.addCykelture(cykelTur1);
        user1.addCykelture(cykelTur1);
        user1.addCykelture(cykelTur1);
        user1.addCykelture(cykelTur1);

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
}

