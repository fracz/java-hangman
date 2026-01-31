package pl.edu.agh.hangman;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WordRandomizer {
//Jedno wspolne zrodlo losowosci dla calej klasy
    private static final Random RANDOM = new Random();
//zwraca wylosowane slowo
    public static String getRandomWord() {
//ladowanie slow z pliku
        InputStream inputStream = WordRandomizer.class
                .getClassLoader()
                .getResourceAsStream("slowa.txt");

//Sprawdzanie czy plik istnieje w resources
        if (inputStream == null) {
            throw new RuntimeException("brak pliku w resources");
        }
        //Najwazniejsza czesc progaramu
        List<String> words = new BufferedReader(new InputStreamReader(inputStream))  //zmiana bajtow na znaki
                .lines()                                                            //czytanie liku linia po lini
                .filter(line -> !line.isBlank())                             //tworzy strumien lini tekstu
                .collect(Collectors.toList());                                     //usuwa puste linie i spacje

        if (words.isEmpty()) {
            throw new RuntimeException("wybrany plik jest pusty!");
        }

        return words.get(RANDOM.nextInt(words.size())).toLowerCase();
    }
}
