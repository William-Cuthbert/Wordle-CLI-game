package wordlecli.app;

import wordlecli.views.CommandLine;
import java.io.IOException;
import java.util.Scanner;
import wordlecli.models.Wordle;

public class Main {

    public static void main(String[] args) throws IOException {
        
        Wordle wordle = new Wordle();
        wordle.setDebug(true);

        try (Scanner guessWord = new Scanner(System.in)) {
            String input;
            CommandLine.printKeyboard("");

            while (!wordle.isGameOver()) {
                CommandLine.clear();
                CommandLine.printGameBoard(wordle);

                if (wordle.getDebug()) {
                    CommandLine.printAnswer(wordle.getAnswer());
                }

                CommandLine.getInput();
                input = guessWord.nextLine();
                
                while (wordle.notInDictionary(input)) {
                    CommandLine.validateMessage();
                    CommandLine.getInput();
                    input = guessWord.nextLine();
                }

                wordle.addGuess(input);
                CommandLine.printKeyboard(input);
            }

            CommandLine.clear();
            CommandLine.printGameBoard(wordle);
            CommandLine.printAnswer(wordle.getAnswer());
            CommandLine.printKeyboard("");
            guessWord.close();

            CommandLine.resultMessage(wordle);
        }
    }
}
