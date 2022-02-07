package wordlecli;

import java.util.ArrayList;

public class CLIModel {

    private final int rowCount;
    private final int colCount;
    private ArrayList<String> guesses;
    private final String answer;
    private String filePath;

    public CLIModel() {
        this.rowCount = 5;
        this.colCount = 6;
        this.guesses = new ArrayList<String>();
        this.filePath = "words.txt";
        this.answer = generateAnswer(filePath);
    }

    public int getRowCount() {
        return rowCount;
    }
    
    public int getColCount() {
        return colCount;
    }
    
    public int countGuesses() {
        return guesses.size();
    }
    
    public final String getGuess(int index) {
        return guesses.get(index);
    }
    
    public final String getAnswer() {
        return answer;
    }
    
    public boolean hasWon() {
        return guesses.contains(getAnswer());
    }
    
    public boolean isGameOver() {
        return hasWon() || countGuesses() == getColCount();
    }
    
    public void guess(String str) {
        if (str.length() == getRowCount()) {
            guesses.add(str);
        }
    }
    
    private String generateAnswer(String filePath) {
        return null;
    }
}

