package controllers;

import data.Data;
import model.Cycleweek;
import model.Team;
import model.User;

public class LeaderController extends MemberController {


    public LeaderController(User currentUser, InputController inputCtrl, Data data) {
        super(currentUser, inputCtrl, data);
    }

    //https://stackoverflow.com/questions/16242733/sum-all-the-elements-java-arraylist

    public void showallinformationaboutEveryTeam() {


        for (Team team : this.data.getTeams()) {
            System.out.println();
            System.out.println("Holdnavn: " + team.getTeamName());
            System.out.println("HoldLeder: " + team.getTeamLeader());
            System.out.println();
            System.out.printf("%-30s %-20s %-20s %-30s %-25s%-20s", "Navn på hold deltager", "Ugenummer", "Kørte dage", "Kørt distance for given uge", "Total kørte dage", "Total kørte distance\n");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
            for (User user : team.getUsers()) {

                for (Cycleweek cl : user.getCycleweeklist()) {
                    System.out.printf("%-30s %-20s %-20s %-30s %-25s %-20s\n", user.getName(), cl.getWeeknumber(), cl.getDaysdriven(), cl.getKilometersdriven(), "-", "-");

                }
                System.out.printf("%-30s %-20s %-20s %-30s %-25s %-20s\n", "", "", "", "", user.getTotalDays(), user.getTotalDistance());
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }


    public void showUserMenu() {

        int valg;
        System.out.println("");
        System.out.println("Holdkaptajnmenu:");
        System.out.println("1) Indberetning af cykelture");
        System.out.println("2) Ændre cykelture");
        System.out.println("3) Slet cykelture");
        System.out.println("4) Vis alle oplysninger om eget hold");
        System.out.println("5) Vis en statistik over gennemsnitlige kørte km");
        System.out.println("6) Vis alle oplysninger om alle hold");
        System.out.println("7) Log ud af systemet");
        System.out.println("vælg et menupunkt: ");

    }
}

