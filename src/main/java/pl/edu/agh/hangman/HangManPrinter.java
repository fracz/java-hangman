package pl.edu.agh.hangman;

import java.sql.SQLOutput;

public class HangManPrinter {
    private String[] hangManPics;
    public HangManPrinter(String[] hangManPics){
        this.hangManPics = hangManPics;
    }
    public void printHangMan(int HP) {
        switch (HP) {
            case 7:
                System.out.println("Nieźle! Wciąż masz full HP!");
                break;
            case 6:
                System.out.println(this.hangManPics[0]);
                break;
            case 5:
                System.out.println(this.hangManPics[1]);
                break;
            case 4:
                System.out.println(this.hangManPics[2]);
                break;
            case 3:
                System.out.println(this.hangManPics[3]);
                break;
            case 2:
                System.out.println(this.hangManPics[4]);
                break;
            case 1:
                System.out.println(this.hangManPics[5]);
                break;
            case 0:
                System.out.println(this.hangManPics[6]);
                break;

        }
    }
}
