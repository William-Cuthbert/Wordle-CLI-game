package wordlecli.models;

import java.io.IOException;
import java.util.*;

public final class Wordle extends Observable {

    private int rowCount, colCount, currentTries;
    private String answer, currentGuess;
    private ArrayList<String> guesses, keyboard;
    private WordleDictionary dictionary;

    public Wordle() throws IOException {
        resetGame();
    }

    public final void resetGame() throws IOException {
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
    
    public final int getRowCount() {
        return rowCount;
    }

    public final int getColCount() {
        return colCount;
    }

    public int getCurrentTries() {
        return currentTries;
    }
    
    public ArrayList getKeyboard() {
        return keyboard;
    }

    public String getKeyboardIndex(int index) {
        assert index >= 0 && index < getKeyboard().size();
        return keyboard.get(index);
    }

    public int countGuesses() {
        assert guesses.size() <= getRowCount();
        return guesses.size();
    }

    public String getGuessIndex(int index) {
        assert index >= 0 && index < countGuesses();
        return guesses.get(index);
    }

    public final String getAnswer() {
        return answer;
    }

    public String getCurrentWord() {
        return currentGuess;
    }

    public String updateKeyboard(String word) {
        assert validWord(word);
        String letters = "keyboard:\n";
        compareLettersInKeyboard(word);
        for (Object letterInList : getKeyboard()) {
            letters += letterInList + " ";
        }
        return letters;
    }

    public boolean hasWon() {
        assert getAnswer().length() == getColCount();
        return guesses.contains(getAnswer());
    }

    public boolean hasLost() {
        assert getRowCount() == 6;
        return guesses.size() == getRowCount();
    }

    public boolean isGameOver() {
        return hasWon() || hasLost();
    }

    public boolean inDictionary(String word) {
        return dictionary.containsTargetWord(word) || dictionary.containsValidWord(word);
    }

    public boolean matchedLetter(int index, char nthChar) {
        assert index >= 0 && index < getColCount();
        return nthChar == getAnswer().charAt(index);
    }

    public boolean mismatchedLetter(char nthChar) {
        return getAnswer().contains(String.valueOf(nthChar));
    }

    public void addGuess(String word) {
        assert getColCount() == 5;
        word = word.toLowerCase();
        if (validWord(word)) {
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
    
    private boolean validWord(String word) {
        return word.length() == getColCount() && inDictionary(word);
    }

    private void compareLettersInKeyboard(String guess) {
        assert guess.length() == getColCount();
        for (int index = 0; index < guess.length(); index++) {
            char nthChar = guess.charAt(index);
            if (!matchedLetter(index, nthChar) && !mismatchedLetter(nthChar)) {
                keyboard.remove(String.valueOf(nthChar).toUpperCase());
            }
        }
    }
}