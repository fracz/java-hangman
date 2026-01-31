package pl.edu.agh.hangman;

public class Hangman {

    public static void main(String[] args) {

        // Test WordRandomizer
        WordRandomizer randomizer = new WordRandomizer();
        String word = randomizer.getRandomWord();
        System.out.println("Wylosowane slowo (test): " + word);
    }
}
