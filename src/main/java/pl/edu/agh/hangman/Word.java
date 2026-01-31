package pl.edu.agh.hangman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Word {

    private List<String> slowa;
    private Random random = new Random();

    public Word(String nazwaPliku) throws IOException {
        slowa = Files.readAllLines(Path.of(nazwaPliku));

        for (int i = 0; i < slowa.size(); i++) {
            slowa.set(i, slowa.get(i)
                    .replace('\u00A0', ' ')
                    .trim());
        }

        for (int i = 0; i < slowa.size(); i++) {
            slowa.set(i, slowa.get(i)
                    .toUpperCase(Locale.forLanguageTag("pl")));
        }

        slowa.removeIf(String::isBlank);
    }

    public String losujSlowo() {
        if (slowa.isEmpty()) {
            throw new IllegalStateException("Brak słów w pliku!");
        }
        return slowa.get(random.nextInt(slowa.size()));
    }
}
