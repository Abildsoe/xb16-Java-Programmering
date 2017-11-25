package controllers;

import data.Data;
import model.CykelTur;
import model.Team;
import model.User;

public class LeaderController extends MemberController {


    public LeaderController(User currentUser, InputController inputCtrl, Data data) {
        super(currentUser, inputCtrl, data);
    }


    public void visalleoplysningeromAllehold() {

        System.out.printf("%-10s %-25s %-20s %-25s %-30s %-5s\n", "HoldID", "Holdnavn", "Holdleder", "Medlem", "Antal kørte Dage", "Antal kørte Kilometer");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        for (Team team : this.data.getTeams()) {
            System.out.println("Id: " + team.getTeamID());
            System.out.println("Holdnavn: " + team.getTeamName());
            for (User user : team.getUsers()) {
//                System.out.printf("%-10s %-25s %-20s %-25s %-30s %-5s\n", team.getTeamID(), team.getTeamName(), team.getTeamLeader(), user.getName(), user.getCykelturDagesum(), user.getCykelturKMSum());
                for (CykelTur cl : user.getCykelturliste()) {
                    System.out.printf("%-10s %-25s %-20s %-25s %-30s %-5s\n", team.getTeamID(), team.getTeamName(), team.getTeamLeader(), user.getName(), cl.getAntalkørtedage(), cl.getAntalkørtekilometer());
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
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
        System.out.println("4) Vis alle oplysninger om en deltager");
        System.out.println("5) Vis alle oplysninger om eget hold");
        System.out.println("6) Vis en statistik over gennemsnitlige kørte km");
        System.out.println("7) Vis alle oplysninger om alle hold");
        System.out.println("8) Log ud af systemet");
        System.out.println("vælg et menupunkt: ");

    }
}

