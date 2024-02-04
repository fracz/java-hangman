package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadTextFromfile {

    public ArrayList<String> writeWords (String path) {

        ArrayList<String> words = new ArrayList<>();
        String line;

        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            while ((line = bf.readLine()) != null) {
                words.add(line.toUpperCase());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }

}
