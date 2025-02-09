package pl.edu.agh.hangman;

import java.util.ArrayList;

public class UserCharacterChecker {

    private char[] finalWordChars;
    private char[] guessedWordChars;
    private ArrayList<Character> userGuessList;


    public UserCharacterChecker(char[] finalWordChars) {
        this.finalWordChars = finalWordChars;
        this.guessedWordChars = new char[finalWordChars.length];
        this.userGuessList = new ArrayList<>();
    }

    public void guessCharacter(char character){
        addCharacterToUsserGuessList(character);
        compareGuessWithWord(character);
    }

    private void compareGuessWithWord(char character){
        for(int i = 0; i < finalWordChars.length; i++){
            if(finalWordChars[i] == character){
                guessedWordChars[i] = character;
            }
        }
    }

    private boolean checkIfCharacterWasGuessedEarlier(char character){
        if(this.userGuessList.contains(character)){
            return true;
        }
        return false;
    }

    private void addCharacterToUsserGuessList(char character){
        if(checkIfCharacterWasGuessedEarlier(character)){
            throw new IllegalArgumentException("You already guessed this letter.");
        }else{
            this.userGuessList.add(character);
        }
    }

    public char[] getGuessedWordChars(){
        return this.guessedWordChars;
    }


}
