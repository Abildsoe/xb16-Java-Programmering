package controllers;

import data.Data;
import model.Team;
import model.User;
import model.UserType;

import java.util.Scanner;

public class MainController {
    private Data db;
    private User currentUser;
    private ParticipantController userCtrl;
    private Scanner input;

    public MainController() {
        this.currentUser = null;
        this.db = new Data();
        this.input = new Scanner(System.in);
    }

    public void run() {
        String username;
        int password;

        //http://www.chris.com/ascii/index.php?art=transportation%2Fbicycles - koden til de 5 cykler er fundet her
        while (true) {
            System.out.println("Velkommen:");
            System.out.println("\n" +
                    " -------- __@      __@       __@       __@      __~@\n" +
                    " ----- _`\\<,_    _`\\<,_    _`\\<,_     _`\\<,_    _`\\<,_\n" +
                    " ---- (*)/ (*)  (*)/ (*)  (*)/ (*)  (*)/ (*)  (*)/ (*)\n" +
                    " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                    "\n");
            System.out.println("1) Login ");
            System.out.println("2) Opret deltager");
            int x = readInputAsInt();

            if (x == 2) {
                createParticipant();
            } else if (x == 1) {


                System.out.println("Indtast venligst dit brugernavn:");
                username = readInputAsString();

                System.out.println("Indtast venligst din adgangskode:");
                password = readInputAsInt();
                // Hvis man logger ind med brugernavn og password til holdkaptajn opfanges det i denne if else statement
                if (authUser(username, password)) {
                    if (currentUser.getType() == UserType.Leader) {
                        userCtrl = new LeaderController(currentUser, input, db);
                    } else {
                        userCtrl = new ParticipantController(currentUser, input, db);
                    }

                    do {
                        userCtrl.showParticipantMenu();
                        int valg = readInputAsInt();
                        // Vores switch til navigering i programmet hovedmenu
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
                                if (currentUser.getType() != UserType.Leader) {
                                    System.out.println("Ugyldigt valg\n");
                                } else {
                                    ((LeaderController) userCtrl).statisticsonkilometersanddays();
                                }
                                break;

                            case 6:
                                if (currentUser.getType() != UserType.Leader) {
                                    System.out.println("Ugyldigt valg\n");
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

    //Opret en deltager
    private void createParticipant() {
        String username;
        int password;
        System.out.println("Opret deltager");
        System.out.println("Indtast fulde navn");
        String navn = readInputAsString();
        System.out.println("Indtast venligst det ønskede brugernavn:");
        username = readInputAsString();
        for (User u : this.db.getUsers()) {
            if (username.equals(u.getUsername())) {
                System.out.println("Brugernavn er allerede taget\n");
                createParticipant();
                break;
            }
        }

        System.out.println("Indtast venligst din adgangskode:");
        password = readInputAsInt();
        System.out.println("Team navne og team id");
        for (Team t : db.getTeams()) {
            System.out.println(t.getTeamName() + ": " + t.getTeamID());

        }
        System.out.println("Indtast venligst dit teams id:");
        int teamId = readInputAsInt();
        Team team = null;
        for (Team t : db.getTeams()) {
            if (t.getTeamID() == teamId) {
                team = t;
                break;
            }
        }

        User ny = new User(username, password, navn, UserType.Participant);
        db.getUsers().add(ny);
        team.addUser(ny);
        System.out.println("Deltageren er oprettet, velkommen!\n");
        System.out.println("------------------------------------------------------------------------------\n");

    }
//Boolean bruger til at autorisere username og password ved indlogning
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

//Bruges til at læse hele input fra skanneren og returnere variablen
    private String readInputAsString() {
        return this.input.nextLine();
    }
//Try catch for en integer
    private int readInputAsInt() {
        try {
            String str = readInputAsString();
            return Integer.parseInt(str);
        } catch (Exception e) {
            System.out.println("Prøv igen med et tal i stedet!");
            return readInputAsInt();
        }

    }
//Log ud funktion
    private void logUd() {

        System.out.println("Du er nu logget ud af systemet, hvis du har lyst kan du logge ind igen eller på en anden bruger - tak for i dag.\n");
        currentUser = null;
    }
}




