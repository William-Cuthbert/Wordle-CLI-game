package wordlecli.models;

import java.io.IOException;
import java.util.*;

public final class Wordle extends Observable {

    private boolean debugger;
    private int rowCount, colCount, currentTries;
    private static String answer;
    private String currentGuess;
    private static ArrayList<String> guesses, keyboard;
    private WordleDictionary dictionary;

    public Wordle() throws IOException {
        resetGame();
    }

    public final void resetGame() throws IOException {
        this.debugger = true;
        this.rowCount = 6;
        this.colCount = 5;
        this.currentTries = 0;
        this.currentGuess = "";
        this.guesses = new ArrayList<>();
        this.keyboard = new ArrayList<>(Arrays.asList("Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"));
        this.dictionary = new WordleDictionary();
        this.answer = dictionary.getRandomWord();
        setChanged();
        notifyObservers();
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public final boolean getDebug() {
        return debugger;
    }
    
    public final int getRowCount() {
        return rowCount;
    }

    public final int getColCount() {
        return colCount;
    }

    public int getCurrentTries() {
        return currentTries;
    }
    
    public static ArrayList getKeyboard() {
        return keyboard;
    }

    public int getKeyboardSize() {
        return keyboard.size();
    }

    public String getKeyboardIndex(int index) {
        return keyboard.get(index);
    }

    public int countGuesses() {
        return guesses.size();
    }

    public String getGuessIndex(int index) {
        return guesses.get(index);
    }

    public static final String getAnswer() {
        return answer;
    }

    public String getCurrentWord() {
        return currentGuess;
    }

    public static String updateKeyboard(String word) {
        String letters = "keyboard:\n";
        compareLettersInKeyboard(word, getAnswer());
        for (Object letterInList : getKeyboard()) {
            letters += letterInList + " ";
        }
        return letters;
    }

    public boolean hasWon() {
        return guesses.contains(getAnswer());
    }

    public boolean hasLost() {
        return guesses.size() == getRowCount();
    }

    public boolean isGameOver() {
        return hasWon() || hasLost();
    }

    public boolean isInDictionary(String word) {
        return dictionary.containsTargetWord(word) || dictionary.containsValidWord(word);
    }

    public boolean notInDictionary(String word) {
        return !dictionary.containsValidWord(word) && !dictionary.containsTargetWord(word);
    }

    public static boolean matchedLetter(int index, char nthChar, String getAnswer) {
        return nthChar == getAnswer.charAt(index);
    }

    public static boolean mismatchedLetter(char nthChar, String getAnswer) {
        return getAnswer.contains(String.valueOf(nthChar));
    }

    public void addGuess(String word) {
        word = word.toLowerCase();
        if (validatingWord(word)) {
            setCurrentWord(word);
            guesses.add(word);
            currentTries++;
            setChanged();
            notifyObservers();
        }
    }
    
    private void setCurrentWord(String word) {
        this.currentGuess = word;
    }
    
    private boolean validatingWord(String word) {
        return word.length() == getColCount() && isInDictionary(word);
    }

    private static void compareLettersInKeyboard(String guess, String getAnswer) {
        assert guess != null && getAnswer != null;
        for (int index = 0; index < guess.length(); index++) {
            char nthChar = guess.charAt(index);
            if (!matchedLetter(index, nthChar, getAnswer) && !mismatchedLetter(nthChar, getAnswer)) {
                keyboard.remove(String.valueOf(nthChar).toUpperCase());
            }
        }
    }

    public void setDebug(boolean debug) {
        this.debugger = debug;
    }
}
