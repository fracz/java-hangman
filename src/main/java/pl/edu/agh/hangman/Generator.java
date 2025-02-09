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

    public void letterGenerate(String s) {
        //TODO
    }

}
