package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WordRandomizer {

    // Jedno wspolne zrodlo losowosci dla OBIEKTU
    private final Random random = new Random();

    // Lista slow przechowywana jako STAN obiektu
    private final List<String> words;

    // Konstruktor - ladowanie slow z pliku
    public WordRandomizer() {

        InputStream inputStream = WordRandomizer.class
                .getClassLoader()
                .getResourceAsStream("slowa.txt");

        // Sprawdzanie czy plik istnieje w resources
        if (inputStream == null) {
            throw new RuntimeException("brak pliku w resources");
        }

        // Najwazniejsza czesc programu
        words = new BufferedReader(new InputStreamReader(inputStream)) // zmiana bajtow na znaki
                .lines()                                               // czytanie pliku linia po linii
                .filter(line -> !line.isBlank())                // usuwa puste linie i spacje
                .collect(Collectors.toList());                        // zapis do listy

        if (words.isEmpty()) {
            throw new RuntimeException("wybrany plik jest pusty!");
        }
    }

    // zwraca wylosowane slowo
    public String getRandomWord() {
        return words.get(random.nextInt(words.size())).toLowerCase();
    }
}
