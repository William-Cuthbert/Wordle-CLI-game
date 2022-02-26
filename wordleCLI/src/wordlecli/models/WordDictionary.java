package wordlecli.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WordDictionary {
    
    private final List<String> targetWords;
    private final List<String> guessWords;
    
    /**
     *
     * @param filePath1
     * @param filePath2
     * @throws IOException
     */
    public WordDictionary(String filePath1, String filePath2) throws IOException {
        this.targetWords = Files.readAllLines(Paths.get(filePath1)).stream().collect(Collectors.toList());
        this.guessWords = Files.readAllLines(Paths.get(filePath2)).stream().collect(Collectors.toList());
    }
    
    /**
     *
     * @return
     */
    public String getRandomWord() {
        return targetWords.get(new Random().nextInt(targetWords.size()));
    }
    
    /**
     *
     * @param word
     * @return
     */
    public boolean containsTargetWords(String word) {
        return targetWords.contains(word);
    }
    
    /**
     *
     * @param word
     * @return
     */
    public boolean containsGuessWords(String word) {
        return guessWords.contains(word);
    }
}
