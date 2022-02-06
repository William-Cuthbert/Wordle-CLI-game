package wordlecli;

import org.junit.Test;
import static org.junit.Assert.*;

public class CLIModelTest {

    /**
     * Test of getRowCount method, of class CLIModel.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        CLIModel instance = new CLIModel();
        int expResult = 0;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColCount method, of class CLIModel.
     */
    @Test
    public void testGetColCount() {
        System.out.println("getColCount");
        CLIModel instance = new CLIModel();
        int expResult = 0;
        int result = instance.getColCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of countGuesses method, of class CLIModel.
     */
    @Test
    public void testCountGuesses() {
        System.out.println("countGuesses");
        CLIModel instance = new CLIModel();
        int expResult = 0;
        int result = instance.countGuesses();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGuess method, of class CLIModel.
     */
    @Test
    public void testGetGuess() {
        System.out.println("getGuess");
        int index = 0;
        CLIModel instance = new CLIModel();
        String expResult = "";
        String result = instance.getGuess(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswer method, of class CLIModel.
     */
    @Test
    public void testGetAnswer() {
        System.out.println("getAnswer");
        CLIModel instance = new CLIModel();
        String expResult = "";
        String result = instance.getAnswer();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasWon method, of class CLIModel.
     */
    @Test
    public void testHasWon() {
        System.out.println("hasWon");
        CLIModel instance = new CLIModel();
        boolean expResult = false;
        boolean result = instance.hasWon();
        assertEquals(expResult, result);
    }

    /**
     * Test of isGameOver method, of class CLIModel.
     */
    @Test
    public void testIsGameOver() {
        System.out.println("isGameOver");
        CLIModel instance = new CLIModel();
        boolean expResult = false;
        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
    }

    /**
     * Test of guess method, of class CLIModel.
     */
    @Test
    public void testGuess() {
        System.out.println("guess");
        String str = "";
        CLIModel instance = new CLIModel();
        instance.guess(str);
}
