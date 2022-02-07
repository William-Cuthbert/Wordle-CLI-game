package wordlecli;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CLIModel {

    private final int rowCount;
    private final int colCount;
    private final ArrayList<String> guesses;
    private List<String> words;
    private final String answer;
    private final String filePath;

    public CLIModel() throws IOException {
        this.filePath = "dictonary/common.txt";
        initialised(filePath);
        this.rowCount = 5;
        this.colCount = 6;
        this.guesses = new ArrayList<>();
        this.answer = generateAnswer();
    }

    /**
     *
     * @return
     */
    public int getRowCount() {
        return rowCount;
    }
    
    /**
     *
     * @return
     */
    public int getColCount() {
        return colCount;
    }
    
    /**
     *
     * @return
     */
    public int countGuesses() {
        return guesses.size();
    }
    
    /**
     *
     * @param index
     * @return
     */
    public final String getGuess(int index) {
        return guesses.get(index);
    }
    
    /**
     *
     * @return
     */
    public final String getAnswer() {
        return answer;
    }
    
    /**
     *
     * @return
     */
    public boolean hasWon() {
        return guesses.contains(getAnswer());
    }
    
    /**
     *
     * @return
     */
    public boolean isGameOver() {
        return hasWon() || countGuesses() == getColCount();
    }
    
    /**
     *
     * @param str
     */
    public void guess(String str) {
        if (str.length() == getRowCount()) {
            guesses.add(str);
        }
    }
    
    /**
     *
     * @param filePath
     */
    private void initialised(String filePath) throws IOException {
        this.words = Files.readAllLines(Paths.get(filePath))
                .stream().collect(Collectors.toList());
    }
    
    /**
     *
     * @return
     */
    private String generateAnswer() {
        return words.get(new Random().nextInt(words.size()));
    }
}

