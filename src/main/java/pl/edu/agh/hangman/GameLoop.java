package pl.edu.agh.hangman;

import java.util.Scanner;

public class GameLoop {
    public GameLoop() {
        boolean flag = false;
        do{
            Scanner input = new Scanner(System.in);
            System.out.println("Podaj znak:");
            char nextChar = input.next().charAt(0);

            String userSentence =

            if(machSentence == userSentence){
                flag=true;
            }
        }while(flag == flase);

    }
}
