package wordlecli.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WordleDictionary {

    private final List<String> targetWords;
    private final List<String> validWords;

    /**
     * sets up the wordle dictionary
     * creates two lists to store both target and valid words.
     * @param filePathToTargetWords is used to find the file address to the target words 'common.txt'
     * @param filePathToValidWords is used to find the file address to the valid words 'word.txt'
     * @throws IOException due to reading files from.
     */
    public WordleDictionary(String filePathToTargetWords, String filePathToValidWords) throws IOException {
        this.targetWords = Files.readAllLines(Paths.get(filePathToTargetWords)).stream().collect(Collectors.toList());
        this.validWords = Files.readAllLines(Paths.get(filePathToValidWords)).stream().collect(Collectors.toList());
    }

    /**
     * selects a word from the target file
     * @return a word from the target list
     */
    public final String getRandomWord() {
        return targetWords.get(new Random().nextInt(targetWords.size()));
    }

    /**
     * checks if word is in the target list
     * @param word used to pinpoint specific word in the target list
     * @return true or false
     */
    public boolean containsTargetWord(String word) {
        return targetWords.contains(word);
    }

    /**
     * checks if word is in the valid list
     * @param word used to pinpoint specific word in the valid list
     * @return true or false
     */
    public boolean containsValidWord(String word) {
        return validWords.contains(word);
    }
}
