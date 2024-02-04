package pl.edu.agh.hangman;
import java.util.*;
import java.util.Random;
import java.util.ArrayList;


public class ChooseWord {
    public String chooseWord (ArrayList<String> words) {
        Random random = new Random();
        int randomWord = random.nextInt(words.size());
        return words.get(randomWord);
    }
}

