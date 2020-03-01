package pl.edu.agh.hangman;

public class HangmanDEMO {

    public static void main(String[] args) {

        Hangman hangman = new Hangman("zaDecia java");
        hangman.showHangmanpics();
        //hangman.getWord();
        //hangman.convertWordIntoTable();
        //hangman.getWordTable();
        //hangman.showHiddenWord();
        //hangman.giveLetter("a");
        //hangman.giveLetter("z");
        hangman.convertWordIntoTable();
//        hangman.setActualWord("a");
//        hangman.setActualWord("z");
//        hangman.setActualWord("j");
//        hangman.setActualWord("i");
//        hangman.setActualWord("e");
        hangman.menu();

    }

}
