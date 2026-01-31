package pl.edu.agh.hangman;

public class ValidData {
    String word;

    public ValidData(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean checkLetter(char letter) {

        return word.contains(String.valueOf(letter));
    }
}
