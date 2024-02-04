package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordReader {

    private final List<String> wordsList = new ArrayList<>();

    public List<String> readFile() {
        try {
            int a = 0;
            BufferedReader reader = new BufferedReader(new FileReader("/home/students/m/j/mjakubow/IdeaProjects/java-hangman/src/main/resources/slowa.txt"));
            String wordFromFile = "";
            while ((wordFromFile = reader.readLine()) != null) {
                wordsList.add(wordFromFile.toLowerCase());
                a++;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordsList;
    }
}