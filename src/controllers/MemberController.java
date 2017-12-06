package controllers;

import data.Data;
import model.*;

import java.util.Scanner;

import java.util.ArrayList;

public class MemberController {
    Scanner input;

    private User currentUser;
    protected Data data;

    public MemberController(User currentUser, Scanner input, Data data) {
        this.currentUser = currentUser;
        this.input = input;
        this.data = data;
    }

    // Her oprettes "User menuen"
    public void showUserMenu() {

        System.out.println("Brugermenu:");
        System.out.println("1) Indberetning af cykeluge");
        System.out.println("2) Ændre cykeluge");
        System.out.println("3) Slet cykeluge");
        System.out.println("4) Vis alle oplysninger om eget hold");
        System.out.println("5) Vis en statistik over gennemsnitlige kørte km");
        System.out.println("7) Log ud af systemet");

    }

    public void reportinformation() {
        //Her defineres de forskellige variabler
        int daysdriven, weeknumber;
        double kilometersdriven;

        //Her indtastes en int værdi, som referer tilbage til vores inputcontroller hvor der laves "try" "catch" for at undgå fejl
        System.out.println("Indtast ugenummer: ");
        weeknumber = læsInputSomInt();
        //Her indtastes en double værdi af "antal kilometer"
        System.out.println("Indtast Kørte dage");
        daysdriven = læsInputSomInt();
        //Her indtastes en int værdi, som referer tilbage til vores inputcontroller hvor der laves "try" "catch" for at undgå fejl
        System.out.println("Indtast kørt distance for given uge");
        kilometersdriven = læsInputSomDouble();



        System.out.println("---------------------------------------");
        //Her printes oplysningerne ud på antal kilometer, antal kørte dage og ugenummer
        System.out.println("Du har indtastet følgende oplysninger: " + "\nUgenummer: " + weeknumber +"\nKørt distance for given uge: " + kilometersdriven + "\nKørte dage: " + daysdriven);

        System.out.println("---------------------------------------");

        Cycleweek cycleweek = new Cycleweek(kilometersdriven, daysdriven, weeknumber);
        this.currentUser.addcycleweek(cycleweek);


    }

    public void changereportedinformation() {
        int index = 1;
        //Tjek om der findes nogen cykelture der kan ændres
        if (currentUser.getCycleweeklist().size() == 0) {
            System.out.println("Du har ingen cykelture du kan ændre!\n");
        } else {
            System.out.println("Nedenstående kan du se de cykelture du kan ændre ");
            System.out.println("-------------------------------------------------------------------------------------------");


            //Header i de Cykelture man kan ændre, derudover nedenstående i for-løkken udprintes data arraylisten "Cycleweeklist"
            System.out.printf("%-10s %-20s %-30s %-40s \n", "Nr.", "Ugenummer", "Kørte dage", "Kørt distance for given uge");
            System.out.println("-------------------------------------------------------------------------------------------");
            for (Cycleweek cycleweek : currentUser.getCycleweeklist()) {
                System.out.printf("%-10d %-20d %-30d %-40.2f \n", index, cycleweek.getWeeknumber(), cycleweek.getDaysdriven(), cycleweek.getKilometersdriven());
                index++;
                System.out.println("-------------------------------------------------------------------------------------------");
            }

            //Her defineres variablerne
            int i;
            double newkilometersdriven;
            int newdaysdriven;
            int newweeknumber;
            Cycleweek cycleweektochange;
            System.out.print("");
            System.out.println("Indtast nummeret på den cykeluge du gerne vil ændre: ");
            i = læsInputSomInt();

                //Her kalder den Arraylisten "cycleweeklist" ved, at sige currentuser.getCycleweeklist.get(i-1) hvilket betyder at den vil altid starte på 0
                //Derfor hvis man indtaster 1, så skal den vide at det er plads nummer 0 i arrayet.
                cycleweektochange = currentUser.getCycleweeklist().get(i - 1);


                // Her Ugenummeret man gerne vil ændre
                System.out.println("Vælg ugenummer: ");
                newweeknumber = læsInputSomInt();
                cycleweektochange.setWeeknumber(newweeknumber);

                //Her vælges antal kørte kilometer til at ændre
                System.out.println("Vælg kørt distance for given uge: ");
                newkilometersdriven = læsInputSomDouble();
                cycleweektochange.setKilometersdriven(newkilometersdriven);


                //Her vælges antal kørte dage til at ændre
                System.out.println("Vælg kørte dage: ");
                newdaysdriven = læsInputSomInt();
                cycleweektochange.setDaysdriven(newdaysdriven);


                System.out.println("-----------------------------------------");
                System.out.println("Din ændring er nu registreret i systemet!");
                System.out.println("-----------------------------------------");


            }
        }


