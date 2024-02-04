package pl.edu.agh.hangman;

import java.io.*;
import java.util.ArrayList;

public class ReadTextFromfile {

    private String path;

    public ReadTextFromfile(String path) {
        this.path = path;
    }

    public ArrayList<String> writeWords () {

        ArrayList<String> words = new ArrayList<>();
        String line;
        File file = new File(path);

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
