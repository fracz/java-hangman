package pl.edu.agh.hangman;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
public class Gra{
    public String word;

    public boolean gameIsWon = false;
    private int counter = 0;

   private ArrayList<String> attempts = new ArrayList<>(); // lista wprowadzonych liter
    private ArrayList<String> guessedLetters = new ArrayList<>(); // lista odgadniętych liter

    public static final String[] HANGMANPICS = new String[]{
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };
    public Gra(String word ){
        this.word=word;

    }
   public void start() {
       System.out.println("Zagraj w wisielca");
       printState();

       while (attempts.size() < 6 && !gameIsWon) {
            performRound();
        }

       if (!gameIsWon) {
           System.out.println("");
           System.out.println("Przegrałeś");
           System.out.println("Czy chcesz spróbować jeszcze raz? Wpisz tak");

       }
   }

   private void performRound() {
       String letter = askForInput();

       if (word.contains(letter)) {
           guessedLetters.add(letter);
           System.out.println("Litera znajduje się w słowie");
       } else {
           System.out.println("Litery nie ma w słowie");
           attempts.add(letter);
           counter++;
       }

       if (checkIfGameIsWon()) {
           gameIsWon = true;
           System.out.println("Wygrałęś");
       }
       printState();
   }

    private boolean checkIfGameIsWon() {
        boolean gameIsWon = true;
        ArrayList<String> letters = new ArrayList<>();
        for (int i = 0;i < word.length(); i++){
            letters.add(String.valueOf(word.charAt(i)));
        }

        for (String letter : letters) {
            if (!guessedLetters.contains(letter)) {
                gameIsWon = false;
                break;
            }
        }
        return gameIsWon;
    }

    private void gameWon() {
        System.out.println("Wygrałeś");
    }

   private boolean checkIfIsLetter(String letter) {
        return letter.length() == 1;
   }

   private String askForInput() {
       Scanner myObj = new Scanner(System.in);
       System.out.println("");
       System.out.println("Podaj literę");

       String letter = myObj.nextLine();

       while(!checkIfIsLetter(letter)) {
           System.out.println("Litera niepoprawna");
           System.out.println("Podaj literę");

           letter = myObj.nextLine();
       }

       return letter.toUpperCase(Locale.ROOT);
   }
    private void printState(){
       System.out.println(HANGMANPICS[counter]);
       System.out.println("#### Słowo: ");

        ArrayList<String> letters = new ArrayList<>();
        for (int i = 0;i < word.length(); i++){
            letters.add(String.valueOf(word.charAt(i)));
        }

        for (String letter : letters) {
            if (guessedLetters.contains(letter)) {
                System.out.print(letter);
            } else {
                System.out.print(" _ ");
            }
        }
    }
}
