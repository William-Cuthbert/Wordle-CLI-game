package wordlecli.app;

import wordlecli.models.Wordle;

public class CommandLine {

    private static final String title = "\n==================\n     WORDLE\n==================\n";
    private static String format = " ";

    /**
     *
     */
    public static void requestInput() {
        System.out.print("Enter a valid word:\n");
    }

    /**
     *
     * @param answer
     */
    public static void displayAnswer(String answer) {
        System.out.println("Answer:\n " + answer);
    }

    /**
     *
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
     *
     */
    public static void validateMessage() {
        System.out.println("Please use a-z A-Z characters or write 5 letters only");
    }

    /**
     *
     */
    public static void cleanUp() {
        System.out.print("\033\143");
        System.out.flush();
    }

    /**
     *
     * @param wordleGame
     */
    public static void printGameBoard(Wordle wordleGame) {
        System.out.println(title);
        for (int i = 0; i < wordleGame.getRowCount(); i++) {
            if (i < wordleGame.countGuesses()) {
                Comparison(wordleGame.getGuessIndex(i), wordleGame.getAnswer());
            } else {
                Formatting(" |".repeat(wordleGame.getColCount() - 1));
            }

            if (i != wordleGame.getRowCount() - 1) {
                Formatting("-".repeat(wordleGame.getColCount() * 2 - 1));
            } else {
                Formatting("");
            }
        }
    }

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

    private static String toHighlight(String word, ColorPanel highlight) {
        return highlight.backgroundColor + word + ColorPanel.backgroundReset;
    }

    private static void Formatting(String str) {
        System.out.println(format + str);
    }
}
