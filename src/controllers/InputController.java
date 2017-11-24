package controllers;

//Created by Ahilan Selliah 17/11/2017
import java.util.Scanner;

public class InputController {
    Scanner input = new Scanner(System.in);

    public InputController() {
        this.input = new Scanner(System.in);
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
}
