package pl.edu.agh.hangman;

import java.util.List;
import java.util.Random;

public class RandomWordPicker {
    private static final Random RANDOM = new Random();

    public static String chooseRandomWord(List<String> words) {
        return words.get(RANDOM.nextInt(words.size()));
    }
}
