package pl.edu.agh.hangman;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Arrays;


import static pl.edu.agh.hangman.Hangman.HANGMANPICS;

public class Drawer {

    Scanner scanner = new Scanner(System.in);



    public void drawGameboard(String gameBoard, int lives){

        System.out.println(gameBoard);
        System.out.println(HANGMANPICS[HANGMANPICS.length - lives]);

    }

    public char userInput(){
        char inputChar = scanner.next().charAt(0);
        return inputChar;

    }

}
