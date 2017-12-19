package controllers;

import data.Data;
import model.*;

import java.util.Scanner;

public class ParticipantController {
    protected User currentUser;
    Scanner input;
    protected Data data;

    public ParticipantController(User currentUser, Scanner input, Data data) {
        this.currentUser = currentUser;
        this.input = input;
        this.data = data;
    }

    // Her oprettes "Participant menuen"
    public void showParticipantMenu() {

        System.out.println("Deltagermenu:");
        System.out.println("1) Indberetning af cykeluge");
        System.out.println("2) Ændre cykeluger");
        System.out.println("3) Slet cykeluger");
        System.out.println("4) Vis alle oplysninger om eget hold");
        System.out.println("7) Log ud af systemet");

    }

    public void reportinformation() {
        //Her defineres de forskellige variabler
        int daysdriven, weeknumber;
        double kilometersdriven;

        //Her indtastes en int værdi, som referer tilbage til vores inputcontroller hvor der laves "try" "catch" for at undgå fejl
        System.out.println("Indtast ugenummer: ");
        weeknumber = readInputAsInt();
        //Her indtastes en int værdi, som referer tilbage til vores inputcontroller hvor der laves "try" "catch" for at undgå fejl
        System.out.println("Indtast kørt distance for given uge");
        kilometersdriven = readInputAsDouble();
        //Her indtastes en double værdi af "antal kilometer"
        System.out.println("Indtast Kørte dage");
        daysdriven = readInputAsInt();


        System.out.println("---------------------------------------");
        //Her printes oplysningerne ud på antal kilometer, antal kørte dage og ugenummer
        System.out.println("Du har indtastet følgende oplysninger: " + "\nUgenummer: " + weeknumber + "\nKørt distance for given uge: " + kilometersdriven + "\nKørte dage: " + daysdriven);

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
            System.out.printf("%-10s %-20s %-30s %-40s \n", "Nr.", "Ugenummer", "Kørte km for given uge", "Kørte dage");
            System.out.println("-------------------------------------------------------------------------------------------");
            for (Cycleweek cycleweek : currentUser.getCycleweeklist()) {
                System.out.printf("%-10d %-20d %-30.2f %-40d \n", index, cycleweek.getWeeknumber(), cycleweek.getKilometersdriven(), cycleweek.getDaysdriven());
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
            i = readInputAsInt();

            /*
            Her kalder den Arraylisten "cycleweeklist" ved, at sige currentuser.getCycleweeklist.get(i-1) hvilket betyder at den vil altid starte på 0
            Derfor hvis man indtaster 1, så skal den vide at det er plads nummer 0 i arrayet.
            */
            cycleweektochange = currentUser.getCycleweeklist().get(i - 1);


            // Her Ugenummeret man gerne vil ændre
            System.out.println("Vælg ugenummer: ");
            newweeknumber = readInputAsInt();
            cycleweektochange.setWeeknumber(newweeknumber);

            //Her vælges antal kørte kilometer til at ændre
            System.out.println("Vælg kørt distance for given uge: ");
            newkilometersdriven = readInputAsDouble();
            cycleweektochange.setKilometersdriven(newkilometersdriven);


            //Her vælges antal kørte dage til at ændre
            System.out.println("Vælg kørte dage: ");
            newdaysdriven = readInputAsInt();
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
            System.out.printf("%-10s %-20s %-30s %-40s \n", "Nr.", "Ugenummer ", "Kørte km for given uge", "Kørte dage");
            System.out.println("--------------------------------------------------------------------------------------------");
            for (Cycleweek cykeltur : currentUser.getCycleweeklist()) {
                System.out.printf("%-10d %-20d %-30.2f %-40d \n", i, cykeltur.getWeeknumber(), cykeltur.getKilometersdriven(), cykeltur.getDaysdriven());
                i++;
                System.out.println("--------------------------------------------------------------------------------------------");
            }

            //Her oprettes et objekt af Cycleweek klassen, hvorefter vi opretter et index der vil være det tal du indtaster for at slette noget.

            int index;
            Cycleweek cycleweektodelete;
            System.out.print("");
            System.out.println("Indtast nummeret på den cykeluge du gerne vil slette ");
            index = readInputAsInt();
            --index; // træk en fra antallet af cykelture
            cycleweektodelete = currentUser.getCycleweeklist().get(index);

            currentUser.getCycleweeklist().remove(cycleweektodelete);
            System.out.println("----------------------------------------");
            System.out.println("Cykelugen blev slettet fra dit register");
            System.out.println("----------------------------------------");
        }
    }

    public void showInformationAboutOwnTeam() {

        System.out.printf("%-30s %-20s %-30s %-20s\n", "Holdinformation", "Ugenummer", "Kørte km for given uge", "Kørte dage");
        System.out.println("-------------------------------------------------------------------------------------------------------");


        for (Team team : this.data.getTeams()) {//initialiserer alle hold
            for (User user : team.getUsers()) {// initialiserer alle holdmedlemmer på hvert hold
                if (user.equals(currentUser)) {//tjekker hvilke hold medlemmer der er tilknyttet brugerens hold


                    System.out.println("Team name  " + team.getTeamName());
                    System.out.println("Team Leader  " + team.getTeamLeader());


                    System.out.println("-------------------------------------------------------------------------------------------------------");

                    for (User member : team.getUsers()) {//alle holdmedlemmer på hvert hold
                        for (Cycleweek cl : member.getCycleweeklist()) {// Cykelforløb data hentes for hvert enkelt medlem på hold


                            System.out.printf("%-30s %-20d %-30.2f %-20d\n", member.getName(), cl.getWeeknumber(), cl.getKilometersdriven(), cl.getDaysdriven());

                        }
                        System.out.println("-------------------------------------------------------------------------------------------------------");

                    }
                }
            }
        }
    }
    //Bruges til at læse hele input fra skanneren og returnere variablen
    private String readInputAsString() {
        return this.input.nextLine();
    }
//Try catch til en integer
    private int readInputAsInt() {
        try {
            String str = readInputAsString();
            return Integer.parseInt(str);
        } catch (Exception e) {
            System.out.println("Prøv igen med et tal i stedet!");
            return readInputAsInt();
        }

    }
//Try catch til en double som laver undtagelse uafhængigt af
    private double readInputAsDouble() {
        try {
            String str = readInputAsString();
            return Double.parseDouble(str);
        } catch (Exception e) {
            System.out.println("Prøv igen med et tal i stedet!");
            return readInputAsDouble();
        }

    }

}