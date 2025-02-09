package pl.edu.agh.hangman;

import java.util.Scanner;

//Obsługuje wejście użytkownika, np. zgadywanie liter.
public class UserInput {
    private final Scanner scanner = new Scanner(System.in);

    public char guess() {
        System.out.print("Podaj literę: ");
        return scanner.next().toUpperCase().charAt(0);
    }
}
