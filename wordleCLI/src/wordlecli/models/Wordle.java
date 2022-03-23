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

    /**
     * resets the game
     * @throws IOException when files does not exists
     */
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

    /**
     * Sets the fixed answer
     * Preconditions: answer != ""
     * Postconditions: answer = "{word}"
     * @param answer the word to be guessed
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    /**
     * returns a row count
     * Preconditions: rowCount >= 0
     * Postconditions: rowCount == 6
     * @return rowCount
     */
    public final int getRowCount() {
        return rowCount;
    }

    /**
     * returns a column count
     * Preconditions: colCount >= 0
     * Postconditions: colCount == 5
     * @return colCount
     */
    public final int getColCount() {
        return colCount;
    }

    /**
     * returns a number of guess attempts
     * Preconditions: currentTries >= 0
     * Postconditions: currentTries <= 6
     * @return currentTries
     */
    public int getCurrentTries() {
        return currentTries;
    }
    
    /**
     * returns an array list of the keyboard
     * Preconditions: keyboard.size() > 0
     * Postconditions: keyboard
     * @return keyboard
     */
    public ArrayList getKeyboard() {
        assert !keyboard.isEmpty();
        return keyboard;
    }

    /**
     * returns a letter from keyboard array list
     * Preconditions: index >= 0
     * Postconditions: String
     * @param index an int used to select a position on the array list
     * @return String in keyboard
     */
    public String getKeyboardIndex(int index) {
        assert index >= 0 && index < getKeyboard().size();
        return keyboard.get(index);
    }

    /**
     * returns the number of guesses
     * Preconditions: guesses.size() >= 0
     * Postconditions: guesses less than getRowCount()
     * @return guesses
     */
    public int countGuesses() {
        assert guesses.size() <= getRowCount();
        return guesses.size();
    }

    /**
     * returns a guessed word from guesses array list
     * Preconditions: index >= 0
     * Postconditions: String
     * @param index an int used to select a position on the array list
     * @return String in guesses
     */
    public String getGuessIndex(int index) {
        assert index >= 0 && index < countGuesses();
        return guesses.get(index);
    }

    /**
     * returns a word to be guessed
     * Preconditions: answer != ""
     * Postconditions: answer
     * @return answer
     */
    public final String getAnswer() {
        return answer;
    }

    /**
     * returns the current word being guessed
     * Preconditions: currentGuess != ""
     * Postconditions: currentGuess += addGuess(word)
     * @return currentGuess
     */
    public String getCurrentWord() {
        return currentGuess;
    }

    /**
     * updates the keyboard when guessed a word
     * Preconditions: validWord(word) == true
     * Postconditions: letters += letterInList
     * @param word guessed word to update keyboard
     * @return String
     */
    public String updateKeyboard(String word) {
        assert validWord(word);
        String letters = "keyboard:\n";
        updateLettersInKeyboard(word);
        for (Object letterInList : getKeyboard()) {
            letters += letterInList + " ";
        }
        return letters;
    }

    /**
     * returns when a game has won
     * Preconditions: getAnswer().length() == getColCount()
     * Postconditions: guesses.contains(getAnswer()) == true or guesses.contains(getAnswer()) == false
     * @return true or false
     */
    public boolean hasWon() {
        assert getAnswer().length() == getColCount();
        return guesses.contains(getAnswer());
    }

    /**
     * returns when a game has lost
     * Preconditions: getRowCount() == 6
     * Postconditions: guesses.size() == getRowCount() == true or guesses.size() == getRowCount() == false
     * @return true or false
     */
    public boolean hasLost() {
        assert getRowCount() == 6;
        return guesses.size() == getRowCount();
    }

    /**
     * returns when the game is over
     * Preconditions: guesses.contains(getAnswer()) || guesses.size() == getRowCount()
     * Postconditions: hasWon() == true || hasWon() == false || hasLost() == true || hasLost() == false
     * @return true or false
     */
    public boolean isGameOver() {
        return hasWon() || hasLost();
    }

    /**
     * returns if guessed word is in the dictionary
     * Preconditions: validWord(word)
     * Postconditions: dictionary.containsTargetWord(word) == true || dictionary.containsValidWord(word) == false || 
     * dictionary.containsTargetWord(word) == true || dictionary.containsValidWord(word) == false
     * @param word guessed word to search
     * @return true or false
     */
    public boolean inDictionary(String word) {
        assert validWord(word);
        return dictionary.containsTargetWord(word) || dictionary.containsValidWord(word);
    }

    /**
     * checks if the letter in guessed word is at the correct place
     * Preconditions: index >= 0
     * Postconditions: nthChar == getAnswer().charAt(index) == true || nthChar == getAnswer().charAt(index) == false
     * @param index position in the guessed word
     * @param nthChar letter in the guessed word
     * @return true or false
     */
    public boolean matchedLetter(int index, char nthChar) {
        assert index >= 0 && index < getColCount();
        return nthChar == getAnswer().charAt(index);
    }

    /**
     * checks if the letter in guessed word is correct but not in correct place
     * Preconditions: nthChar != ""
     * Postconditions: getAnswer().contains(String.valueOf(nthChar)) == true || getAnswer().contains(String.valueOf(nthChar)) == false
     * @param nthChar letter in the guessed word
     * @return true or false
     */
    public boolean mismatchedLetter(char nthChar) {
        return getAnswer().contains(String.valueOf(nthChar));
    }

    /**
     * adds the guessed word to wordle
     * Preconditions: getColCount() == 5
     * Postconditions: guesses.add(word);
     * @param word guessed word to be added
     */
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
    
    /**
     * sets the current guessed word
     * Preconditions: validWord(word)
     * Postconditions: currentGuess = word
     * @param word guessed word to be set
     */
    private void setCurrentWord(String word) {
        assert validWord(word);
        this.currentGuess = word;
    }
    
    /**
     * checks if the guessed word is valid to be added into wordle
     * Preconditions: word != null
     * Postconditions: word.length() == getColCount() && inDictionary(word) == true || word.length() == getColCount() && inDictionary(word) == false
     * @param word guessed word to validate
     * @return true or false
     */
    private boolean validWord(String word) {
        return word.length() == getColCount() && inDictionary(word);
    }

    /**
     * updates the keyboard array list if letter in guessed word is not in the answer
     * Preconditions: validWord(word) == true
     * Postconditions: keyboard.remove(String.valueOf(nthChar).toUpperCase())
     * @param guess guessed word to update the keyboard array list accordingly
     */
    private void updateLettersInKeyboard(String guess) {
        assert validWord(guess);
        for (int index = 0; index < guess.length(); index++) {
            char nthChar = guess.charAt(index);
            if (!matchedLetter(index, nthChar) && !mismatchedLetter(nthChar)) {
                keyboard.remove(String.valueOf(nthChar).toUpperCase());
            }
        }
    }
}