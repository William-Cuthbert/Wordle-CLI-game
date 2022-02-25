package wordlecli.models;

import java.util.ArrayList;
import java.io.IOException;

public class Wordle {

    private int rowCount;
    private int colCount;
    private ArrayList<String> guesses;
    private String answer;
    private final static String filePath = "C:/Users/wcuth/Documents/GitHub/wordleCLI-game/wordleCLI/dictionary/common.txt";
    private WordDictionary dictionary;

    /**
     *
     * @throws IOException
     */
    public Wordle() throws IOException {
        setUpWord(filePath);
    }
    
    /**
     *
     * @param filePath
     */
    private void setUpWord(String filePath) throws IOException {
        assert this != null;
        this.rowCount = 6;
        this.colCount = 5;
        this.guesses = new ArrayList<>();
        this.dictionary = new WordDictionary(filePath);
        this.answer = dictionary.getRandomWord();
    }
    
    /**
     *
     * @return
     */
    public int getRowCount() {
        assert rowCount != 0;
        return rowCount;
    }
    
    /**
     *
     * @return
     */
    public int getColCount() {
        assert colCount != 0;
        return colCount;
    }
    
    /**
     *
     * @return
     */
    public int countGuesses() {
        assert !guesses.isEmpty();
        return guesses.size();
    }
    
    /**
     *
     * @param index
     * @return
     */
    public final String getGuessIndex(int index) {
        assert index >= 0 && index <= 6;
        return guesses.get(index);
    }
    
    /**
     *
     * @return
     */
    public final String getAnswer() {
        assert answer != null;
        return answer;
    }
    
    /**
     *
     * @return
     */
    public boolean hasWon() {
        assert guesses.size() >= 1;
        return guesses.contains(getAnswer());
    }
    
    /**
     *
     * @return
     */
    public boolean hasLost() {
        return guesses.size() == getRowCount();
    }
    
    /**
     *
     * @return
     */
    public boolean isGameOver() {
        return hasWon() || hasLost();
    }
    
    /**
     *
     * @param str
     */
    public void addGuess(String str) {
        assert str.length() == getRowCount() && dictionary.containsWord(str);
        guesses.add(str);
    }
}
