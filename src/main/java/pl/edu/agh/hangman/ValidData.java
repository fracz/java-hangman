package pl.edu.agh.hangman;

public class ValidData {
    private String word;
    private boolean[] founded;

    public ValidData(String word) {
        this.word = word;
        this.founded = new boolean[word.length()];
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean[] getFounded() {
        return founded;
    }

    private boolean checkLetter(char letter) {

        return word.contains(String.valueOf(letter));
    }

    public void updateFounded(char letter) {

        boolean foundFlag = checkLetter(letter);

        if (foundFlag) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    founded[i] = true;
                }
            }
        }
    }
}
