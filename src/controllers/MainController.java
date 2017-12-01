//http://www.chris.com/ascii/index.php?art=transportation%2Fbicycles - koden til de 5 cykler er fundet her
package controllers;

import data.Data;
import model.Team;
import model.User;
import model.UserType;

public class MainController {
    private Data db;
    private User currentUser;
    private MemberController userCtrl;
    private InputController inputCtrl;

    public MainController() {
        this.currentUser = null;
        this.db = new Data();
        this.inputCtrl = new InputController();
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
            int x = inputCtrl.læsInputSomInt();

            if (x == 2) {
                opretBruger();
            } else {


                System.out.println("Indtast venligst dit brugernavn:");
                username = inputCtrl.læsInputSomString();

                System.out.println("Indtast venligst din adgangskode:");
                password = inputCtrl.læsInputSomInt();

                if (authUser(username, password)) {
                    if (currentUser.getType() == UserType.Holdkaptajn) {
                        userCtrl = new LeaderController(currentUser, inputCtrl, db);
                    } else {
                        userCtrl = new MemberController(currentUser, inputCtrl, db);
                    }

                    do {
                        userCtrl.showUserMenu();
                        int valg = inputCtrl.læsInputSomInt();

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
            }
        }
    }

    //Created by Ahilan Selliah 17/11/2017
    private void opretBruger() {
        String username;
        int password;
        System.out.println("Opret bruger");
        System.out.println("Indtast fulde navn");
        String navn = inputCtrl.læsInputSomString();
        System.out.println("Indtast venligst det ønskede brugernavn:");
        username = inputCtrl.læsInputSomString();
        for (User u : this.db.getUsers()) {
            if (username.equals(u.getUsername())) {
                System.out.println("Brugernavn er allerede taget");
                opretBruger();
                break;
            }
        }

        System.out.println("Indtast venligst din adgangskode:");
        password = inputCtrl.læsInputSomInt();
        System.out.println("Team navne og team id");
        for (Team t : db.getTeams()) {
            System.out.println(t.getTeamName() + ": " + t.getTeamID());

        }
        System.out.println("Indtast venligst dit teams id:");
        int teamId = inputCtrl.læsInputSomInt();
        Team team = null;
        for (Team t : db.getTeams()) {
            if (t.getTeamID() == teamId) {
                team = t;
                break;
            }
        }

        User ny = new User(username, password, navn, UserType.User);
        db.getUsers().add(ny);
        System.out.println("Brugeren er oprettet, velkommen!");
    }

    private boolean authUser(String username, int password) {
        for (User user : db.getUsers()) {

            if (username.equals(user.getUsername()) && password == user.getPassword()) {
                currentUser = user;
                System.out.println("Velkommen " + currentUser.getName());
                return true;
            }
        }

        return false;
    }

    private void logUd() {

        System.out.println("Du er nu logget ud af systemet, hvis du har lyst kan du logge ind igen eller på en anden bruger - tak for i dag.\n");
        currentUser = null;
    }
}




