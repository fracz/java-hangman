package pl.edu.agh.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {

    private String filePath = "src/main/resources/slowa.txt";


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

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        System.out.println(fileReader.scanFile());
    }
}
