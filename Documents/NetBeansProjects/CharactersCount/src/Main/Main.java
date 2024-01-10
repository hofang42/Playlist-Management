/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controller.Algorithms;
import Controller.Validation;
import View.Menu;
import java.util.InputMismatchException;

/**
 *
 * @author hoang
 */
public class Main extends Menu {

    public Main() {
        super("Letter and character count. ", new String[]{"Characters Count & Word Count", "Exit"});
    }

    Algorithms al = new Algorithms();
    Validation valid = new Validation();

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                String str = valid.getString("Enter string");
                al.analyze(str);
                al.display();
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {
        while (true) {
            try {
                Main main = new Main();
                main.run();
            } catch (InputMismatchException e) {
                System.err.println("Please enter valid number !!!");
            }
        }

    }
}
