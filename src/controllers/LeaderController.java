package controllers;

import data.Data;
import model.Cycleweek;
import model.Statistics;
import model.Team;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LeaderController extends MemberController {


    public LeaderController(User currentUser, Scanner input, Data data) {
        super(currentUser, input, data);
    }

    //https://stackoverflow.com/questions/16242733/sum-all-the-elements-java-arraylist
    public void showallinformationaboutEveryTeam() {

        //Først itterer vi gennem vores forskellige teams og printer information som, teamnavn og holdkaptajn
        for (Team team : this.data.getTeams()) {
            System.out.println("\nHoldnavn: " + team.getTeamName());
            System.out.println("Leader: " + team.getTeamLeader());
            System.out.println();
            System.out.printf("%-30s %-20s %-30s %-20s %-25s%-20s\n", "Navn på hold deltager", "Ugenummer", "Kørte km for given uge", "Kørte dage", "Total kørte km", "Total kørte dage");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
            //Derefter itterer vi gennem vores forskellige user og får adgang til dem
            for (User user : team.getUsers()) {
                //Users har deres egne cykeltur data, den finder vi frem ved at itterer gennem dette array
                for (Cycleweek cl : user.getCycleweeklist()) {
                    System.out.printf("%-30s %-20d %-30.2f %-20d %-25s %-20s\n", user.getName(), cl.getWeeknumber(), cl.getKilometersdriven(), cl.getDaysdriven(), "-", "-");

                }
                //til sidste skal vi have den totale antal dage samt kørte distance, dette gøres ved at referer til metoden som ligger i user klassen *se user klasse*
                System.out.printf("%-30s %-20s %-30s %-20s %-25.2f %-20d\n", "", "", "", "", user.getTotalDistance(), user.getTotalDays());
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    //Created by Ahilan Selliah 18/11/2017
    public void statisticsonkilometersanddays() {
        System.out.println("Statistik på indberetninger");
        System.out.println("-----------------------------------------------");
        Statistics resultForUser = averageForUser(currentUser);
        System.out.println("Statestik for: " + currentUser.getName());
        System.out.println("Gennemsnitlig kørte km pr. dag: " + resultForUser.averageKmPerDay);
        System.out.println("Gennemsnitlig kørte km pr. uge: " + resultForUser.averageKmPerWeek);
        System.out.println("-----------------------------------------------");

        ArrayList usersOnMyTeam = new ArrayList<User>();
        for (User u : getTeamForMember(currentUser).getUsers()) {
            if (u.getUsername() != currentUser.getUsername()) {
                usersOnMyTeam.add(u);
                Statistics resultsForTeamUsers = averageForUser(u);
                System.out.println("Statestik for holdmedlem: " + u.getName());
                System.out.println("\nGennemsnitlig kørte km pr. dag: " + resultsForTeamUsers.averageKmPerDay);
                System.out.println("Gennemsnitlig kørte km pr. uge: " + resultsForTeamUsers.averageKmPerWeek);
                System.out.println("");
            }
        }
    }

    private Team getTeamForMember(User user) {
        for (Team t : data.getTeams()) {
            for (User u : t.getUsers()) {
                if (u.getUsername() == user.getUsername())
                    return t;
            }
        }

        return null;
    }

    private Statistics averageForUser(User user) {
        int kilometersdriven = 0;
        int daysdriven = 0;
        int cyclingTrips = user.getCycleweeklist().size();
        for (Cycleweek c : user.getCycleweeklist()) {
            kilometersdriven += c.getKilometersdriven();
            daysdriven += c.getDaysdriven();
        }
        double averageDrivenKilometersDrivenprWeek = 0;
        double averageDrivenKilometersDrivenprDay = 0;
        if (cyclingTrips > 0 && daysdriven > 0) {
            averageDrivenKilometersDrivenprWeek = kilometersdriven / cyclingTrips;
            averageDrivenKilometersDrivenprDay = kilometersdriven / daysdriven;
        }
        return new Statistics(averageDrivenKilometersDrivenprDay, averageDrivenKilometersDrivenprWeek);
    }

    public void showUserMenu() {
        System.out.println("Holdkaptajnmenu:");
        System.out.println("1) Indberetning af cykeluge");
        System.out.println("2) Ændre cykeluger");
        System.out.println("3) Slet cykeluge");
        System.out.println("4) Vis alle oplysninger om eget hold");
        System.out.println("5) Vis en statistik over gennemsnitlige kørte km");
        System.out.println("6) Vis alle oplysninger om alle hold");
        System.out.println("7) Log ud af systemet");
        System.out.println("vælg et menupunkt: ");

    }
}

