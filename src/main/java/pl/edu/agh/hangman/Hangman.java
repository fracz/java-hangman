package pl.edu.agh.hangman;

import java.io.*;
import java.net.URL;
import java.util.*;

public class Hangman {

    public static final String FILE = "src/main/resources/slowa.txt";
    public static final String WIN = "♥(ˆ⌣ˆԅ)";
    public static final String LOST = "\"(｡•́︿•̀｡)\"";
    public static String WORDNIK_URL = "http://api.wordnik.com/v4/words.json/randomWords?hasDictionaryDef=true&minCorpusCount=0&minLength=5&maxLength=15&limit=1&api_key=a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5";
    public static final String REGEX =  "[ABCDEFGHIJKLMNOPRSTUVWYZąćęłńóśźżĄĘŁŃÓŚŹŻ]";
    public static int wordLength = 0;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        boolean isContinue = true;
        String word;

        while (isContinue){
            printMenu();
            switch (scanner.nextLine()){
                case "1":
                    word = getRandomWord(true);
                    startGame(word);
                    break;
                case "2":
                    word = getRandomWord(false);
                    startGame(word);
                    break;
                case "3":
                    setUpWordLength();
                    break;
                case "4":
                    saveWord();
                    break;
                case "0":
                    isContinue = false;
                    System.out.println("Zakończenie");
                    break;
                default:
                    System.out.println("Nie ma takiej opjcji!!!");
                    break;
            }
        }
    }

    public static void printMenu (){
        System.out.println("Wybierz z dostępnych opcji: " +
                            "\n1\tRozpocznij grę - słowo z pliku" +
                            "\n2\tRozpocznij grę - słowo z Wordnik" +
                            "\n3\tUstaw długość słówa" +
                            "\n4\tDodaj nowe słowo do pliku" +
                            "\n0\tZakończ");
    }

    public static String[] getBoard(String status){

        String[] HANGMANPICS = new String[]{
                "  +---+\n" +
                        "  |   |\n" +
                        "      |\t\t"   + status +"\n"+
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\t\t"   + status +"\n"+
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\t\t"   + status +"\n"+
                        "  |   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\t\t"   + status +"\n"+
                        " /|   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\t\t"   + status +"\n"+
                        " /|\\  |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\t\t"   + status +"\n"+
                        " /|\\  |\n" +
                        " /    |\n" +
                        "      |\n" +
                        "=========",
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\t\t"   + status +"\n"+
                        " /|\\  |\n" +
                        " / \\  |\n" +
                        "      |\n" +
                        "========"
        };
        return  HANGMANPICS;
    }

    public static void startGame (String word){
        String tempRegex = REGEX;
        String status;
        String input;
        int inCorrectAnswer = 0;

//        System.out.println(word);
        while (true){
            status = word.replaceAll(tempRegex, "_");
            status = status.replaceAll("", " ");

            System.out.println(getBoard(status)[inCorrectAnswer]);
            if (!status.contains("_")){
                System.out.println(WIN + "\n");
                break;
            }

            input = scanner.nextLine().toUpperCase();
            tempRegex = tempRegex.replace(input, "");

            if (!word.contains(input)){
                inCorrectAnswer ++;
                if (inCorrectAnswer == getBoard(status).length-1){
                    System.out.println(LOST + "\n");
                    break;
                }
            }
        }
    }

    public static void setUpWordLength (){
        System.out.println("Wprowadź długość słowa: ");
       try {
           int value = scanner.nextInt();
           scanner.nextLine();
           if (value <=0 ){
               System.out.println("WARTOŚĆ MUSI BYĆ WIĘKSZA OD 0 !!!");
               return;
           }
           wordLength = value;

           WORDNIK_URL = "http://api.wordnik.com/v4/words.json/randomWords?hasDictionaryDef=true&minCorpusCount=0&minLength="
                            + wordLength + "&maxLength=" + wordLength +
                            "&limit=1&api_key=a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5";
       } catch (InputMismatchException e){
           System.out.println("BŁĄD DOZWOLONE SĄ TYLKO CYFRY !!!");
       }
    }

    public static void saveWord(){
        System.out.println("Wprowadź nowe słowo: ");
        String word = scanner.nextLine();

        try {
            FileWriter file = new FileWriter(FILE, true);
            BufferedWriter bw = new BufferedWriter(file);
            bw.write(word);
            bw.newLine();
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static List<String> loadWordsFromFile(){
        List<String> list = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new FileReader(FILE));
            while (sc.hasNextLine()){
                list.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static String loadFromWordwnik (){
        try {
            URL url = new URL(WORDNIK_URL);
            Scanner sc = new Scanner(url.openStream());
            StringBuffer sb = new StringBuffer();

            while(sc.hasNext()) {
                sb.append(sc.next());
            }
            String result = sb.toString();
            result = result.substring(17, result.length()-3);
            return result.toUpperCase();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getRandomWord (boolean file) throws Exception{
        if (file){
            Random random = new Random();
            List<String> wordList = loadWordsFromFile();
            if (wordLength > 0){ // jeżli użytkowni wprowadził długość słów
                List<String> wordWithLength = new ArrayList<>();
                for (String s: wordList){
                    if (s.length() == wordLength){
                        wordWithLength.add(s);
                    }
                }
                if (wordWithLength.size() == 0){
                    throw  new Exception("BRAK SŁOWA O TAKIEJ DŁUGOŚCI W BAZIE!!!");
                }
                return wordWithLength.get(random.nextInt(wordWithLength.size())).toUpperCase();

            } else { // nie zmieniono domyślnej długości słów
                return wordList.get(random.nextInt(wordList.size())).toUpperCase();
            }
        }
        else {
            return loadFromWordwnik();
        }
    }
}
