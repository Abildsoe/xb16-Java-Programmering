import java.util.ArrayList;
import java.util.Scanner;
public class Data {
    private ArrayList<User> users = new ArrayList<>();
    Scanner input = new Scanner(System.in);


    public Data() {
        this.users = new ArrayList<>();

        createUsers();
//        opretBruger();

    }

    private void createUsers() {
        User user = new User("Hans45@gmail.com", 1234, 1, "Team Hans", 30, 3);
        User user1 = new User("Bente65@gmail.com", 3450, 1, "Team Hans", 60, 3);
        User user2 = new User("Peter78@gmail.com", 1311, 2, "Team Hans", 50, 2);
        User user3 = new User("Morten78@gmail.com", 1319, 2, "Team Hans", 75, 3);
        User user4 = new User("Seda19@gmail.com", 1329, 1, "Team Seda", 65, 3);
        User user5 = new User("Christian21@gmail.com", 1339, 2, "Team Seda", 80, 4);
        User user6 = new User("Ahilan25@gmail.com", 1330, 2, "Team Seda", 75, 4);
        User user7 = new User("Alexander20@gmail.com", 1320, 2, "Team Seda", 76, 4);
        User user8 = new User("Martin21@gmail.com", 1314, 1, "Team Martin", 100, 5);
        User user9 = new User("Sebastian29@gmail.com", 1312, 2, "Team Martin", 88, 4);
        User user10 = new User("Carl12@gmail.com", 1313, 2, "Team Martin", 55, 3);
        User user11 = new User("Stig59@gmail.com", 1317, 2, "Team Martin", 76, 4);
        User user12 = new User("Pia55@gmail.com", 1305, 1, "Team Pia", 73, 3);
        User user13 = new User("Caroline23@gmail.com", 1304, 2, "Team Pia", 45, 3);
        User user14 = new User("Dorte43@gmail.com", 1333, 2, "Team Pia", 66, 4);
        User user15 = new User("Klaus78@gmail.com", 1334, 2, "Team Pia", 76, 4);


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


        User users = new User();


    }


    public ArrayList<User> getUsers() {
        return users;
    }
}

