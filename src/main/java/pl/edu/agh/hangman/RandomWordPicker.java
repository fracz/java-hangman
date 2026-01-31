package pl.edu.agh.hangman;

import java.util.List;
import java.util.Random;

public class RandomWordPicker {
    private static final Random RANDOM = new Random();

    public static String chooseRandomWord(List<String> words, int wordLength) throws IllegalArgumentException {
        String randomWord = "";
        while (randomWord.length() != wordLength) {
            words.get(RANDOM.nextInt(words.size()));
        }

        return randomWord;
    }
}
