package pl.edu.agh.hangman;

public class PasswordPrinter {
    String password;
    String shownPassword;
    char letter = 'a';


    public PasswordPrinter(String password, String displayPassword, char letter) {
        this.password = password;
        shownPassword = "_ ";

        for (int i = 0; i < password.length(); i++) {
            System.out.print(shownPassword);
        }

        String Stringletter = String.valueOf(letter);
        if (password.contains(Stringletter)) {

        }

    }
}

