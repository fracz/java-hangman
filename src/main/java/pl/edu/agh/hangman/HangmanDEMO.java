package pl.edu.agh.hangman;


public class HangmanDEMO {

    public static void main(String[] args) {
        Word word = new pl.edu.agh.hangman.Word(10);
        String wordd = word.getFile("src/main/resources/slowa.txt");

        Hangman hangman = new Hangman(wordd);


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
