package pl.edu.agh.hangman;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Guess {

    public void guess (String word) {
        char[] wordLetters = word.toCharArray();
        char[] emptySpaces = generateEmptySpaces(word);
        int lettersToGuess = word.length();
        Set<Character> lettersUsed = new HashSet<>();
        Hangman hangman = new Hangman();
        int life = hangman.HANGMANPICS.length;

        while (lettersToGuess>=0) {
            System.out.println();
            printBoard(emptySpaces);
            System.out.print("Podaj literę: ");
            char letter = getString().toUpperCase().charAt(0);
            if (lettersUsed.contains(letter)){
                while (lettersUsed.contains(letter)) {
                    System.out.println("Ta litera już wystąpiła. Spróbuj ponownie: ");
                    letter = getString().toUpperCase().charAt(0);
                }
            }
            lettersUsed.add(letter);

            int LetterToGuessBefore = lettersToGuess;

            for (int i = 0; i<wordLetters.length; i++) {
                char x = wordLetters[i];
                if  (letter == x) {
                    emptySpaces[i] = letter;
                    lettersToGuess --;
                }
            }
            int LetterToGuessAfter = lettersToGuess;

            if (LetterToGuessBefore == LetterToGuessAfter) {
                life --;
                lose(life);
                System.out.println("Zła litera, straciłeś życie. Pozostało Ci " + life + " żyć");
            }
            if (life == 0) {
                System.out.println("Przegrałeś!");
                System.out.println("Słowo do odgadnięcia to: " + word);
                break;
            } else if (lettersToGuess == 0) {
                System.out.println("Gratulacje, wygrałeś!");
                System.out.println("Odgadnięte słowo to: " + word);
                break;
            }
        }
    }

    public char[] generateEmptySpaces (String word) {
        char[] emptySpace = new char[word.length()];

        for (int i = 0; i<emptySpace.length; i++) {
            emptySpace[i] = '_';
        }
        return emptySpace;
    }

    public String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printBoard (char[] board) {
        for (int i = 0; i<board.length; i++) {
            System.out.print(board[i] + " ");
        }
    }
    public void lose (int life){
        Hangman hangman = new Hangman();
        String[] stage = hangman.HANGMANPICS;
        System.out.println(stage[6-life]);
    }
}
