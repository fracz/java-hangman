import java.util.Scanner;


public class UserInput {

    private Scanner scanner = new Scanner(System.in);

    public String userInput() {
        String input;

        while (true) {
            System.out.print("Enter letter: ");
            input = scanner.nextLine().trim().toUpperCase();

            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                return input;
            }
            System.out.println("Invalid input. Please try again.");
        }

    }
}