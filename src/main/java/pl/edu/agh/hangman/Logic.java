package pl.edu.agh.hangman;

import static pl.edu.agh.hangman.PrintResult.printResult;

public class Logic {
    int level = 0;
    String wordToFind;
    StringBuilder currentWord;

    public Logic(String wordToFind) {
        this.wordToFind = wordToFind.toUpperCase();
        currentWord = new StringBuilder().insert(wordToFind.length(), "_");
    }

    public boolean checkLetter(char letter) {
        boolean state = true;
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

        printResult(level, currentWord.toString());
        return currentWord.toString().contains("_");
    }
}
