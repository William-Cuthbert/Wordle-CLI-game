package wordlecli.app;

import wordlecli.models.Wordle;

public class CommandLine {

    private static final String title = "\n==================\n     WORDLE\n==================\n";
    private static String format = " ";

    /**
     * asks for user's input
     */
    public static void requestInput() {
        System.out.print("Enter a valid word:\n");
    }

    /**
     * displays the answer on the screen
     * @param answer is used to format the string.
     */
    public static void displayAnswer(String answer) {
        System.out.println("Answer:\n " + answer);
    }

    /**
     * displays the message when user has won or lost
     * @param user
     */
    public static void resultMessage(Wordle user) {
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
    public static void validateMessage() {
        System.out.println("Please use a-z A-Z characters and write 5 letters only");
    }

    /**
     * clears up the command line using unicodes
     */
    public static void cleanUp() {
        System.out.print("\033\143");
        System.out.flush();
    }

    /**
     * displays the game board
     * @param wordle used to extract necessary logic from the model.
     */
    public static void printGameBoard(Wordle wordle) {
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
    private static void Comparison(String inputWord, String getAnswer) {
        assert inputWord != null && getAnswer != null;
        String result = "";
        for (int index = 0; index < inputWord.length(); index++) {
            char getChar = inputWord.charAt(index);
            if (index < inputWord.length() && getChar == getAnswer.charAt(index)) {
                result += toHighlight(Character.toString(getChar), ColorPanel.GREEN);
            } else if (getAnswer.contains(String.valueOf(getChar))) {
                result += toHighlight(Character.toString(getChar), ColorPanel.YELLOW);
            } else {
                result += toHighlight(Character.toString(getChar), ColorPanel.GREY);
            }

            if (index != inputWord.length() - 1) {
                result += "|";
            }
        }
        Formatting(result);
    }

    /**
     * highlights the char
     * @param character is the char to highlight
     * @param highlight is the colour to highlight.
     */
    private static String toHighlight(String character, ColorPanel highlight) {
        return highlight.backgroundColor + character + ColorPanel.backgroundReset;
    }

    /**
     * helps to format the game board
     * @param str is the string to add to the format.
     */
    private static void Formatting(String str) {
        System.out.println(format + str);
    }
}
