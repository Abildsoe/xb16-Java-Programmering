package data;

import model.Cycleweek;
import model.Team;
import model.User;
import model.UserType;

import java.util.ArrayList;

public class Data {

    private ArrayList<Team> teams;
    private ArrayList<User> users;

    public Data() {
        this.users = new ArrayList<>();
        this.teams = new ArrayList<>();

        generateData();
    }
//Vores array med brugere
    private void generateData() {

        Team team1 = new Team(1, "Advokatsamfundet", "Hans Hansen");
        User user1 = new User("hans45@gmail.com", 1234, "Hans Hansen", UserType.Leader);
        User user2 = new User("bente65@gmail.com", 3450, "Bent Andersen", UserType.Participant);
        User user3 = new User("peter78@gmail.com", 1311, "Peter Andersen", UserType.Participant);
        User user4 = new User("morten78@gmail.com", 1319, "Morten Andersen", UserType.Participant);


        Team team2 = new Team(2, "Københavns Universitet", "Seda Soysal");
        User user5 = new User("seda19@gmail.com", 1329, "Seda Soysal", UserType.Leader);
        User user6 = new User("christian21@gmail.com", 1339, "Christian Andersen", UserType.Participant);
        User user7 = new User("ahilan25@gmail.com", 1330, "Ahilan Andersen", UserType.Participant);
        User user8 = new User("alexander20@gmail.com", 1320, "Alexander Abildsø", UserType.Participant);


        Team team3 = new Team(3, "Nykredit", "Martin Jensen");
        User user9 = new User("martin21@gmail.com", 14, "Martin Jensen", UserType.Leader);
        User user10 = new User("sebastian29@gmail.com", 1312, "Sebastian Andersen", UserType.Participant);
        User user11 = new User("carl12@gmail.com", 131653, "Carl Strauss", UserType.Participant);
        User user12 = new User("stig59@gmail.com", 1890317, "Stig Andersen", UserType.Participant);

        Team team4 = new Team(4, "Vejdirektoratet", "Pia Andersen");
        User user13 = new User("pia55@gmail.com", 13058, "Pia Andersen", UserType.Leader);
        User user14 = new User("caro4life@gmail.com", 304, "Caroline Petersen", UserType.Participant);
        User user15 = new User("dorte43@gmail.com", 133, "Dorte Hansen", UserType.Participant);
        User user16 = new User("moviestar_bent@gmail.com", 1334, "Bent Larsen", UserType.Participant);

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

        team1.addUser(user1);
        team1.addUser(user2);
        team1.addUser(user3);
        team1.addUser(user4);
        team2.addUser(user5);
        team2.addUser(user6);
        team2.addUser(user7);
        team2.addUser(user8);
        team3.addUser(user9);
        team3.addUser(user10);
        team3.addUser(user11);
        team3.addUser(user12);
        team4.addUser(user13);
        team4.addUser(user14);
        team4.addUser(user15);
        team4.addUser(user16);

//Vores array med forudsatte cykeluger
        Cycleweek cycleweek1 = new Cycleweek(30, 40, 5);
        user1.addcycleweek(cycleweek1);
        Cycleweek cycleweek2 = new Cycleweek(45, 40, 4);
        user2.addcycleweek(cycleweek2);
        Cycleweek cycleweek3 = new Cycleweek(50, 40, 4);
        user3.addcycleweek(cycleweek3);
        Cycleweek cycleweek4 = new Cycleweek(20, 40, 3);
        user4.addcycleweek(cycleweek4);
        Cycleweek cycleweek5 = new Cycleweek(30, 40, 6);
        user5.addcycleweek(cycleweek5);
        Cycleweek cycleweek6 = new Cycleweek(45, 40, 5);
        user6.addcycleweek(cycleweek6);
        Cycleweek cycleweek7 = new Cycleweek(50, 40, 5);
        user7.addcycleweek(cycleweek7);
        Cycleweek cycleweek8 = new Cycleweek(20, 40, 4);
        user8.addcycleweek(cycleweek8);
        Cycleweek cycleweek9 = new Cycleweek(30, 40, 3);
        user9.addcycleweek(cycleweek9);
        Cycleweek cycleweek10 = new Cycleweek(45, 40, 3);
        user10.addcycleweek(cycleweek10);
        Cycleweek cycleweek11 = new Cycleweek(50, 40, 3);
        user11.addcycleweek(cycleweek11);
        Cycleweek cycleweek12 = new Cycleweek(50, 40, 4);
        user12.addcycleweek(cycleweek12);
        Cycleweek cycleweek13 = new Cycleweek(20, 40, 4);
        user13.addcycleweek(cycleweek13);
        Cycleweek cycleweek14 = new Cycleweek(20, 40, 5);
        user14.addcycleweek(cycleweek14);
        Cycleweek cycleweek15 = new Cycleweek(15, 40, 6);
        user15.addcycleweek(cycleweek15);
        Cycleweek cycleweek16 = new Cycleweek(10, 40, 2);
        user16.addcycleweek(cycleweek16);

    }


    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }
}

