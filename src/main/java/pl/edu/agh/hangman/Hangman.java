package pl.edu.agh.hangman;

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

    public void showHangmanpics (){

        for (String hangPic: HANGMANPICS) {
            System.out.println(hangPic);
        }
    }

    public void getWord(){
        System.out.println(word);
    }



    public void convertWordIntoTable (){

        this.wordIntoTable = new String[word.length()];
        this.actualWord = new String[word.length()];

        for (int i = 0; i < word.length(); i++) {
            actualWord[i] = " _ ";
        }

        for (int i = 0; i < word.length(); i++) {
            wordIntoTable[i] = word.substring(i,i+1);
        }

    }

//    public void getWordTable(){
//
//        for (String letter: wordIntoTable) {
//            System.out.print(letter.toLowerCase());
//        }
//        System.out.println("");
//
//    }


//    public void showHiddenWord(){
//
//        for (String letter: wordIntoTable) {
//            System.out.print(" _ ");
//        }
//        System.out.println("");
//
//    }

//    public void giveLetter(String guessLetter){
//
//        for (int i = 0; i < wordIntoTable.length ; i++) {
//
//            if (guessLetter.equals(wordIntoTable[i])){
//                System.out.print(wordIntoTable[i]);
//            }else{
//                System.out.print(" _ ");
//            }
//        }
//
//
//        System.out.println("");
//
//    }



    public void setActualWord (String guessLetter){

        for (int i = 0; i < word.length(); i++) {

            if (guessLetter.equals(wordIntoTable[i])){
                actualWord[i] = word.substring(i,i+1);

            }if(!actualWord[i].equals(" _ ")) {

            } else{
                actualWord[i] = " _ ";
            }
        }
        getActualWord();

    }

    public void getActualWord(){

        for (String letter: actualWord) {
            System.out.print(letter.toLowerCase());
        }
        System.out.println("");

    }


    public void menu(){

        Scanner scanner = new Scanner(System.in);
        int wyjscie = 9;


        while (wyjscie == 9){

            System.out.println("podaj litere: ");
            String letter = scanner.nextLine();
            setActualWord(letter);

        }




    }



}
