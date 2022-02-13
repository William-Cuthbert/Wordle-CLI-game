package wordlecli.app;

import wordlecli.models.Wordle;

public class View {
    private static String title = "wordle"; //==================\nWORDLE\n==================\n";
    private static String leftPadding = " ";
    private String backgroundColor;
    private final String ANSI_RESET = "\u001B[0n";
    
    public static void setTitle(String str) {
        title = str;
    }
    
    public static void printGameBoard(Wordle wordleGame) {
        System.out.println(title);
        for (int i = 0; i < wordleGame.getRowCount(); i++) {
            if (i < wordleGame.countGuesses()) {
                System.out.println(wordleGame.compareGuessToAnswer(wordleGame.getGuessIndex(i), wordleGame.getAnswer()));
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
}
