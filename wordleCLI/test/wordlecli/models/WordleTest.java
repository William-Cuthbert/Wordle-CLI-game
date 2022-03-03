package wordlecli.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class WordleTest {
 
    /**
     * The test is to check whether the game has won or not
     * @throws IOException due to reading the files in wordle dictionary
     */
    @Test
    public void wordle_has_won() throws IOException {
        Wordle wordle = new Wordle();
        wordle.setAnswer("tiger");
        ArrayList<String> words = new ArrayList<>(Arrays.asList("words","tests","cigar","tiger","fiver","stand"));
        for (String word : words) {
            if (!wordle.isGameOver()) {
                wordle.addGuess(word);
            }
        }
        assertEquals(wordle.hasWon(), true);
    }
    
    /**
     * The test is to check whether the game has lost or not
     * @throws IOException due to reading the files in wordle dictionary
     */
    @Test
    public void wordle_has_lost() throws IOException{
        Wordle wordle = new Wordle();
        wordle.setAnswer("grade");
        ArrayList<String> words = new ArrayList<>(Arrays.asList("words","tests","cigar","tiger","fiver","stand"));
        for (String word : words) {
            if (!wordle.isGameOver()) {
                wordle.addGuess(word);
            }
        }
        assertEquals(wordle.hasLost(), true);
    }
    
    /**
     * The test is to check whether the game is over or not.
     * The last word in the words list has 4 characters and the minimum requirement is 5.
     * This should provoke wordle to continue the game until the last guess is a valid word.
     * @throws IOException due to reading the files in wordle dictionary
     */
    @Test
    public void wordle_is_not_gameover_invalid_word_length() throws IOException{
        Wordle wordle = new Wordle();
        wordle.setAnswer("stand");
        ArrayList<String> words = new ArrayList<>(Arrays.asList("words","tests","cigar","tiger","fiver","stan"));
        for (String word : words) {
            if (!wordle.isGameOver()) {
                wordle.addGuess(word);
            }
        }
        assertEquals(wordle.isGameOver(), false);
    }
    
    /**
     * The test is to check whether the game is over or not.
     * The last word in the words list contains a special character '%'.
     * This should provoke wordle to continue the game until the last guess is a valid word.
     * @throws IOException due to reading the files in wordle dictionary
     */
    @Test
    public void wordle_is_not_gameover_invalid_characters() throws IOException{
        Wordle wordle = new Wordle();
        wordle.setAnswer("stand");
        ArrayList<String> words = new ArrayList<>(Arrays.asList("words","tests","cigar","tiger","fiver","st%nd"));
        for (String word : words) {
            if (!wordle.isGameOver()) {
                wordle.addGuess(word);
            }
        }
        assertEquals(wordle.isGameOver(), false);
    }
    
    /**
     * The test is to check whether the game is over or not.
     * The words list only contains 3 valid guessed words and the minimum requirement is 6.
     * This should provoke wordle to continue the game until all 6 guessed words are added.
     * @throws IOException due to reading the files in wordle dictionary
     */
    @Test
    public void wordle_is_not_gameover_half_way() throws IOException{
        Wordle wordle = new Wordle();
        wordle.setAnswer("grade");
        ArrayList<String> words = new ArrayList<>(Arrays.asList("words","tests","cigar"));
        for (String word : words) {
            if (!wordle.isGameOver()) {
                wordle.addGuess(word);
            }
        }
        assertEquals(wordle.isGameOver(), false);
    }
}
