import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Word {

    public   static ArrayList<String> getFile() {
                // Reader word = new FileReader("src/main/resources/slowa.txt");
                String txtFile = "src/main/resources/slowa.txt";
                BufferedReader br = null;
                String line = "";
                ArrayList<String> wordTable = new ArrayList<>();

                try {

                    br = new BufferedReader(new FileReader(txtFile));


                    while ((line = br.readLine()) != null) {
                       // String[] word = line.split(" \\| ");
                        wordTable.add(line);
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

//        for (String s: wordTable){
//            System.out.println(s);
//        }
        return wordTable;
    }

    public static void main(String[] args) {

        Word tb = new Word();
        System.out.println(tb.getWord());

      //  for (String s: table) System.out.println(s);
    }

    public String getWord(){
        ArrayList<String> wordTable = getFile();
        Random random = new Random();

        int randomIndex = (int) (Math.random() * wordTable.size());
        System.out.println( "Random Color: " +  wordTable.get( randomIndex ) );
        return wordTable.get( randomIndex);
    }
}
