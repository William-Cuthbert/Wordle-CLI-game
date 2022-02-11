package wordlecli.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WordDictionary {
    
    private final List<String> words;
    
    /**
     *
     * @param filePath
     * @throws IOException
     */
    public WordDictionary(String filePath) throws IOException {
        this.words = Files.readAllLines(Paths.get(filePath)).stream().collect(Collectors.toList());
    }
    
    /**
     *
     * @return
     */
    public String getRandomWord() {
        return words.get(new Random().nextInt(words.size()));
    }
    
    /**
     *
     * @param word
     * @return
     */
    public boolean containsWord(String word) {
        return words.contains(word);
    }
}
