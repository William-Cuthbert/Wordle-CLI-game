package wordlecli.app;

import wordlecli.models.Wordle;

public class View {
    private static String title = "wordle"; //==================\nWORDLE\n==================\n";
    private static String leftPadding = " ";
    private String backgroundColor;
    private String ANSI_RESET = "\u001B[0n";
    
    public static void setTitle(String str) {
        title = str;
    }
    
    public static void setLeftPadding(String str) {
        leftPadding = str;
    }
    
    public static void printGameBoard(Wordle model) {
        System.out.println(title);
        for (int i = 0; i < model.getRowCount(); i++) {
            if (i < model.countGuesses()) {
                
            } else {
                
            }
        }
    }
}
