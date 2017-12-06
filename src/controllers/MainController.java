//http://www.chris.com/ascii/index.php?art=transportation%2Fbicycles - koden til de 5 cykler er fundet her
package controllers;

import data.Data;
import model.Team;
import model.User;
import model.UserType;

import java.util.Scanner;

public class MainController {
    private Data db;
    private User currentUser;
    private MemberController userCtrl;
    private Scanner input;

    public MainController() {
        this.currentUser = null;
        this.db = new Data();
        this.input = new Scanner(System.in);
    }

    public void run() {
        String username;
        int password;

        while (true) {
            System.out.println("Velkommen:");
            System.out.println("\n" +
                    " -------- __@      __@       __@       __@      __~@\n" +
                    " ----- _`\\<,_    _`\\<,_    _`\\<,_     _`\\<,_    _`\\<,_\n" +
                    " ---- (*)/ (*)  (*)/ (*)  (*)/ (*)  (*)/ (*)  (*)/ (*)\n" +
                    " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                    "\n");
            System.out.println("1) Login ");
            System.out.println("2) Opret bruger");
            int x = læsInputSomInt();

            if (x == 2) {
                opretBruger();
            } else if (x == 1) {


                System.out.println("Indtast venligst dit brugernavn:");
                username = læsInputSomString();

                System.out.println("Indtast venligst din adgangskode:");
                password = læsInputSomInt();

                if (authUser(username, password)) {
                    if (currentUser.getType() == UserType.Holdkaptajn) {
                        userCtrl = new LeaderController(currentUser, input, db);
                    } else {
                        userCtrl = new MemberController(currentUser, input, db);
                    }

                    do {
                        userCtrl.showUserMenu();
                        int valg = læsInputSomInt();

                        switch (valg) {

                            case 1:
                                userCtrl.reportinformation();
                                break;

                            case 2:
                                userCtrl.changereportedinformation();
                                break;

                            case 3:
                                userCtrl.deleteinformation();
                                break;


                            case 4:
                                userCtrl.showInformationAboutOwnTeam();
                                break;

                            case 5:
                                userCtrl.statisticsonkilometersanddays();
                                break;

                            case 6:
                                if (currentUser.getType() != UserType.Holdkaptajn) {
                                    System.out.println("Ugyldigt valg");
                                } else {
                                    ((LeaderController) userCtrl).showallinformationaboutEveryTeam();
                                }
                                break;

                            case 7:
                                logUd();
                                break;

                            default:
                                System.out.println("Ugyldigt valg");
                                break;
                        }
                    } while (currentUser != null);


                } else {
                    System.out.println("\nDu har indtastet forkert brugernavn eller password");
                }
            } else {
                System.out.println("Prøv igen");
                System.out.println();
            }
        }
    }

    //Created by Ahilan Selliah 17/11/2017
    private void opretBruger() {
        String username;
        int password;
        System.out.println("Opret bruger");
        System.out.println("Indtast fulde navn");
        String navn = læsInputSomString();
        System.out.println("Indtast venligst det ønskede brugernavn:");
        username = læsInputSomString();
        for (User u : this.db.getUsers()) {
            if (username.equals(u.getUsername())) {
                System.out.println("Brugernavn er allerede taget");
                opretBruger();
                break;
            }
        }

        System.out.println("Indtast venligst din adgangskode:");
        password = læsInputSomInt();
        System.out.println("Team navne og team id");
        for (Team t : db.getTeams()) {
            System.out.println(t.getTeamName() + ": " + t.getTeamID());

        }
        System.out.println("Indtast venligst dit teams id:");
        int teamId = læsInputSomInt();
        Team team = null;
        for (Team t : db.getTeams()) {
            if (t.getTeamID() == teamId) {
                team = t;
                break;
            }
        }

        User ny = new User(username, password, navn, UserType.User);
        db.getUsers().add(ny);
        team.addUser(ny);
        System.out.println("Brugeren er oprettet, velkommen!\n");
        System.out.println("------------------------------------------------------------------------------\n");

    }

    private boolean authUser(String username, int password) {
        for (User user : db.getUsers()) {

            if (username.equals(user.getUsername()) && password == user.getPassword()) {
                currentUser = user;
                System.out.println("\nVelkommen " + currentUser.getName());
                System.out.println("--------------------------------------------------------");
                return true;
            }
        }

        return false;
    }

    public String læsInputSomString() {
        return this.input.nextLine();
    }

    public int læsInputSomInt() {
        try {
            String str = læsInputSomString();
            return Integer.parseInt(str);
        } catch (Exception e) {
            System.out.println("Prøv igen med et tal i stedet!");
            return læsInputSomInt();
        }

    }

    private void logUd() {

        System.out.println("Du er nu logget ud af systemet, hvis du har lyst kan du logge ind igen eller på en anden bruger - tak for i dag.\n");
        currentUser = null;
    }
}




