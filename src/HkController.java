import java.util.ArrayList;
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
                            //visalleoplysningeromAllehold();
                            visalleoplysningeromAllehold();
                            break;

                        case 8:
                            logUd();
                            break;

                        default:
                            break;
                    }
                } while (currentUser != null);


            } else {
                System.out.println("\nDu har indtastet forkert brugernavn");
            }
        }
    }

    private void indberetOplysninger() {

        int antalkørtekilometer;
        int antalkørtedage;
        int i = currentUser.getAntalkørtedage();
        int a = currentUser.getAntalkørtekilometer();

        System.out.println("Indtast antal kørte kilometer:");
        antalkørtekilometer = input.nextInt();
        a += antalkørtekilometer;
        currentUser.setAntalkørtekilometer(a);

        System.out.println("Indtast antal kørselsdage:");
        antalkørtedage = input.nextInt();
        //currentUser.setAntalkørtekilometer(antalkørtekilometer);
        i += antalkørtedage;
        currentUser.setAntalkørtedage(i);

        System.out.println("Du har indtastet følgende oplysninger:\nKilometer: " + currentUser.getAntalkørtekilometer() + "\nAntal kørselsdage: " + currentUser.getAntalkørtedage());

    }

    private void ændreindberettedeOplysninger() { }

    private void sletOplysninger() { }

    //private void oplysningerpåenDeltager() {

    //    System.out.println("\n1)Deltager: " + currentUser.getUsername() + "\n2)Brugertype:" + currentUser.getType() + "\n3)Brugerens hold: "
    //            + currentUser.getHoldid() + "\n4)Brugerens indtastede kilometer: " + currentUser.getAntalkørtekilometer() + "\n5)Brugerens indtastede antal kørte dage: " + currentUser.getAntalkørtedage());

    //}

    private void oplysningerpåegetHold() { }

    private void statistikpåKmogkørselsdage() { }

    public void visalleoplysningeromAllehold() {
        Data data = new Data();
        ArrayList<User> users = data.getUsers();

        System.out.println("\nDeltager: " + data.getUsers());
    }

    private void logUd() {

        System.out.println("Du er nu logget ud af systemet, hvis du har lyst kan du logge ind igen eller på en anden bruger - tak for i dag.\n");
        HkController hkController = new HkController();
        hkController.run();
    }

    private void showHoldkaptajnmenu() {
        int valg;
        System.out.println("");
        System.out.println("Holdkaptajn Menu:");
        System.out.println("1) Indberetning af oplysninger om antal cyklede kilometer ");
        System.out.println("2) Ændre indberettede oplysninger");
        System.out.println("3) Slet indberettede oplysninger ");
        System.out.println("4) Vis alle oplysninger om en deltager");
        System.out.println("5) Vis alle oplysninger om eget hold");
        System.out.println("6) Vis en statistik over fordelingen af antal km og kørselsdage på hold");
        System.out.println("7) Vis alle oplysninger om alle hold");
        System.out.println("8) Log ud af systemet");
        System.out.println("vælg et menupunkt: ");
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

    //public void printInfo(){
    //    for(int i = 0; i<db.getUsers().size(); i++){

    //           System.out.println(db.getUsers().get(i).getUsername());
    //        System.out.println("Har kørt: " + db.getUsers().get(i).getAntalkørtekilometer() + );


        }
    //}
//}


