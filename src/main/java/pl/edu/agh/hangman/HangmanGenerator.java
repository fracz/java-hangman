package pl.edu.agh.hangman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HangmanGenerator {
	// klasa odpowiedzialna za wczytywanie slowa z pliku
	// file reader

	public String newWord(String path) throws IOException {
		List<String> words = appendWordsToList(path);
		WordPicker picker = new RandomWordPicker(words);
		return picker.getWord();
	}
	
	public List<String> appendWordsToList(String path) throws IOException {
		return Files.readAllLines(Paths.get("/src/main/resources/slowa.txt"));
	}

}
