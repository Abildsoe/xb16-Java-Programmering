import java.util.Scanner;

public class UserController {

    Scanner input = new Scanner(System.in);

    public UserController() {

    }

    public void showUserMenu() {

        int valg;
        System.out.println("User Menu:");
        System.out.println("1) Indberetning af oplysninger om antal cyklede kilometer ");
        System.out.println("2) Ændre indberettede oplysninger");
        System.out.println("3) Slet indberettede oplysninger ");
        System.out.println("4) Vis alle oplysninger om en deltager");
        System.out.println("5) Vis alle oplysninger om eget hold");
        System.out.println("6) Vis en statistik over fordelingen af antal km og kørselsdage på hold");
        System.out.println("7) Log ud af systemet");

        valg = input.nextInt();

        switch (valg) {

            case 1:
                System.out.println("Du har valgt at indberette oplysninger om antal cyklede kilometer ");
                break;

            case 2:
                System.out.println("Du har valgt at ændre indberettede oplysninger ");
                break;

            case 3:
                System.out.println("Du har valgt at slette indberettede oplysninger  ");
                break;

            case 4:
                System.out.println("Du har valgt at vise alle oplysninger om en deltager ");
                break;

            case 5:
                System.out.println("Du har valgt at vise alle oplysninger om eget hold");
                break;

            case 6:
                System.out.println("Du har valgt at vise en statistik over fordelingen af antal km og kørselsdage på hold ");
                break;

            case 7:
                System.out.println("Du har valgt at logge ud af systemet ");
                break;


        }
    }
}