package wordlecli.models;

import java.util.ArrayList;
import java.io.IOException;

public class Wordle {

    private boolean debugger;
    private int rowCount;
    private int colCount;
    private ArrayList<String> guesses;
    private String answer;
    private WordDictionary dictionary;
    private final static String filePathToTargetWords = "C:/Users/wcuth/Documents/GitHub/wordleCLI-game/wordleCLI/dictionary/common.txt";
    private final static String filePathToGuessWords = "C:/Users/wcuth/Documents/GitHub/wordleCLI-game/wordleCLI/dictionary/words.txt";

    /**
     *
     * @throws IOException
     */
    public Wordle() throws IOException {
        resetGame();
    }

    /**
     *
     * @param filePath
     */
    private void resetGame() throws IOException {
        assert this != null;
        this.debugger = true;
        this.rowCount = 6;
        this.colCount = 5;
        this.guesses = new ArrayList<>();
        this.dictionary = new WordDictionary(filePathToTargetWords, filePathToGuessWords);
        this.answer = dictionary.getRandomWord();
//        this.answer = dictionary.getFixedWord();
    }

    /**
     *
     * @param debug
     */
    public void setDebug(boolean debug) {
        this.debugger = debug;
    }

    /**
     *
     * @return
     */
    public final boolean getDebug() {
        return debugger;
    }

    /**
     *
     * @return
     */
    public final int getRowCount() {
        assert rowCount != 0;
        return rowCount;
    }

    /**
     *
     * @return
     */
    public final int getColCount() {
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
        assert index >= 0 && index <= getRowCount();
        return guesses.get(index);
    }

    /**
     *
     */
    public final void fixedAnswer() {
        this.answer = dictionary.getFixedWord();
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
     * @param word
     */
    public void addGuess(String word) {
        assert word != null;
        if (word.length() == getColCount() && dictionary.containsTargetWord(word) || dictionary.containsValidWord(word)) {
            guesses.add(word);
        }
    }

    /**
     *
     * @param word
     * @return
     */
    public boolean notInDictionary(String word) {
        return !dictionary.containsValidWord(word) && !dictionary.containsTargetWord(word);
    }
}
