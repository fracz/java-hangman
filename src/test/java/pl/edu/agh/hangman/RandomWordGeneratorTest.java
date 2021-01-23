package pl.edu.agh.hangman;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RandomWordGeneratorTest {
	
	private RandomWordPicker picker;
	
    @Before
    public void createEmptyRandomWordPickerForTheTest() {
        picker = new RandomWordPicker();
    }
    
    @Test
    public void testThatWordFromList() {
        List<String> words = Arrays.asList("czynność", "KURIER", "Częstochowa");
        String randomWord = picker.getRandomWord(words);
        Assert.assertTrue(words.contains(randomWord));
    }
}