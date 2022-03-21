package wordlecli.views;

import wordlecli.models.Wordle;

public class CommandLine {

    private final String title = "\n==================\n     WORDLE\n==================\n";
    private String format = "    ";
    private Wordle wordle;
    
    public CommandLine(Wordle wordle) {
        this.wordle = wordle;
    }

    /**
     * asks for user's input
     */
    public void getInput() {
        System.out.print("Enter a valid word:\n");
    }

    /**
     * displays the answer on the screen
     * @param answer is used to format the string.
     */
    public void printAnswer(String answer) {
        System.out.println("Answer:\n" + answer);
    }

    public void printKeyboard(String word) {
        System.out.println(wordle.updateKeyboard(word));
    }
    
    /**
     * displays the message when user has won or lost
     * @param user
     */
    public void resultMessage(Wordle user) {
        if (user.hasLost()) {
            System.out.println("==================\n    You lose!\n==================");
        }
        if (user.hasWon()) {
            System.out.println("==================\n    Well done!\n==================");
        }
    }

    /**
     * displays the message to prompt for user to enter valid characters
     */
    public void validateMessage() {
        System.out.println("Please use a-z A-Z characters and write 5 letters only");
    }

    /**
     * clears up the command line using unicodes
     */
    public void clear() {
        System.out.flush();
    }

    /**
     * displays the game board
     * @param wordle used to extract necessary logic from the model.
     */
    public void printGameBoard(Wordle wordle) {
        System.out.println(title);
        for (int i = 0; i < wordle.getRowCount(); i++) {
            if (i < wordle.countGuesses()) {
                Comparison(wordle.getGuessIndex(i), wordle.getAnswer());
            } else {
                Formatting(" |".repeat(wordle.getColCount() - 1));
            }

            if (i != wordle.getRowCount() - 1) {
                Formatting("-".repeat(wordle.getColCount() * 2 - 1));
            } else {
                Formatting("");
            }
        }
    }

    /**
     * compares the input word to the answer and highlights each character.
     * @param inputWord gets the word from the guess list
     * @param getAnswer gets the answer from wordle.
     */
    private void Comparison(String inputWord, String getAnswer) {
        assert inputWord != null && getAnswer != null;
        String result = "";
        for (int index = 0; index < inputWord.length(); index++) {
            char getChar = inputWord.charAt(index);
            result += getChar;
            if (index != inputWord.length() - 1) {
                result += "|";
            }
        }
        Formatting(result);
    }

    /**
     * helps to format the game board
     * @param str is the string to add to the format.
     */
    private void Formatting(String str) {
        System.out.println(format + str);
    }
}
