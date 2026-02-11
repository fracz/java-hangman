package pl.edu.agh.hangman;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomWord {

    public static List<String> parseFile (String filename) throws IOException {
        List<String> myList = null;
        try {
            Path path = Paths.get(filename);
            String content = new String(Files.readAllBytes(path));
            myList = new ArrayList<String>(Arrays.asList(content.split("\n")));

        } catch (IOException e) {
            System.out.println("Error message: " + e.getMessage());
        }
        return myList;
    }

    public static String findIndex (List<String> inputList) {

        //int indeks = new Random().nextInt(someArray.length);
        Random rand = new Random();
        String randomElement = inputList.get(rand.nextInt(inputList.size()));

        return randomElement;
    }
}



