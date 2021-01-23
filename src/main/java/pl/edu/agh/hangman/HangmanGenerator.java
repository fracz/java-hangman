package pl.edu.agh.hangman;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HangmanGenerator {

	// klasa odpowiedzialna za wczytywanie slowa z pliku
	// file reader

	public static void appendWordsToList(String path) throws IOException {

		List<String> words = Files.readAllLines(Paths.get("/src/main/resources/slowa.txt"));

	}

}
