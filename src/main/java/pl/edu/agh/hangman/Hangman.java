package pl.edu.agh.hangman;

public class Hangman {
    public static void main(String[] args) {

        String word = Word.getRandomWordFromFile("src/main/resources/slowa.txt");
        word = word.toUpperCase();
        //System.out.println("Słowow e celach testowych " + word);

        Game game = new Game(word);
        game.start();
    }
}
