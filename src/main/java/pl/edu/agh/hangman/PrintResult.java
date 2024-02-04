package pl.edu.agh.hangman;

import static pl.edu.agh.hangman.Hangman.*;

public class PrintResult {

    public static void printResult(int level, String word) {

        StringBuilder stringBuilder = new StringBuilder(HANGMANPICS[level]);
        stringBuilder.insert(31, "\t" + word);

        /*if(level != 6 && word != "prawnik") {
            System.out.println(HANGMANPICS[level]);
            System.out.println("guess>");
        }

        if (level == 6) {
            System.out.println(HANGMANPICS[level]);
            System.out.println(GAMELOSE);

        }

        if (level !=6 && word == "prawnik") {
            System.out.println(HANGMANPICS[level]);
            System.out.println(GAMEWIN);

        }*/

        System.out.println(stringBuilder);

    }
}