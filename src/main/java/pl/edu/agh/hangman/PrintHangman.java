package pl.edu.agh.hangman;

import static pl.edu.agh.hangman.Hangman.HANGMANPICS;

public class PrintHangman {

    // Metoda rysująca hangmana,wybiera odpowiedni rysunek z tablicy
    //mistakes - liczba błędnych odpowiedzi gracza

    public static void drawHangman(int mistakes) {

        if (mistakes >= HANGMANPICS.length) {
            mistakes = HANGMANPICS.length - 1;
        }

        System.out.println(HANGMANPICS[mistakes]);
    }
}
