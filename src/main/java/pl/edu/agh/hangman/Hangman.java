package pl.edu.agh.hangman;

import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    private String word;
    private String[] wordIntoTable = new String[]{};
    private String[] actualWord = new String[]{};

    public Hangman(String word){
        this.word = word;
    }


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

    public void run (){
        convertWordIntoTable();
        menu();
    }




    public void showHangmanpics (int picNumber){
        System.out.println(HANGMANPICS[picNumber]);
    }

    public void getWord(){
        System.out.println(word);
    }

    public void convertWordIntoTable (){

        this.wordIntoTable = new String[word.length()];
        this.actualWord = new String[word.length()];

        for (int i = 0; i < word.length(); i++) {
            wordIntoTable[i] = word.substring(i,i+1);
        }

        for (int i = 0; i < word.length(); i++) {

            if(wordIntoTable[i].equals(" ")){
                actualWord[i] = " - ";
            } else {
                actualWord[i] = " _ ";
            }
        }
    }

    public void getWordTable(){

        for (String letter: wordIntoTable) {
            System.out.print(letter + " ");
        }
        System.out.println("");

    }

    public void setActualWord (String guessLetter){

        for (int i = 0; i < word.length(); i++) {

            if (guessLetter.equals(wordIntoTable[i])){
                actualWord[i] = word.substring(i,i+1);

            }if(!actualWord[i].equals(" _ ")) {

            } else{
                actualWord[i] = " _ ";
            }
        }

    }

    public void getActualWord(){
        for (String letter: actualWord) {
            System.out.print(letter);
        }
    }

    public void menu(){

        int countTry = 0;

        while (countTry != 6){
            Scanner scanner = new Scanner(System.in);

            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("Proba: " + countTry + "/6               Odgadnij haslo ->   ");
            getActualWord();
            System.out.println("");
            System.out.println("     ");
            showHangmanpics(countTry);
            System.out.println("                         Wybierz opcję: (1) - podaj literę, (2) - zgaduj haslo, (6) - wyjdz");
            System.out.print("----------------------------------------------------------------------------------------------------------------------------------------");

            int optionNumber=0;

            try {
                optionNumber = scanner.nextInt(); scanner.nextLine();

            } catch (java.util.InputMismatchException e){
                System.out.println("Podaj jedna z dostepnych w MENU opcji !");
            }

            if(optionNumber != 1 && optionNumber != 2 && optionNumber != 6){
                    System.out.println("Nie ma takiej opcji w MENU !");
            }

            switch (optionNumber){

                case 1:

                    System.out.print("Podaj litere: ");
                    String letter = scanner.nextLine();
                    setActualWord(letter);

                    if(!checkIfCount(letter)){
                        countTry = countTry + 1;
                        System.out.println("NIE TRAFILES !");
                    }

                    if(countTry == 6){
                        System.out.print("PRZEGRALES !!!" + " Poprawne haslo to: " );
                        getWord();
                        System.out.print("----------------------------------------------------------------------------------------------------------------------------------------");
                    }

                    if(Arrays.equals(actualWord, wordIntoTable)){
                        countTry = 6;
                        System.out.println("WYGRALES !!!!");
                    }

                    break;

                case 2:

                    System.out.println("podaj haslo: ");
                    String haslo = scanner.nextLine();

                    if(haslo.equals(word)){
                        countTry = 6;
                        System.out.println("WYGRALES !!!!");
                    } else {
                        countTry = countTry + 1;
                    }

                    break;

                case 6:
                    countTry =6 ;

                    System.out.println("Dziekujemy za Twoją gre!");

                    break;

            }
        }
    }

    public boolean checkIfCount(String letter){

        for (String checkLetter: wordIntoTable) {
            if (checkLetter.equals(letter)){
                return true;
            }
        }
        return false;
    }
}
