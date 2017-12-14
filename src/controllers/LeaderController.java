package controllers;

import data.Data;
import model.Cycleweek;
import model.Team;
import model.User;

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
            System.out.println("Holdkaptajn: " + team.getTeamLeader());
            System.out.println();
            System.out.printf("%-30s %-20s %-20s %-30s %-25s%-20s", "Navn på hold deltager", "Ugenummer", "Kørte dage", "Kørt distance for given uge", "Total kørte dage", "Total kørte distance\n");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
            //Derefter itterer vi gennem vores forskellige user og får adgang til dem
            for (User user : team.getUsers()) {
                //Users har deres egne cykeltur data, den finder vi frem ved at itterer gennem dette array
                for (Cycleweek cl : user.getCycleweeklist()) {
                    System.out.printf("%-30s %-20s %-20s %-30.2f %-25s %-20s\n", user.getName(), cl.getWeeknumber(), cl.getDaysdriven(), cl.getKilometersdriven(), "-", "-");

                }
                //til sidste skal vi have den totale antal dage samt kørte distance, dette gøres ved at referer til metoden som ligger i user klassen *se user klasse*
                System.out.printf("%-30s %-20s %-20s %-30s %-25s %-20.2f\n", "", "", "", "", user.getTotalDays(), user.getTotalDistance());
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
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

