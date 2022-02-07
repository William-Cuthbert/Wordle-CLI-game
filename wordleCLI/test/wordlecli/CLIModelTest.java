package wordlecli;

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
        CLIModel instance = new CLIModel();
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
        CLIModel instance = new CLIModel();
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
        CLIModel instance = new CLIModel();
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
        CLIModel instance = new CLIModel();
        String expResult = "";
        String result = instance.getGuess(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswer method, of class CLIModel.
     * @throws java.io.IOException
     */
    @Test
    public void testGetAnswer() throws IOException {
        System.out.println("getAnswer");
        CLIModel instance = new CLIModel();
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
        CLIModel instance = new CLIModel();
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
        CLIModel instance = new CLIModel();
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
        CLIModel instance = new CLIModel();
        instance.guess(str);
    }
}
