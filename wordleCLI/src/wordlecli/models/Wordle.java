package wordlecli.models;

import java.util.ArrayList;
import java.io.IOException;

public class Wordle {

    private boolean debugger;
    private int rowCount;
    private int colCount;
    private ArrayList<String> guesses;
    private String answer;
    private WordleDictionary dictionary;
    private final static String filePathToTargetWords = "C:/Users/wcuth/Documents/GitHub/wordleCLI-game/wordleCLI/dictionary/common.txt";
    private final static String filePathToGuessWords = "C:/Users/wcuth/Documents/GitHub/wordleCLI-game/wordleCLI/dictionary/words.txt";

    /**
     * sets up the instance of wordle game with answer generated
     * from wordle dictionary class.
     * @throws IOException due to read the files in wordle dictionary.
     */
    public Wordle() throws IOException {
        resetGame();
    }

    /**
     * sets up the game with the original states in place
     * when user wants to start a new game or restart during 
     * current game.
     * @throws IOException due to reading the files in wordle dictionary
     */
    public final void resetGame() throws IOException {
        assert this != null;
        this.debugger = true;
        this.rowCount = 6;
        this.colCount = 5;
        this.guesses = new ArrayList<>();
        this.dictionary = new WordleDictionary(filePathToTargetWords, filePathToGuessWords);
        this.answer = dictionary.getRandomWord();
    }

    /**
     * sets the debug mode of wordle
     * @param debug
     */
    public void setDebug(boolean debug) {
        this.debugger = debug;
    }

    /**
     * @return the debug state of wordle
     */
    public final boolean getDebug() {
        return debugger;
    }

    /**
     * @return the number of rows
     */
    public final int getRowCount() {
        assert rowCount != 0;
        return rowCount;
    }

    /**
     * @return the number of columns
     */
    public final int getColCount() {
        assert colCount != 0;
        return colCount;
    }

    /**
     * @return the guess list size
     */
    public int countGuesses() {
        assert !guesses.isEmpty();
        return guesses.size();
    }

    /**
     * getting the word value from the guess list
     * @param index used to pinpoint the index position in the list
     * @return the word value at the index position int the list
     */
    public final String getGuessIndex(int index) {
        assert index >= 0 && index <= getRowCount();
        return guesses.get(index);
    }

    /**
     * sets the answer state for debugging purposes.
     * @param answer used to set the answer for the game
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * @return the answer for the current game
     */
    public final String getAnswer() {
        assert answer != null;
        return answer;
    }

    /**
     * checks whether the user has won the game
     * @return true or false
     */
    public boolean hasWon() {
        return guesses.contains(getAnswer());
    }

    /**
     * checks whether the user has lost the game
     * @return true or false
     */
    public boolean hasLost() {
        return guesses.size() == getRowCount();
    }

    /**
     * check whether the game is over
     * @return true or false from hasWon() or hasLost() methods
     */
    public boolean isGameOver() {
        return hasWon() || hasLost();
    }

    /**
     * checks if word is valid then
     * adds the word to the guess list
     * @param word used to identify the word to validate
     * before adding to the guess list
     */
    public void addGuess(String word) {
        assert word != null;
        if (word.length() == getColCount() && dictionary.containsTargetWord(word) || dictionary.containsValidWord(word)) {
            guesses.add(word);
        }
    }

    /**
     * checks whether the word is or not in wordle dictionary as 
     * a way of validating
     * @param word used to identify if the dictionary contains the word or not
     * @return true or false
     */
    public boolean notInDictionary(String word) {
        return !dictionary.containsValidWord(word) && !dictionary.containsTargetWord(word);
    }
}
