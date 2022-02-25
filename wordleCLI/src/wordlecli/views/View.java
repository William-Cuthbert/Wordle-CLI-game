package wordlecli.views;

import wordlecli.models.Wordle;

public class View {

    private static final String title = "\n==================\n     WORDLE\n==================\n";
    private static String leftPadding = " ";

    private enum HIGHLIGHTER {
        
        YELLOW("\u001B[43m"),
        GREEN("\u001B[42m"),
        GREY("\u001B[47m");
        
        private final String backgroundColor;
        private final static String backgroundReset = "\u001B[0m";

        private HIGHLIGHTER(String backgroundColor) {
            this.backgroundColor = backgroundColor;
        }
    }

    /**
     *
     */
    public static void requestInput() {
        System.out.print("Enter a valid word:\n");
    }

    /**
     *
     * @param word
     * @return
     */
    public static boolean validateInput(String word) {
        assert word != null;
        boolean notValidWord = false;
        String special = " !#$%&'()*+,-./:;<=>?@[]^_`{|}~0123456789;";
        for (int i = 0; i < special.length(); i++) {
            char specialChar = special.charAt(i);
            for (int k = 0; k < word.length(); k++) {
                char charFromWord = word.charAt(k);
                if (specialChar == charFromWord) {
                    notValidWord = true;
                }
            }
        }
        return word.length() == 5 && !notValidWord;
    }

    /**
     *
     * @param answer
     */
    public static void printAnswer(String answer) {
        System.out.println("Answer:\n " + answer);
    }

    /**
     *
     */
    public static void reEnterInput() {
        System.out.print("Enter a valid word:\n");
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
                compareGuessToAnswer(wordleGame.getGuessIndex(i), wordleGame.getAnswer());
            } else {
                paddingFormat(" |".repeat(wordleGame.getColCount() - 1));
            }

            if (i != wordleGame.getRowCount() - 1) {
                paddingFormat("-".repeat(wordleGame.getColCount() * 2 - 1));
            } else {
                paddingFormat("");
            }
        }
    }

    private static void compareGuessToAnswer(String inputWord, String getAnswer) {
        assert inputWord != null && getAnswer != null;
        String result = "";
        for (int index = 0; index < inputWord.length(); index++) {
            char getChar = inputWord.charAt(index);
            if (index < inputWord.length() && getChar == getAnswer.charAt(index)) {
                result += toHighlight(Character.toString(getChar), HIGHLIGHTER.GREEN);
            } else if (getAnswer.contains(String.valueOf(getChar))) {
                result += toHighlight(Character.toString(getChar), HIGHLIGHTER.YELLOW);
            } else {
                //result += getChar;
                result += toHighlight(Character.toString(getChar),HIGHLIGHTER.GREY);
            }

            if (index != inputWord.length() - 1) {
                result += "|";
            }
        }
        paddingFormat(result);
    }

    private static String toHighlight(String word, HIGHLIGHTER highlight) {
        return highlight.backgroundColor + word + HIGHLIGHTER.backgroundReset;
    }

    private static void paddingFormat(String str) {
        System.out.println(leftPadding + str);
    }
}
