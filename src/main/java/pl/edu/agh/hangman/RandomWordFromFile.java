package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;

public class RandomWordFromFile implements RandomWord {

    private ArrayList<String> getWordsFromFile(){

        File file = new File("src/main/resources/slowa.txt");
        ArrayList<String> allWords = new ArrayList<>();
        String line = null;

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(file.toPath());
            while((line = bufferedReader.readLine()) != null){
                allWords.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allWords;
    }

    public String getRandomWord() {
        Random random = new Random();
        ArrayList<String> randomWord = getWordsFromFile();
        return randomWord.get(random.nextInt(randomWord.size()));
    }

}
