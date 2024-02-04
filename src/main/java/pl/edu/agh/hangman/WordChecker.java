package pl.edu.agh.hangman;

import java.util.ArrayList;
import java.util.HashSet;


public class WordChecker {
    private final String wordChoosen;
    private String wordCrypted;

    private int numberOfLettersToGuess;

    private HashSet<String> usedLetters = new HashSet<>();
    private int HP = 10;

    public WordChecker(String wordChoosen, String wordCrypted){
        this.wordChoosen = wordChoosen;
        this.wordCrypted = wordCrypted;
        this.numberOfLettersToGuess = wordChoosen.length();

    }

    public int getHP() {
        return this.HP;
    }
    public int getNumberOfLettersToGuess() {
        return this.numberOfLettersToGuess;
    }
    public String getWordCrypted() {
        return wordCrypted;
    }

    public boolean checkIfLetterUsedBefore(String choosenLetter) {


        if (this.usedLetters.contains(choosenLetter)) {
            return true;
        } else {
            this.usedLetters.add(choosenLetter);
            return false;
        }
    }
    public void checkUserChoice(String choosenLetter) {

        this.usedLetters.add(choosenLetter);
        if (!this.wordChoosen.contains(choosenLetter)) {
            this.HP = this.HP - 1;
        }
        else {

            char choosenLetterAsChar = choosenLetter.charAt(0);
            int count = 0;
            ArrayList<Integer> indexes = new ArrayList<>();

            for (int i = 0; i < wordChoosen.length(); i++) {
                if (wordChoosen.charAt(i) == choosenLetterAsChar) {
                    count++;
                    indexes.add(i);
                }
            }

                this.numberOfLettersToGuess = this.numberOfLettersToGuess - count;
                StringBuilder partiallyEncrypted = new StringBuilder(this.wordCrypted);
                for (int index : indexes) {
                    partiallyEncrypted.setCharAt(index,choosenLetterAsChar);
            }
             this.wordCrypted = partiallyEncrypted.toString();
        }
    }


        }


