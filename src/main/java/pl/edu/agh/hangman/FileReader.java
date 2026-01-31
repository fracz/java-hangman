package pl.edu.agh.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    private String filePath = "/home/students/m/b/mbalicki/Documents/java-hangman/src/main/resources/slowa.txt";

    public ArrayList<String> scanFile() throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<>();
        File file = new File(filePath);
        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNextLine()) {
                String word = fileReader.nextLine();
                words.add(word);
            }
        }
        return words;
    }
}
