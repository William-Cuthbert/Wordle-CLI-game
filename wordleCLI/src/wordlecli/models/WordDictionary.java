package wordlecli.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WordDictionary {

    private final List<String> targetWords;
    private final List<String> validWords;

    /**
     *
     * @param filePathToTargetWords
     * @param filePathToValidWords
     * @throws IOException
     */
    public WordDictionary(String filePathToTargetWords, String filePathToValidWords) throws IOException {
        this.targetWords = Files.readAllLines(Paths.get(filePathToTargetWords)).stream().collect(Collectors.toList());
        this.validWords = Files.readAllLines(Paths.get(filePathToValidWords)).stream().collect(Collectors.toList());
    }

    /**
     *
     * @return
     */
    public final String getRandomWord() {
        return targetWords.get(new Random().nextInt(targetWords.size()));
    }

    /**
     *
     * @return
     */
    public final String getFixedWord() {
        return targetWords.get(5);
    }

    /**
     *
     * @param word
     * @return
     */
    public boolean containsTargetWord(String word) {
        return targetWords.contains(word);
    }

    /**
     *
     * @param word
     * @return
     */
    public boolean containsValidWord(String word) {
        return validWords.contains(word);
    }
}
