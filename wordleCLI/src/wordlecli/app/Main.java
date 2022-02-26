package wordlecli.app;

import java.io.IOException;
import java.util.Scanner;
import wordlecli.models.Wordle;

public class Main {

    public static void main(String[] args) throws IOException {
        
        Wordle wordle = new Wordle();
        wordle.setDebug(false);

        try (Scanner guessWord = new Scanner(System.in)) {
            String input;

            while (!wordle.isGameOver()) {
                CommandLine.cleanUp();
                CommandLine.printGameBoard(wordle);

                if (wordle.getDebug()) {
                    CommandLine.displayAnswer(wordle.getAnswer());
                }

                CommandLine.requestInput();
                input = guessWord.nextLine();
                
                while (wordle.notInDictionary(input)) {
                    CommandLine.validateMessage();
                    CommandLine.requestInput();
                    input = guessWord.nextLine();
                }

                wordle.addGuess(input);
            }

            CommandLine.cleanUp();
            CommandLine.printGameBoard(wordle);
            CommandLine.displayAnswer(wordle.getAnswer());
            guessWord.close();

            CommandLine.resultMessage(wordle);
        }
    }
}
