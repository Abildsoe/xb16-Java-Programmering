import java.util.Scanner;

public class HkController {

    private Data db;
    private Scanner input;
    private User currentUser;

    public HkController() {

        this.db = new Data();
        this.input = new Scanner(System.in);
        this.currentUser = null;

    }


    public void run() {

        String username;
        int password;

        while (currentUser == null) {

            input = new Scanner(System.in);

            System.out.println("Indtast venligst dit brugernavn:");
            username = input.nextLine();

            System.out.println("Indtast venligst din adgangskode:");
            password = input.nextInt();

            if (authUser(username, password)) {

                do {

                    showHoldkaptajnmenu();
                    int valg = input.nextInt();

                    switch (valg) {

                        case 1:
                            indberetOplysninger();
                            break;

                        case 2:
                            ændreindberettedeOplysninger();
                            break;

                        case 3:
                            sletOplysninger();
                            break;

                        case 4:
                            oplysningerpåenDeltager();
                            break;

                        case 5:
                            oplysningerpåegetHold();
                            break;

                        case 6:
                            statistikpåKmogkørselsdage();
                            break;

                        case 7:
                            visalleoplysningeromAllehold();
                            break;

                        case 8:
                            logUd();
                            break;
                    }
                }

                while (currentUser != null );

            }

            else { System.out.println("Du har indtastet forkert brugernavn\n"); }
        }
    }

    private boolean authUser(String username, int password) {

        for (User user : db.getUsers()) {

            if (username.equals(user.getUsername()) && password == user.getPassword()) {
                currentUser = user;
                return true;
            }
        }

        return false;
    }

    private void showHoldkaptajnmenu() {

        int valg;
        System.out.println("");
        System.out.println("Holdkaptajn Menu:");
        System.out.println("1) Indberetning af oplysninger om antal cyklede kilometer");
        System.out.println("2) Ændre indberettede oplysninger");
        System.out.println("3) Slet indberettede oplysninger");
        System.out.println("4) Vis alle oplysninger om en deltager");
        System.out.println("5) Vis alle oplysninger om eget hold");
        System.out.println("6) Vis en statistik over fordelingen af antal km og kørselsdage på hold");
        System.out.println("7) Vis alle oplysninger om alle hold");
        System.out.println("8) Log ud af systemet");
        System.out.print("vælg et menupunkt: ");
    }

    private void indberetOplysninger() {

        int  antalkørtekilometer;
        int antalkørtedage;

        System.out.println("Indtast antal kørte kilometer:");
        antalkørtekilometer = input.nextInt();

        System.out.println("Indtast antal kørselsdage:");
        antalkørtedage = input.nextInt();

        currentUser.setAntalkørtekilometer(antalkørtekilometer);
        currentUser.setAntalkørtedage(antalkørtedage);

        System.out.println("Du har indtastet følgende oplysninger");
        System.out.println("Antal kørte kilometer: " + antalkørtekilometer);
        System.out.println("Antal kørte dage: " + antalkørtedage + "\n");

    }

    private void ændreindberettedeOplysninger() { }

    private void sletOplysninger() {


    }

    private void oplysningerpåenDeltager() { }

    private void oplysningerpåegetHold() { }

    private void statistikpåKmogkørselsdage() { }

    private void visalleoplysningeromAllehold() { }

    private void logUd() {

        System.out.println("Du er nu logget ud, tak for besøget\n");

        HkController hKcontroller= new HkController();
        hKcontroller.run();

    }
}

