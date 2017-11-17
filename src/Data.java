import java.util.ArrayList;
import java.util.Scanner;
public class Data {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Teams> teams = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    User user;

    public Data() {
        this.users = new ArrayList<>();

        createUsers();
//        opretBruger();

    }

    private void createUsers() {
        //team1
        User user = new User("Hans45@gmail.com", 1234, 1, "Hans");
        User user1 = new User("Bente65@gmail.com", 3450, 2, "Bente");
        User user2 = new User("Peter78@gmail.com", 1311, 2, "Peter");
        User user3 = new User("Morten78@gmail.com", 1319, 2, "Morten");

        //team2
        User user4 = new User("Seda19@gmail.com", 1329, 1, " Seda");
        User user5 = new User("Christian21@gmail.com", 1339, 2, "Christian");
        User user6 = new User("Ahilan25@gmail.com", 1330, 2, "Ahilan");
        User user7 = new User("Alexander20@gmail.com", 1320, 2, "Alexander");

        //team3
        User user8 = new User("Martin21@gmail.com", 1314, 1, " Martin");
        User user9 = new User("Sebastian29@gmail.com", 1312, 2, "Sebastian");
        User user10 = new User("Carl12@gmail.com", 1313, 2, "Carl");
        User user11 = new User("Stig59@gmail.com", 1317, 2, "Stig");

        //team4
        User user12 = new User("Pia55@gmail.com", 1305, 1, "Pia");
        User user13 = new User("Caroline23@gmail.com", 1304, 2, "Caroline");
        User user14 = new User("Dorte43@gmail.com", 1333, 2, "Dorte");
        User user15 = new User("Klaus78@gmail.com", 1334, 2, "Klaus");

        // tilføjer deltagere og holdkaptajn til hvert cykelhold

        Teams team1 = new Teams("1", "HansesSuperTeam", "Hans");
        team1.getholdmedlemmer().add(user);
        team1.getholdmedlemmer().add(user1);
        team1.getholdmedlemmer().add(user2);
        team1.getholdmedlemmer().add(user3);

        Teams team2 = new Teams(" 2" , "SedasCykleHold", " Seda");
        team2.getholdmedlemmer().add(user4);
        team2.getholdmedlemmer().add(user5);
        team2.getholdmedlemmer().add(user6);
        team2.getholdmedlemmer().add(user7);

        Teams team3 = new Teams(" 3" , " MartinsCyklere", "Martin");
        team2.getholdmedlemmer().add(user8);
        team2.getholdmedlemmer().add(user9);
        team2.getholdmedlemmer().add(user10);
        team2.getholdmedlemmer().add(user11);

        Teams team4 = new Teams(" 4" , "PiasHold", "Pia");
        team2.getholdmedlemmer().add(user12);
        team2.getholdmedlemmer().add(user13);
        team2.getholdmedlemmer().add(user14);
        team2.getholdmedlemmer().add(user15);



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

    public ArrayList<Teams> getTeam() {return teams;}


    }


