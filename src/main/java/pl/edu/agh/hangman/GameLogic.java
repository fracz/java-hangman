package pl.edu.agh.hangman;

import java.util.Scanner;

public class GameLogic {

    private int lives;
    private String answer;
    private String gameBoard;

    public GameLogic(int lives, String answer) {
        this.lives = lives;
        this.answer = answer;
        this.gameBoard = generateGameBoard(answer);
    }

    public void mainLoop() {
        Scanner scanner = new Scanner(System.in);

        while (!gameBoard.equals(answer) && lives > 0) {

            System.out.println(lives);
            System.out.println(gameBoard);
            System.out.println("input:");
            char input = scanner.nextLine().toCharArray()[0];

            checkUserInput(input);
            updateGameBoard(input);

        }
    }

    protected void checkUserInput(char userInput) {

        userInput = Character.toUpperCase(userInput);

        if (!answer.toUpperCase().contains(Character.toString(userInput))) {
            lives--;
        }

    }

    protected void updateGameBoard(char userInput) {

        userInput = Character.toUpperCase(userInput);

        StringBuilder builder = new StringBuilder(gameBoard);

        for (int i = 0; i < answer.length(); i++) {

            if (answer.charAt(i) == userInput) {

                builder.setCharAt(i, userInput);
            }
        }
        gameBoard = builder.toString();

    }

    protected String generateGameBoard(String answer) {

        StringBuilder builder = new StringBuilder();
        String gameBoard = "";

        for (int i = 0; i < answer.length(); i++) {

            if (answer.charAt(i) == ' ') {
                gameBoard += " ";
            } else {
                gameBoard += "_";
            }
        }

        return gameBoard;

    }

    public int getLives() {
        return lives;
    }

    public String getAnswer() {
        return answer;
    }

    public String getGameBoard() {
        return gameBoard;
    }
}