    public void deleteinformation() {
        int i = 1;
        //Tjek om der findes nogen cykelture

        if (currentUser.getCycleweeklist().size() == 0) {
            System.out.println("Du har ingen indtastede cykeluger!\n");
        } else {

            System.out.println("Dine cykeluger er: ");
            System.out.println("--------------------------------------------------------------------------------------------");
            // Header i Cykelturvisning
            System.out.printf("%-10s %-20s %-30s %-40s \n", "Nr.", "Ugenummer ", "Kørte dage", "Kørt distance for given uge");
            System.out.println("--------------------------------------------------------------------------------------------");
            for (Cycleweek cykeltur : currentUser.getCycleweeklist()) {
                System.out.printf("%-10d %-20d %-30d %-40.2f \n", i, cykeltur.getWeeknumber(), cykeltur.getDaysdriven(), cykeltur.getKilometersdriven());
                i++;
                System.out.println("--------------------------------------------------------------------------------------------");
            }

            //Her oprettes et objekt af Cycleweek klassen, hvorefter vi opretter et index der vil være det tal du indtaster for at slette noget.

            int index;
            Cycleweek cycleweektodelete;
            System.out.print("");
            System.out.println("Indtast nummeret på den cykeluge du gerne vil slette ");
            index = læsInputSomInt();
            --index; // træk en fra antallet af cykelture
            cycleweektodelete = currentUser.getCycleweeklist().get(index);

            currentUser.getCycleweeklist().remove(cycleweektodelete);
            System.out.println("----------------------------------------");
            System.out.println("Cykelugen blev slettet fra dit register");
            System.out.println("----------------------------------------");
        }
    }


    public void showInformationAboutOwnTeam() {

        System.out.printf("%-30s%-25s%-20s%-10s", "Holdinformation", "Ugenummer", "Kørte dage", "Kørt distance for given uge\n");
        System.out.println("-------------------------------------------------------------------------------------------------------");


        for (Team team : this.data.getTeams()) {//initialiserer alle hold
            for (User user : team.getUsers()) {// initialiserer alle holdmedlemmer på hvert hold
                if (user.equals(currentUser)) {//tjekker hvilke hold medlemmer der er tilknyttet brugerens hold


                    System.out.println("Team name  " + team.getTeamName());
                    System.out.println("Team Leader  " + team.getTeamLeader());


                    System.out.println("-------------------------------------------------------------------------------------------------------");

                    for (User member : team.getUsers()) {//alle holdmedlemmer på hvert hold
                        for (Cycleweek cl : member.getCycleweeklist()) {// Cykelforløb data hentes for hvert enkelt medlem på hold


                            System.out.printf("%-30s%-25s%-20s%-10.2f\n", member.getName(), cl.getWeeknumber(), cl.getDaysdriven(), cl.getKilometersdriven());

                        }
                        System.out.println("-------------------------------------------------------------------------------------------------------");

                    }
                }
            }
        }
    }

    /* Created by Ahilan Selliah 18/11/2017

     */
    public void statisticsonkilometersanddays() {
        System.out.println("Statistik på indberetninger");
        System.out.println("-----------------------------------------------");
        Statistics resultatForBruger = GennemsnitForBruger(currentUser);
        System.out.println("Statestik for: " + currentUser.getName());
        System.out.println("Gennemsnitlig kørte km pr. dag: " + resultatForBruger.averageKmPerDay);
        System.out.println("Gennemsnitlig kørte km pr. uge: " + resultatForBruger.averageKmPerWeek);
        System.out.println("-----------------------------------------------");

        ArrayList brugerePåMitHold = new ArrayList<User>();
        for (User u : getTeamForMember(currentUser).getUsers()) {
            if (u.getUsername() != currentUser.getUsername()) {
                brugerePåMitHold.add(u);
                Statistics resultatForHoldbrugere = GennemsnitForBruger(u);
                System.out.println("Statestik for holdmedlem: " + u.getName());
                System.out.println("\nGennemsnitlig kørte km pr. dag: " + resultatForHoldbrugere.averageKmPerDay);
                System.out.println("Gennemsnitlig kørte km pr. uge: " + resultatForHoldbrugere.averageKmPerWeek);
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

    private Statistics GennemsnitForBruger(User user) {
        int antalkørtekilometer = 0;
        int antalkørtedage = 0;
        int antalcykelture = user.getCycleweeklist().size();
        for (Cycleweek c : user.getCycleweeklist()) {
            antalkørtekilometer += c.getKilometersdriven();
            antalkørtedage += c.getDaysdriven();
        }
        double gennemsnitkørtekmpruge = 0;
        double gennemsnitkørtekmprdag = 0;
        if (antalcykelture > 0 && antalkørtedage > 0) {
            gennemsnitkørtekmpruge = antalkørtekilometer / antalcykelture;
            gennemsnitkørtekmprdag = antalkørtekilometer / antalkørtedage;
        }
        return new Statistics(gennemsnitkørtekmprdag, gennemsnitkørtekmpruge);
    }


    private String læsInputSomString() {
        return this.input.nextLine();
    }

    private int læsInputSomInt() {
        try {
            String str = læsInputSomString();
            return Integer.parseInt(str);
        } catch (Exception e) {
            System.out.println("Prøv igen med et tal i stedet!");
            return læsInputSomInt();
        }

    }

    private double læsInputSomDouble() {
        try {
            String str = læsInputSomString();
            return Double.parseDouble(str);
        } catch (Exception e) {
            System.out.println("Prøv igen med et tal i stedet!");
            return læsInputSomDouble();
        }

    }

}