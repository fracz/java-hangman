package pl.edu.agh.hangman;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 1. readFile(<file.txt> from resource) - return collection of strings in uppercases
 * 2. drawWord(collection) - return single word as string in uppercase
 */
public class WordLoader {

    public List<String> readFile(String fileName) throws IOException {
        FileInputStream inputStream = null;
        List<String> words = new ArrayList<>();

        try {
            // Getting ClassLoader obj
            ClassLoader classLoader = this.getClass().getClassLoader();
            // Getting resource(File) from class loader
            File configFile = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());

            inputStream = new FileInputStream(configFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
        words = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        return words;
    }

    public String drawWord(List<String> words) {
        Random rand = new Random();
        int n = rand.nextInt(words.size() - 1);
        return words.get(n);
    }
}
