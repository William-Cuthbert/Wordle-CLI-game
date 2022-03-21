package wordlecli.app;

import java.io.IOException;
import java.util.Scanner;
import wordlecli.models.Wordle;

public class Main {

    public static void main(String[] args) throws IOException {
        run();
    }

    public static void run() throws IOException {
        Wordle wordle = new Wordle();
        CommandLine cli = new CommandLine(wordle);

        try (Scanner guessWord = new Scanner(System.in)) {
            String input;
            cli.printKeyboard();

            while (!wordle.isGameOver()) {
                cli.clear();
                cli.printGameBoard();

                if (true) {
                    cli.printAnswer();
                }

                cli.getInput();
                input = guessWord.nextLine();

                while (!wordle.inDictionary(input)) {
                    cli.validateMessage();
                    cli.getInput();
                    input = guessWord.nextLine();
                }

                wordle.addGuess(input);
                cli.printKeyboard();
            }

            cli.clear();
            cli.printGameBoard();
            cli.printAnswer();
            cli.printKeyboard();
            guessWord.close();

            cli.resultMessage();
        }
    }

    private static class CommandLine {

        private final String title = "\n==================\nWORDLE\n==================\n";
        private final String format = "    ";
        private final Wordle wordle;
        
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
         */
        public void printAnswer() {
            System.out.println("Answer:\n" + wordle.getAnswer());
        }

        public void printKeyboard() {
            System.out.println(wordle.updateKeyboard(wordle.getCurrentWord()));
        }

        /**
         * displays the message when user has won or lost
         */
        public void resultMessage() {
            if (wordle.hasLost()) {
                System.out.println("==================\n    You lose!\n==================");
            }
            if (wordle.hasWon()) {
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
         * clears up the command line
         */
        public void clear() {
            System.out.flush();
        }

        /**
         * displays the game board
         */
        public void printGameBoard() {
            System.out.println(title);
            for (int i = 0; i < wordle.getRowCount(); i++) {
                if (i < wordle.countGuesses()) {
                    addToFormat(wordle.getGuessIndex(i));
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
         */
        private void addToFormat(String inputWord) {
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
}
