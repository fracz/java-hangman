package pl.edu.agh.hangman;

import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) throws InterruptedException {
        WordProcessor wordProcessor = new WordProcessor();
        WordPrinter wordPrinter = new WordPrinter();
        System.out.println("Welcome to Hangman Game!\nNew game starts in:\n3...");
        Thread.sleep(1000);
        System.out.println("2...");
        Thread.sleep(1000);
        System.out.println("1...");
        Thread.sleep(1000);
        System.out.println("Find word!");
//        wordProcessor.randomizeNewWord();
        boolean gameOver = false;
        do {
//        wordPrinter.printGallows();
//        wordPrinter.printWordState();
         // boolean evaluate = wordProcessor.evaluateInput(getUserInput());
        //  wordPrinter.isCorrect(evaluate);
        // gameOver = continueGame(wordPrinter.getStatus());
        } while (!gameOver);


    }

    private static boolean continueGame(String printerOutput) {
        switch (printerOutput) {
            case "You have won" -> {
                System.out.println("Congratulations! You have won!");
                return true;
            }
            case "GAME OVER" -> {
                System.out.println("Game over!");
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    private static char getUserInput() {
        while (true) {
            System.out.println("Enter character");
            Scanner scanner = new Scanner(System.in);
            String userChar = scanner.nextLine();
            if (userChar.length() > 1) {
                System.out.println("Enter just one character!");
            } else if (userChar.length() == 1) {
                return userChar.toCharArray()[0];
            }
        }
    }
}
