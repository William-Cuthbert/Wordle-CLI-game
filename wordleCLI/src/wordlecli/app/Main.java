package wordlecli.app;

import wordlecli.views.CommandLine;
import java.io.IOException;
import java.util.Scanner;
import wordlecli.models.Wordle;

public class Main {

    public static void main(String[] args) throws IOException {
        
        Wordle wordle = new Wordle();
        CommandLine cli = new CommandLine(wordle);

        try (Scanner guessWord = new Scanner(System.in)) {
            String input;
            cli.printKeyboard("");

            while (!wordle.isGameOver()) {
                cli.clear();
                cli.printGameBoard(wordle);

                if (true) {
                    cli.printAnswer(wordle.getAnswer());
                }

                cli.getInput();
                input = guessWord.nextLine();
                
                while (!wordle.inDictionary(input)) {
                    cli.validateMessage();
                    cli.getInput();
                    input = guessWord.nextLine();
                }

                wordle.addGuess(input);
                cli.printKeyboard(input);
            }

            cli.clear();
            cli.printGameBoard(wordle);
            cli.printAnswer(wordle.getAnswer());
            cli.printKeyboard("");
            guessWord.close();

            cli.resultMessage();
        }
    }
}
