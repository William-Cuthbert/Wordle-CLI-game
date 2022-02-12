package wordlecli;

import wordlecli.models.Wordle;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class CLIModelTest {

    /**
     * Test of getRowCount method, of class CLIModel.
     * @throws java.io.IOException
     */
    @Test
    public void testGetRowCount() throws IOException {
        System.out.println("getRowCount");
        Wordle instance = new Wordle();
        int expResult = 0;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColCount method, of class CLIModel.
     * @throws java.io.IOException
     */
    @Test
    public void testGetColCount() throws IOException {
        System.out.println("getColCount");
        Wordle instance = new Wordle();
        int expResult = 0;
        int result = instance.getColCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of countGuesses method, of class CLIModel.
     * @throws java.io.IOException
     */
    @Test
    public void testCountGuesses() throws IOException {
        System.out.println("countGuesses");
        Wordle instance = new Wordle();
        int expResult = 0;
        int result = instance.countGuesses();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGuess method, of class CLIModel.
     * @throws java.io.IOException
     */
    @Test
    public void testGetGuess() throws IOException {
        System.out.println("getGuess");
        int index = 0;
        Wordle instance = new Wordle();
        String expResult = "";
        String result = instance.getGuessIndex(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswer method, of class CLIModel.
     * @throws java.io.IOException
     */
    @Test
    public void testGetAnswer() throws IOException {
        System.out.println("getAnswer");
        Wordle instance = new Wordle();
        String expResult = "";
        String result = instance.getAnswer();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasWon method, of class CLIModel.
     * @throws java.io.IOException
     */
    @Test
    public void testHasWon() throws IOException {
        System.out.println("hasWon");
        Wordle instance = new Wordle();
        boolean expResult = false;
        boolean result = instance.hasWon();
        assertEquals(expResult, result);
    }

    /**
     * Test of isGameOver method, of class CLIModel.
     * @throws java.io.IOException
     */
    @Test
    public void testIsGameOver() throws IOException {
        System.out.println("isGameOver");
        Wordle instance = new Wordle();
        boolean expResult = false;
        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
    }

    /**
     * Test of guess method, of class CLIModel.
     * @throws java.io.IOException
     */
    @Test
    public void testGuess() throws IOException {
        System.out.println("guess");
        String str = "";
        Wordle instance = new Wordle();
        instance.addGuess(str);
    }
}
