package pl.edu.agh.hangman;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Hangman {

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

    public static void main(String[] args) {
        WordCrypter wordCrypter = new WordCrypter("kretoszczur");

        //System.out.println(wordCrypter.cryptWord().length());
        System.out.println("kretoszczur".length());
        System.out.println("WITAJ W GRZE WIESIELEC!!!");
        System.out.println("Poniżej wyświetla się zakodowane słowo");
        System.out.println(wordCrypter.cryptWord());
        HangManPrinter hangManPrinter = new HangManPrinter(HANGMANPICS);
        WordChecker wordChecker = new WordChecker("kretoszczur", wordCrypter.cryptWord());
        while (wordChecker.getHP() > 0 && wordChecker.getNumberOfLettersToGuess() > 0) {
            System.out.println("Podaj literkę: ");
            Scanner scan = new Scanner(System.in);
            String choosenLetter = scan.nextLine();
            if (wordChecker.checkIfLetterUsedBefore(choosenLetter)) {
                System.out.println("Już użyłeś tej litery!!!");
            } else {
                wordChecker.checkUserChoice(choosenLetter);
                System.out.println("Pozostało Ci " + wordChecker.getHP() + " HP");
                System.out.println("Pozostało Ci " + wordChecker.getNumberOfLettersToGuess() + " słow do odgadnięcia");
                hangManPrinter.printHangMan(wordChecker.getHP());
                System.out.println(wordChecker.getWordCrypted());
            }
        }

    }
}
