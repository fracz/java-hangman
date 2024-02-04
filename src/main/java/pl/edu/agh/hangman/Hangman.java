package pl.edu.agh.hangman;

public class Hangman {
    public static void main(String[] args) {

        GetRandomWordFromFile wordGenerator = new GetRandomWordFromFile("src/main/resources/slowa.txt");
        String word = wordGenerator.getWord();

//        GetRandomWordFromFile wordGenerator = new GetRandomWordFromUrl("url");
//        String word = wordGenerator.getWord();
        //System.out.println("Słowow e celach testowych " + word);

        Game game = new Game(word);
        game.start();
    }
}
