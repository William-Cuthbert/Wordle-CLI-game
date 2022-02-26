package wordlecli.app;

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
