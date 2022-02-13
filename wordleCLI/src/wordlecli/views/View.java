package wordlecli.views;

import wordlecli.models.Wordle;

public class View {
    private static String title = "wordle"; //==================\nWORDLE\n==================\n";
    private static String leftPadding = " ";
    
    private enum Color {
        
        YELLOW("\033[0;103m"),
        GREEN("\033[0;102m");
        
        private final String backgroundColor;
        private final static String ANSI_RESET = "\u001B[0n";
        
        private Color(String backgroundColor) {
            this.backgroundColor = backgroundColor;
        }
    }
    
    public static void setTitle(String str) {
        title = str;
    }
    
    public static void requestInput() {
        System.out.println("Enter a valid word:\n");
    }
    
    public static void printAnswer(String answer) {
        System.out.println("Answer:\n " + answer);
    }
    
    public static void cleanUp() {
        System.out.flush();
    }
    public static void printGameBoard(Wordle wordleGame) {
        System.out.println(title);
        for (int i = 0; i < wordleGame.getRowCount(); i++) {
            if (i < wordleGame.countGuesses()) {
                System.out.println(compareGuessToAnswer(wordleGame.getGuessIndex(i), wordleGame.getAnswer()));
            } else {
                System.out.println(leftPadding + " |".repeat(wordleGame.getColCount() -1));
            }
            
            if (i != wordleGame.getRowCount() -1) {
                System.out.println(leftPadding + "-".repeat(wordleGame.getColCount() * 2 -1));
            } else {
                System.out.println(leftPadding + "");
            }
        }
    }
    
    private static String compareGuessToAnswer(String word, String answer) {
        assert word != null && answer != null;
        String result = "";
        for (int ch = 0; ch < word.length(); ch++) {
            char getChar = word.charAt(ch);
            if (ch < word.length() && getChar == answer.charAt(ch)) {
                result += Color.GREEN + Character.toString(getChar) + Color.ANSI_RESET;
            } else if (answer.contains(String.valueOf(getChar))) {
                result += Color.YELLOW + Character.toString(getChar) + Color.ANSI_RESET;
            } else {
                result += getChar;
            }
            if (ch != word.length() -1) {
                result += "|";
            }
        }       
        return leftPadding + result;
    }
}
