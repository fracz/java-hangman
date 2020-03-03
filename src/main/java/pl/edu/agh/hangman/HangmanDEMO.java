package pl.edu.agh.hangman;


public class HangmanDEMO {

    public static void main(String[] args) {
        Word word = new pl.edu.agh.hangman.Word(30);
        String wordd = word.getFile("src/main/resources/slowa.txt");

        Hangman hangman = new Hangman(wordd);
        hangman.run();
    }
}
