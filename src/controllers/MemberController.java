package controllers;

import data.Data;
import model.Cycleweek;
import model.Team;
import model.Tuple;
import model.User;
import java.util.Scanner;

import java.util.ArrayList;

public class MemberController {
    Scanner input=new Scanner(System.in);

    InputController inputCtrl;
    protected User currentUser;
    protected Data data;

    public MemberController(User currentUser, InputController inputCtrl, Data data) {
        this.currentUser = currentUser;
        this.inputCtrl = inputCtrl;
        this.data = data;
    }

// Her oprettes "User menuen"
    public void showUserMenu() {

        System.out.println("Brugermenu:");
        System.out.println("1) Indberetning af cykelture");
        System.out.println("2) Ændre cykelture");
        System.out.println("3) Slet cykelture");
        System.out.println("4) Vis alle oplysninger om en deltager");
        System.out.println("5) Vis alle oplysninger om eget hold");
        System.out.println("6) Vis en statistik over gennemsnitlige kørte km");
        System.out.println("8) Log ud af systemet");

    }

    public void reportinformation() {
//Her defineres de forskellige variabler
        int daysdriven,weeknumber;
        double kilometersdriven;
//Her indtastes en double værdi af "antal kilometer"
        System.out.println("Indtast antal kilometer");
        kilometersdriven = input.nextDouble();
//Her indtastes en int værdi, som referer tilbage til vores inputcontroller hvor der laves "try" "catch" for at undgå fejl
        System.out.println("Indtast antal kørselsdage");
        daysdriven = inputCtrl.læsInputSomInt();

//Her indtastes en int værdi, som referer tilbage til vores inputcontroller hvor der laves "try" "catch" for at undgå fejl
        System.out.println("Indtast ugenummer for indberettede data");
        weeknumber=inputCtrl.læsInputSomInt();

        System.out.println("_________________________________________________________________________________");
//Her printes oplysningerne ud på antal kilometer, antal kørte dage og ugenummer
        System.out.println("Du har indtastet følgende oplysninger: "+"\nAntal kørte kilometer: "+kilometersdriven+"\nAntal kørte dage: "+daysdriven+"\nUgenummer: "+weeknumber);

        System.out.println("_________________________________________________________________________________");

        Cycleweek cycleweek = new Cycleweek(kilometersdriven, daysdriven,weeknumber);
        this.currentUser.addcycleweek(cycleweek);


    }

    public void changereportedinformation() {
        int index=1;
//        Tjek om der findes nogen cykelture der kan ændres
        if(currentUser.getCycleweeklist().size()==0){
            System.out.println("Du har ingen cykelture du kan ændre");
        } else{
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println("Nedenstående kan du se de cykelture du kan ændre: ");

//            Header i de Cykelture man kan ændre, derudover nedenstående i for-løkken udprintes data arraylisten "Cycleweeklist"
            System.out.printf("%-10s %-20s %-30s %-40s \n","Nr.", "Cykelturens antal kørte kilometer: ", "Cykelturens antal kørte dage: ","Cykelturens ugenummer: ");
            for(Cycleweek cycleweek: currentUser.getCycleweeklist()){
                System.out.printf("%-10d %-40.2f %-30d %-40d \n",index,cycleweek.getKilometersdriven(),cycleweek.getDaysdriven(),cycleweek.getWeeknumber());
                index++;
                System.out.println("---------------------------------------------------------------------------------------------------");
            }

        }
//        Her defineres variablerne
        int i;
        double newkilometersdriven;
        int newdaysdriven;
        int newweeknumber;
        Cycleweek cycleweektochange;
        System.out.print("");
        System.out.println("Indtast nummeret på den cykeltur du gerne vil ændre: ");
        i=inputCtrl.læsInputSomInt();

//        Her kalder den Arraylisten "cycleweeklist" ved, at sige currentuser.getCycleweeklist.get(i-1) hvilket betyder at den vil altid starte på 0
//        Derfor hvis man indtaster 1, så skal den vide at det er plads nummer 0 i arrayet.
        cycleweektochange=currentUser.getCycleweeklist().get(i-1);

//        Her vælges antal kørte kilometer til at ændre
        System.out.println("Vælg antal kørte kilometer: ");
        newkilometersdriven=input.nextDouble();
        cycleweektochange.setKilometersdriven(newkilometersdriven);



////        Her vælges antal kørte dage til at ændre
        System.out.println("Vælg antal kørte dage: ");
        newdaysdriven=inputCtrl.læsInputSomInt();
        cycleweektochange.setDaysdriven(newdaysdriven);

        // Her Ugenummeret man gerne vil ændre
        System.out.println("Vælg ugenummer: ");
        newweeknumber=inputCtrl.læsInputSomInt();
        cycleweektochange.setWeeknumber(newweeknumber);




    }


