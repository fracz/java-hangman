package pl.edu.agh.hangman;

public class Hangman {


    public static void main(String[] args) {

        String word = Word.getRandomWordFromFile("src/main/resources/slowa.txt");
        word = word.toUpperCase();
        System.out.println("Słowow e celach testpowych" + word);

        Gra game = new Gra(word);
        game.start();

    }
}
