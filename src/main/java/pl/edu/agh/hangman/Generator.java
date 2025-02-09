package pl.edu.agh.hangman;

public class Generator {


    public void underscoreGenerate(String s) {
        if (!s.isEmpty()) {
            int stringLength = s.length();
            for (int i = 0; i < stringLength; i++) {
                System.out.print("_");
            }
        }
    }

    public String letterGenerate(String s, char character) {
        if (!s.isEmpty()) {
            s.replaceAll("_", String.valueOf(character));
            return s;
        }
        throw new RuntimeException("Word must have at least one letter");
    }

}
