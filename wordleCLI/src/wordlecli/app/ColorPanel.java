package wordlecli.app;

/**
 * helps to highlight the individual characters in the word to
 * indicate whether they are in the right place or not or not part of 
 * the word.
 * 
 * uses string unicodes to pinpoint a colour to highlight.
 * @author wcuth
 */
public enum ColorPanel {
    YELLOW("\u001B[43m"),
    GREEN("\u001B[42m"),
    GREY("\u001B[47m");

    public final String backgroundColor;
    public final static String backgroundReset = "\u001B[0m";

    private ColorPanel(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
