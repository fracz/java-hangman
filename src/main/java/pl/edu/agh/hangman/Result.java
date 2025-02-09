package pl.edu.agh.hangman;

public class Result {



    public void wyswietlWynik(boolean result){
        if(result == true){
            System.out.println("WYGRANA");
        }
        else {
            System.out.println("PRZEGRANA");
        }

    }

}
