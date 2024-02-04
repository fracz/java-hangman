package pl.edu.agh.hangman;

public class Hangman {



    public static void main(String[] args) {

        String word = Word.getRandomWordFromFile("src/main/resources/slowa.txt");
        System.out.println(word);

        Gra game = new Gra("word");
        game.start();

    }
}
