package pl.edu.agh.hangman;

public class Game {

    private String wordToFind;
    private char[] letterFound;

    public Game(WordProvider wordProvider){
        this.wordToFind = wordProvider.getWordToGuess();

    }

    public void play(){}
}
