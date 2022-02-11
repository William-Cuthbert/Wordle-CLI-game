package wordlecli.interfaces;

public interface wordleStrategy {
    void addGuess(String str);
    boolean isGameOver();
    boolean hasWon();
    boolean hasLost();
    boolean compareGuessToAnswer(String word);
}
