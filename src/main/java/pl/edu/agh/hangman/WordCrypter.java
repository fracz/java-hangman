package pl.edu.agh.hangman;

public class WordCrypter {
    private String randomWord;
    public WordCrypter(String randomWord) {
        this.randomWord = randomWord;
    }

    public String cryptWord() {
        int lengthOfWord = this.randomWord.length();
        String singleFloorSign = "_";
        String cryptedWord = new String(new char[lengthOfWord]).replace("\0", singleFloorSign);
        return cryptedWord;
    }


}
