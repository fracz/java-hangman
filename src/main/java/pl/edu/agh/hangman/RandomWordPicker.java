package pl.edu.agh.hangman;

import java.util.List;
import java.util.Random;

public class RandomWordPicker {
	
	public static final Random RANDOM = new Random();
	
	// klasa losujaca randomowe slowo z kolekcji
	public String getRandomWord(List<String> words) {
    	return words.get(RANDOM.nextInt(words.size()));
    }
}
