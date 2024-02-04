package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class GetRandomWordFromFile {

    public String file;

    public GetRandomWordFromFile(String file) {
        this.file = file;
    }

    private static String cleanWord(String word) {
        String cleanedWord = word.replace("\u00a0","");
        cleanedWord = cleanedWord.trim();
        cleanedWord = cleanedWord.toUpperCase(Locale.ROOT);
        return cleanedWord;
    }

    private static boolean checkIfWordProper(String word) {
        return !word.contains(" ");
    }

    private static String getRandomWordFromArray(ArrayList<String> words) {
        Random random = new Random();
        int randomCounter =  random.ints(0, words.size() - 1).findFirst().getAsInt();
        return words.get(randomCounter);
    }
    public String getWord() {
        File wordsFile = new File(file);
        String line = null;
        int counter = 0;
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(wordsFile.toPath()))
        {
            while ((line = reader.readLine()) != null) {
                words.add(line);
                counter++;
            }
        } catch (IOException x) {
            System.err.format("IOException: %s", x);
        }

        String newWord = getRandomWordFromArray(words);

        while (!checkIfWordProper(newWord)) {
            newWord = getRandomWordFromArray(words);
        }

        return cleanWord(newWord);
    }
}
