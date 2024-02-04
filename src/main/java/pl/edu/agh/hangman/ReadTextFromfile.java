package pl.edu.agh.hangman;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class ReadTextFromfile {

    private String path;

    public ReadTextFromfile(String path) {
        this.path = path;
    }

    public ArrayList<String> writeWords () {

        ArrayList<String> words = new ArrayList<>();
        String line;
        URL pathToFile =  ReadTextFromfile.class.getResource(path);
        File file = null;
        try {
            file = new File(pathToFile.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
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
