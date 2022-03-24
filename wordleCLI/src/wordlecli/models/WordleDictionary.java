package wordlecli.models;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordleDictionary {

    private final List<String> targetWords, validWords;
    private final static String filePathToTargetWords = "..\\\\wordleCLI\\\\dictionary\\\\common.txt";
    private final static String filePathToGuessWords = "..\\\\wordleCLI\\\\dictionary\\\\words.txt";

    /**
     * sets up the wordle dictionary
     * creates two lists to store both target and valid words.
     * @throws IOException due to reading files from.
     */
    public WordleDictionary() throws IOException {
        this.targetWords = Files.readAllLines(Paths.get(filePathToTargetWords)).stream().collect(Collectors.toList());
        this.validWords = Files.readAllLines(Paths.get(filePathToGuessWords)).stream().collect(Collectors.toList());
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
