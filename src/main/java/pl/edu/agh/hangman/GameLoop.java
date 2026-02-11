package pl.edu.agh.hangman;

import java.util.Scanner;

import static jdk.jfr.internal.test.DeprecatedMethods.counter;

public class GameLoop {

    public GameLoop() {
        boolean flag = false;
        int counter = 0;
        drawHangman(counter);
        do{

            Scanner input = new Scanner(System.in);
            System.out.println("Podaj znak:");
            char nextChar = input.next().charAt(0);

            String userSentence =

            if(machSentence == userSentence){
                flag=true;
            }else{
                counter++;
                drawHangman(counter);
            }
        }while(flag == flase);

    }
}
