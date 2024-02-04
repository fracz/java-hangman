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


        while (lettersToGuess>=0) {
            printBoard(emptySpaces);
            System.out.println("Podaj literę: \n");
            char letter = getString().toUpperCase().charAt(0);
            if (lettersUsed.contains(letter)){
                while (lettersUsed.contains(letter)) {
                    System.out.println("Ta litera już wystąpiła. Spróbuj ponownie: ");
                    letter = getString().toUpperCase().charAt(0);
                }
            }
            lettersUsed.add(letter);

            for (int i = 0; i<wordLetters.length; i++) {
                char x = wordLetters[i];
                if  (letter == x) {
                    emptySpaces[i] = letter;
                    lettersToGuess --;
                }
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
}
