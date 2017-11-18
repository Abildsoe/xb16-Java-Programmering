package controllers;

import data.Data;
import model.User;

public class LeaderController extends MemberController {


    public LeaderController(User currentUser, InputController inputCtrl, Data data) {
        super(currentUser, inputCtrl, data);
    }


    public void visalleoplysningeromAllehold() {
//        for(int i = 0; i<db.getUsers().size(); i++){
//
//            System.out.println("Navn: " + db.getUsers().get(i).getName() + "Kørte km" + db.get;
//        }
//
    }


    public void showUserMenu() {
        int valg;
        System.out.println("");
        System.out.println("Holdkaptajnmenu:");
        System.out.println("1) Indberetning af cykelture");
        System.out.println("2) Ændre cykelture");
        System.out.println("3) Slet cykelture");
        System.out.println("4) Vis alle oplysninger om en deltager");
        System.out.println("5) Vis alle oplysninger om eget hold");
        System.out.println("6) Vis en statistik over gennemsnitlige kørte km");
        System.out.println("7) Vis alle oplysninger om alle hold");
        System.out.println("8) Log ud af systemet");
        System.out.println("vælg et menupunkt: ");
    }


//    public void printInfo(){
//        for(int i = 0; i<db.getUsers().size(); i++){
//
//            System.out.println(db.getUsers().get(i).getUsername());
//            System.out.println("Har kørt: " + db.getUsers().get(i).getAntalkørtekilometer() + );


//        }
}

