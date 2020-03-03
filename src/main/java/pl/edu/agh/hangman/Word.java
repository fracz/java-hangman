package pl.edu.agh.hangman;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Word {
    private int maxLength;

    public Word(int maxLength) {
        this.maxLength = maxLength;
    }


    public String getFile(String txtFile) {

        //txtFile = "src/main/resources/slowa.txt";
        BufferedReader br = null;
        String line = "";
        ArrayList<String> wordTable = new ArrayList<>();

        try {

            br = new BufferedReader(new FileReader(txtFile));
            while ((line = br.readLine()) != null) {
                if (line.length() <= maxLength) {
                    wordTable.add(line);
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Random random = new Random();

        int randomIndex = (int) (Math.random() * wordTable.size());
        // System.out.println( "Random word: " +  wordTable.get( randomIndex ) );
        return wordTable.get(randomIndex).toLowerCase().trim();
    }
}
