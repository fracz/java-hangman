package pl.edu.agh.hangman;

import java.util.List;
import java.util.Random;

public class RandomWordPicker implements WordPicker {
	
	public static final Random RANDOM = new Random();
	
	private List<String> words;
	
	// klasa losujaca randomowe slowo z kolekcji
	public String getRandomWord(List<String> words) {
    	return words.get(RANDOM.nextInt(words.size()));
    }

	public RandomWordPicker(List<String> words) {
		this.words = words;
	}
	
	@Override
	public String getWord() {
		return words.get(RANDOM.nextInt(words.size()));
	}
}