    public void deleteinformation() {
        int i = 1;
        //Tjek om der findes nogen cykelture
        if (currentUser.getCycleweeklist().size() == 0) {
            System.out.println("Du har ingen indtastede cykelture");
        } else {

            System.out.println("Dine Cykelture er: ");
            System.out.println("---------------------------------------------------------------------------------------------------");
            // Header i Cykelturvisning
            System.out.printf("%-10s %-20s %-30s %-40s \n", "Nr.", "Cykelturens antal kørte kilometer:", "Cykelturens antal kørte dage:","Cykelturens ugenummer:");
            System.out.println("---------------------------------------------------------------------------------------------------");
            for (Cycleweek cykeltur : currentUser.getCycleweeklist()) {
                System.out.printf("%-10d %-40.2f %-30d %-40d \n", i, cykeltur.getKilometersdriven(),cykeltur.getDaysdriven(),cykeltur.getWeeknumber());
                i++;
                System.out.println("---------------------------------------------------------------------------------------------------");
            }
        }
//        Her oprettes et objekt af Cycleweek klassen, hvorefter vi opretter et index der vil være det tal du indtaster for at slette noget.
        int index;
        Cycleweek cycleweektodelete;
        System.out.print("");
        System.out.println("Indtast nummeret på den cykeltur du gerne vil slette ");
        index=inputCtrl.læsInputSomInt();
        --index; // træk en fra antallet af cykelture
        cycleweektodelete=currentUser.getCycleweeklist().get(index);

        currentUser.getCycleweeklist().remove(cycleweektodelete);
        System.out.println("________________________________________");
        System.out.println("Cykelturen blev slettet fra dit register");
        System.out.println("________________________________________");
    }


    public void showInformationAboutOwnTeam() {

        System.out.println("---------------------------------------------------------------------------------------------------");

        System.out.println("\n ------___O");
        System.out.println("----_\\<,_");
        System.out.println("----_\\<,_           Nedenstående tabel viser forløbsoplysninger om dit hold");
        System.out.println("----(_)/(_)");


        System.out.println(" ");
        System.out.println(" ");

        System.out.printf("%-30s%-30s%-30s%-10s","Holdinformation", " Antallet af cyklede km på en uge " ," Kørselsdage" , " Ugenummer\n");
        System.out.println("------------------------------------------------------------------------------------------------------------");


        for(Team team:this.data.getTeams()){//initialiserer alle hold
            for(User user :team.getUsers()){// initialiserer alle holdmedlemmer på hvert hold
                if(user.equals(currentUser)){//tjekker hvilke hold medlemmer der er tilknyttet brugerens hold


                    System.out.println("Team name  " + team.getTeamName());
                    System.out.println("Team Leader  " + team.getTeamLeader());


                    System.out.println("---------------------------------------------------------------------------------------------------");

                    for(User member:team.getUsers()){//alle holdmedlemmer på hvert hold
                        for(Cycleweek cl :member.getCycleweeklist()){// Cykelforløb data hentes for hvert enkelt medlem på hold


                            System.out.printf("%-30s%-30s%-30s%-10s\n" , member.getName(), cl.getKilometersdriven(),cl.getDaysdriven(),cl.getWeeknumber());
                            System.out.println("---------------------------------------------------------------------------------------------------");

                    }

                }
            }
            }
        }
    }

    /* Created by Ahilan Selliah 18/11/2017

     */
    public void statisticsonkilometersanddays() {
        System.out.println("Statistik på cykelture");
        System.out.println("------------");
        Tuple resultatForBruger = GennemsnitForBruger(currentUser);
        System.out.println("Statestik for: " + currentUser.getName());
        System.out.println("Gennemsnitlig kørte km pr. dag: " + resultatForBruger.x);
        System.out.println("Gennemsnitlig kørte km pr. tur: " + resultatForBruger.y);
        System.out.println("------------");

        ArrayList brugerePåMitHold = new ArrayList<User>();
        for (User u : data.getUsers()) {
            if (u.getTeam().getTeamName() == currentUser.getTeam().getTeamName() && u.getUsername() != currentUser.getUsername()) {
                brugerePåMitHold.add(u);
                Tuple resultatForHoldbrugere = GennemsnitForBruger(u);
                System.out.println("Statestik for holdmedlem: " + u.getName());
                System.out.println("Gennemsnitlig kørte km pr. dag: " + resultatForHoldbrugere.x);
                System.out.println("Gennemsnitlig kørte km pr. tur: " + resultatForHoldbrugere.y);
                System.out.println();
            }
        }
    }

    private Tuple<Double, Double> GennemsnitForBruger(User user) {
        int antalkørtekilometer = 0;
        int antalkørtedage = 0;
        int antalcykelture = user.getCycleweeklist().size();
        for (Cycleweek c : user.getCycleweeklist()) {
            antalkørtekilometer += c.getKilometersdriven();
            antalkørtedage += c.getWeeknumber();
        }
        double gennemsnitkørtekmprtur = 0;
        double gennemsnitkørtekmprdag = 0;
        if (antalcykelture > 0 && antalkørtedage > 0) {
            gennemsnitkørtekmprtur = antalkørtekilometer / antalcykelture;
            gennemsnitkørtekmprdag = antalkørtekilometer / antalkørtedage;
        }
        return new Tuple<>(gennemsnitkørtekmprdag, gennemsnitkørtekmprtur);
    }
}