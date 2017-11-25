package controllers;

import data.Data;
import model.CykelTur;
import model.Team;
import model.Tuple;
import model.User;
import java.util.Scanner;
import java.util.ArrayList;

public class MemberController {

    InputController inputCtrl;
    protected User currentUser;
    protected Data data;

    public MemberController(User currentUser, InputController inputCtrl, Data data) {
        this.currentUser = currentUser;
        this.inputCtrl = inputCtrl;
        this.data = data;
    }


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

    public void indberetOplysninger() {

        int antalkørtekilometer, antalkørtedage;

        System.out.println("Indtast antal kilometer");
        antalkørtekilometer = inputCtrl.læsInputSomInt();

        System.out.println("Indtast antal kørselsdage");
        antalkørtedage = inputCtrl.læsInputSomInt();
        System.out.println("Du har indtastet følgende oplysninger: "+"\nAntal kørte kilometer: "+antalkørtekilometer+"\nAntal kørte dage: "+antalkørtedage);

        System.out.println();

        CykelTur cykelTur = new CykelTur(antalkørtekilometer, antalkørtedage);
        this.currentUser.addcykeltur(cykelTur);


    }

    public void ændreindberettedeOplysninger() {
        int index=1;
//        Tjek om der findes nogen cykelture der kan ændres
        if(currentUser.getCykelturliste().size()==0){
            System.out.println("Du har ingen cykelture du kan ændre");
        } else{
            System.out.println("_________________________________________________________________________________");
            System.out.println("Nedenstående kan du se de cykelture du kan ændre: ");

//            Header i de Cykelture man kan ændre
            System.out.printf("%-10s %-40s %-30s \n","Nr.", "Cykelturens antal kørte kilometer;", "Cykelturens antal kørte dage: ");
            for(CykelTur cykeltur: currentUser.getCykelturliste()){
                System.out.printf("%-10d %-40d %-30d \n",index,cykeltur.getAntalkørtekilometer(),cykeltur.getAntalkørtedage());
                index++;
                System.out.println("_________________________________________________________________________________");
            }

        }
        int i;
        int nyantalkørtekilometer;
        int nyantalkørselsdage;
        CykelTur cykelturToændre;
        System.out.print("");
        System.out.println("Indtast nummeret på den cykeltur du gerne vil ændre ");
        i=inputCtrl.læsInputSomInt();

        cykelturToændre=currentUser.getCykelturliste().get(i-1);

//        Her vælges antal kørte kilometer til at ændre
        System.out.println("Vælg antal kørte kilometer: ");
        nyantalkørtekilometer=inputCtrl.læsInputSomInt();
        cykelturToændre.setAntalkørtekilometer(nyantalkørtekilometer);



////        Her vælges antal kørte dage til at ændre
        System.out.println("Vælg antal kørte dage: ");
        nyantalkørselsdage=inputCtrl.læsInputSomInt();
        cykelturToændre.setAntalkørtedage(nyantalkørselsdage);


    }


    public void sletOplysninger() {
        int i = 1;
        //Tjek om der findes nogen cykelture
        if (currentUser.getCykelturliste().size() == 0) {
            System.out.println("Du har ingen indtastede cykelture");
        } else {

            System.out.println("Dine Cykelture er: ");
            System.out.println("_________________________________________________________________________________");
            // Header i Cykelturvisning
            System.out.printf("%-10s %-40s %-30s \n", "Nr.", "Cykelturens antal kørte kilometer:", "Cykelturens antal kørte dage:");
            System.out.println("_________________________________________________________________________________");
            for (CykelTur cykeltur : currentUser.getCykelturliste()) {
                System.out.printf("%-10d %-40d %-30d \n", i, cykeltur.getAntalkørtekilometer(), cykeltur.getAntalkørtedage());
                i++;
                System.out.println("_________________________________________________________________________________");
            }
        }
        int index;
        CykelTur cykelturToDelete;
        System.out.print("");
        System.out.println("Indtast nummeret på den cykeltur du gerne vil slette ");
        index=inputCtrl.læsInputSomInt();
        --index; // træk en fra antallet af cykelture
        cykelturToDelete=currentUser.getCykelturliste().get(index);

        currentUser.getCykelturliste().remove(cykelturToDelete);
        System.out.println("________________________________________");
        System.out.println("Cykelturen blev slettet fra dit register");
        System.out.println("________________________________________");
    }

    public void oplysningerpåenDeltager() {
        int antalkørtekm = 0;
        int antalkøretdage = 0;
        for (CykelTur cykelTur : currentUser.getCykelturliste()) {
            antalkørtekm += cykelTur.getAntalkørtekilometer();

        }
        System.out.println("\n1)Deltager: " + currentUser.getUsername() + "\n2)Brugertype:" + currentUser.getType() +
                "\n3)Brugerens hold: "
                + currentUser.getTeam().getTeamID() +
                "\n4)Brugerens indtastede kilometer: "
                + currentUser.getCykelturliste().get(0).getAntalkørtekilometer() +
                "\n5)Brugerens indtastede antal kørte dage: " + currentUser.getCykelturliste().get(0).getAntalkørtedage());
    }

    public void oplysningerpåegetHold() {
        int i = 0;
        for (Team team : this.data.getTeams()) { // alle hold
            for (User user : team.getUsers()) {// alle holdmedlemmer på hvert hold
                if (user.equals(currentUser)) { // tjekker om alle brugere i listen, er tilknyttet det samme hold id som currentuser

                    System.out.println(team.getTeamName());

                    for (User member : team.getUsers()) {
                        System.out.println(member.getName());
                    }
                }
            }
        }
    }

    /* Created by Ahilan Selliah 18/11/2017

     */
    public void statistikpåKmogkørselsdage() {
        System.out.println("Statistik på cykelture");
        System.out.println("------------");
        Tuple resultatForBruger = GennemsnitForBruger(currentUser);
        System.out.println("Statestik for: " + currentUser.getName());
        System.out.println("Gennemsnitlig kørte km pr. dag: " + resultatForBruger.x);
        System.out.println("Gennemsnitlig kørte km pr. tur: " + resultatForBruger.y);
        System.out.println("------------");

        ArrayList brugerePåMitHold = new ArrayList<User>();
        for (User u : data.getUsers()) {
            if (u.getTeam().getTeamID() == currentUser.getTeam().getTeamID() && u.getUsername() != currentUser.getUsername()) {
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
        int antalcykelture = user.getCykelturliste().size();
        for (CykelTur c : user.getCykelturliste()) {
            antalkørtekilometer += c.getAntalkørtekilometer();
            antalkørtedage += c.getAntalkørtedage();
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