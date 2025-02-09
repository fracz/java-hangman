package pl.edu.agh.hangman;

import org.junit.Assert;
import org.junit.Test;

public class UserCharacterCheckerTest {


    private UserCharacterChecker createUserCharacterChecker(){
        return new UserCharacterChecker(new char[] {'a', 'b', 'c', 'd'});
    }

    @Test
    public void testUserGuess(){
        UserCharacterChecker userCharacterChecker = createUserCharacterChecker();
        userCharacterChecker.guessCharacter('a');
        Assert.assertEquals('a', userCharacterChecker.getGuessedWordChars()[0]);
        Assert.assertEquals('\u0000', userCharacterChecker.getGuessedWordChars()[1]);
        Assert.assertEquals('\u0000', userCharacterChecker.getGuessedWordChars()[2]);
        Assert.assertEquals('\u0000', userCharacterChecker.getGuessedWordChars()[3]);
    }

    @Test
    public void testUserAlreadyGuessed(){
        UserCharacterChecker userCharacterChecker = createUserCharacterChecker();
        userCharacterChecker.guessCharacter('b');
        Assert.assertEquals('\u0000', userCharacterChecker.getGuessedWordChars()[0]);
        Assert.assertEquals('b', userCharacterChecker.getGuessedWordChars()[1]);
        Assert.assertEquals('\u0000', userCharacterChecker.getGuessedWordChars()[2]);
        Assert.assertEquals('\u0000', userCharacterChecker.getGuessedWordChars()[3]);
    }

    @Test
    public void testUserAlreadyGuessed2(){
        UserCharacterChecker userCharacterChecker = createUserCharacterChecker();
        userCharacterChecker.guessCharacter('b');
        userCharacterChecker.guessCharacter('c');
        Assert.assertEquals('\u0000', userCharacterChecker.getGuessedWordChars()[0]);
        Assert.assertEquals('b', userCharacterChecker.getGuessedWordChars()[1]);
        Assert.assertEquals('c', userCharacterChecker.getGuessedWordChars()[2]);
        Assert.assertEquals('\u0000', userCharacterChecker.getGuessedWordChars()[3]);
    }

    @Test
    public void testGuessCharacterThrowsIllegalArgumentException(){

        boolean thrown = false;
        UserCharacterChecker foo = new UserCharacterChecker(new char[] {'a', 'b', 'c', 'd'});

        try {
            foo.guessCharacter('a');
            foo.guessCharacter('a');
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        Assert.assertTrue(thrown);
    }
}
