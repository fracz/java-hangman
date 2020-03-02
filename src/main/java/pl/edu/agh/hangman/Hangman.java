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
        //getActualWord();

    }

    public void getActualWord(){

        for (String letter: actualWord) {
            System.out.print(letter);
        }
        System.out.println("");

    }


    public void menu(){

        int countTry = 0;

        while (countTry != 7){

            Scanner scanner = new Scanner(System.in);




            getWord();

            System.out.print("wybierz opcję: 1 - podaj literę, 2 - zgaduj haslo, 7 - wyjdz" + "  | proba nr.: " + countTry + "/7 |   odgadnij ->   ");
            getActualWord();
            showHangmanpics(countTry);
            System.out.println("");

            int optionNumber = scanner.nextInt(); scanner.nextLine();


            switch (optionNumber){

                case 1:

                    System.out.print("podaj litere: ");
                    String letter = scanner.nextLine();
                    setActualWord(letter);

                    for (String checkLetter: wordIntoTable) {
                        if (checkLetter.equals(letter)){
                            System.out.println("TRAFILES !");
                            break;
                        } else {
                            countTry = countTry + 1;
                        }

                    }

                    break;

                case 2:

                    System.out.println("podaj haslo: ");
                    String haslo = scanner.nextLine();

                    if(haslo.equals(word)){
                        countTry = 7;
                        System.out.println("WYGRALES !!!!");
                    }

                    break;

                case 7:
                    countTry =7 ;

                    System.out.println("Dziekujemy za Twoją gre! NIE WYGRALES !!!");

                    break;



            }




//            System.out.print("podaj litere: ");
//            String letter = scanner.nextLine();
//            setActualWord(letter);
//            countTry = countTry + 1;
//            System.out.println(countTry);

//            getWordTable();
//            getActualWord();

        }


    }



}
