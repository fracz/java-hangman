package pl.edu.agh.hangman;

import java.util.Scanner;

public class InputFrom {

 // - ponizej sprawdzenie dzialania metody
//    public static  void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        char letter = wprowadzLitere(scanner);
//        System.out.println(letter);
//    }


    //funkcja zwracajaca wpisana litere przez uzytkownika
    public static char wprowadzLitere(Scanner scanner) {
        char letter = ' ';
        while (true) {
            System.out.print("Guess a letter: ");
            String input = scanner.nextLine();
            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                letter = input.charAt(0);
                break;
            } else {
                System.out.println("niepoprawny znak");
            }
        }
        return letter;
    }




}
