package data;

import model.CykelTur;
import model.Team;
import model.User;
import model.UserType;

import java.util.ArrayList;
import java.util.Scanner;

public class Data {

    private ArrayList<Team> teams;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<CykelTur> cykelturliste = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public Data() {
        this.users = new ArrayList<>();
        this.teams = new ArrayList<>();
        this.cykelturliste = new ArrayList<>();

        generateData();
//        opretBruger();

    }

    private void generateData() {

        Team team1 = new Team(1, "HansesSuperTeam", "Hans");
        User user1 = new User("Hans45@gmail.com", 1234, "Hans Hansen", UserType.Holdkaptajn, team1);
        User user2 = new User("Bente65@gmail.com", 3450, "Bent Andersen", UserType.User, team1);
        User user3 = new User("Peter78@gmail.com", 1311, "Peter Andersen", UserType.User, team1);
        User user4 = new User("Morten78@gmail.com", 1319, "Morten Andersen", UserType.User, team1);


        Team team2 = new Team(2, "SedasCykleHold", " Seda");
        User user5 = new User("Seda19@gmail.com", 1329, "Seda Soysal", UserType.Holdkaptajn, team2);
        User user6 = new User("Christian21@gmail.com", 1339, "Christian Andersen", UserType.User, team2);
        User user7 = new User("Ahilan25@gmail.com", 1330, "Ahilan Andersen", UserType.User, team2);
        User user8 = new User("Alexander20@gmail.com", 1320, "Alexander Abildsø", UserType.User, team2);


        Team team3 = new Team(3, "MartinsCyklere", "Martin");
        User user9 = new User("Martin21@gmail.com", 1314, "Martin Jensen", UserType.Holdkaptajn, team3);
        User user10 = new User("Sebastian29@gmail.com", 1312, "Sebastian Andersen", UserType.User, team3);
        User user11 = new User("Carl12@gmail.com", 1313, "Carl Strauss", UserType.User, team3);
        User user12 = new User("Stig59@gmail.com", 1317, "Stig Andersen", UserType.User, team3);

        Team team4 = new Team(4, "PiasHold", "Pia");
        User user13 = new User("Pia55@gmail.com", 1305, "Pia Andersen", UserType.Holdkaptajn, team4);
        User user14 = new User("Caroline23@gmail.com", 1304, "Caroline Petersen", UserType.User, team4);
        User user15 = new User("Dorte43@gmail.com", 1333, "Dorte Hansen", UserType.User, team4);
        User user16 = new User("Klaus78@gmail.com", 1334, "Bent Larsen", UserType.User, team4);

        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

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

        CykelTur cykelTur1 = new CykelTur(30, 2);
        user1.addcykeltur(cykelTur1);
        CykelTur cykelTur2 = new CykelTur(45, 4);
        user5.addcykeltur(cykelTur2);
        CykelTur cykelTur3 = new CykelTur(50, 3);
        user4.addcykeltur(cykelTur3);
        CykelTur cykelTur4 = new CykelTur(20, 1);
        user8.addcykeltur(cykelTur4);
        CykelTur cykelTur5 = new CykelTur(30, 2);
        user6.addcykeltur(cykelTur5);
        CykelTur cykelTur6 = new CykelTur(45, 4);
        user1.addcykeltur(cykelTur6);
        CykelTur cykelTur7 = new CykelTur(50, 3);
        user2.addcykeltur(cykelTur7);
        CykelTur cykelTur8 = new CykelTur(20, 1);
        user10.addcykeltur(cykelTur8);
        CykelTur cykelTur9 = new CykelTur(30, 2);
        user10.addcykeltur(cykelTur9);
        CykelTur cykelTur10 = new CykelTur(45, 4);
        user15.addcykeltur(cykelTur10);
        CykelTur cykelTur11 = new CykelTur(50, 3);
        user16.addcykeltur(cykelTur11);
        CykelTur cykelTur12 = new CykelTur(20, 1);
        user7.addcykeltur(cykelTur12);

    }


    public ArrayList<User> getUsers() {
        return users;
    }

    //public ArrayList<CykelTur> getCykelturliste() {
    //    return cykelturliste;                                         Skal det her bruges?? Når dataen er koblet på brugeren??
  //  }

    public ArrayList<Team> getTeams() {
        return teams;
    }
}

