package pl.edu.agh.hangman;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
public class Game {
    public String word;
    private String mask = "";
    public boolean gameIsWon = false;
    private ArrayList<String> wrongAttemps = new ArrayList<>();
    private ArrayList<String> properAttemps = new ArrayList<>();

    public Game(String word ){
        this.word = word;

    }
   public void start() {
       System.out.println("Zagraj w wisielca");
       printState();
       updateMask();

       while (wrongAttemps.size() < 6 && !gameIsWon) {
           performRound();

           if (isGameIsWon()) {
               break;
           }
       }
   }

   private void performRound() {
       String letter = askForInput();

       if (word.contains(letter)) {
           properAttemps.add(letter);
           System.out.println("Litera znajduje się w słowie");
       } else {
           wrongAttemps.add(letter);
           System.out.println("Litery nie ma w słowie");
       }

       updateMask();
       printState();

       if (isGameIsWon()) {
           printGameWon();
       }

       if (wrongAttemps.size() == 6) {
           printGameLost();
       }
   }

    private boolean isGameIsWon() {
        return !this.mask.contains("_");
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

    public void updateMask() {
        String newMask = "";

        for (int i = 0; i < word.length(); i++) {
            String letter = String.valueOf(word.charAt(i));
            if (properAttemps.contains(letter)) {
                newMask = newMask + letter;
            } else {
                newMask = newMask + "_ ";
            }
        }

        this.mask = newMask;
    }

    private void printGameLost(){
        System.out.println("");
        System.out.println("Przegrałeś! Słowo to: " + word);
        System.out.println("Czy chcesz spróbować jeszcze raz?");
    }

    private void printGameWon() {
        System.out.println("");
        System.out.println("Wygrałeś");
    }

    private void printState(){
        Print.printGameState(this.wrongAttemps.size());
        System.out.println("#### Słowo: ");
        System.out.print(this.mask);
    }

}
