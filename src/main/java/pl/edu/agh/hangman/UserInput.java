package pl.edu.agh.hangman;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public void showWelcomeMessage() {
        System.out.println("==========================");
        System.out.println("   WITAJ W GRZE HANGMAN   ");
        System.out.println("==========================");
        System.out.println("Zgaduj litery, aby odgadnąć hasło.");
        System.out.println();
    }

    public char getLetter() {
        while (true) {
            System.out.print("Podaj literę: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                return input.charAt(0);
            }

            System.out.println("Błąd — wpisz jedną literę.");
        }
    }
}
