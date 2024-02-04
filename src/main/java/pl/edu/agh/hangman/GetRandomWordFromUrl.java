package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class GetRandomWordFromUrl {
    public String url;

    public GetRandomWordFromUrl(String url) {
        this.url = url;
    }

    public String getWord() {
        return "LAPTOP";
    }
}
