package pl.edu.agh.hangman;

public class Logic {
    int level = 0;
    String wordToFind;
    StringBuilder currentWord;

    public Logic(String wordToFind) {
        this.wordToFind = wordToFind.toUpperCase();
        currentWord = new StringBuilder().insert(wordToFind.length(), "_");
    }

    public void checkLetter(char letter) {
        char letterUpper = Character.toUpperCase(letter);
        if (wordToFind.indexOf(letterUpper) < 0) {
            level++;
        } else {

            for (int i = 0; i < wordToFind.length(); i++) {
                if (wordToFind.charAt(i) == letterUpper) {
                    currentWord.replace(i, i, String.valueOf(letterUpper));
                }
            }
        }

        //printResult(level, currentWord)
    }
}
