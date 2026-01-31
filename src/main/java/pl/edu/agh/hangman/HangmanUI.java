package pl.edu.agh.hangman;

import java.util.Scanner;

public class HangmanUI {

    private final Scanner scanner;

    public HangmanUI() {
        this.scanner = new Scanner(System.in);
    }

    public void Welcome(){
        System.out.println("Witamy w grze w wisielca");
        System.out.println("Podaj proszę swoją pierwszą literę: ");
        scanner.next();
    }

    public void NextLetter(){
        System.out.println("Podaj kolejną literę: ");
        scanner.next();
    }

}
