package wordlecli.app;

import java.io.IOException;
import java.util.Scanner;
import wordlecli.models.Wordle;
import wordlecli.views.View;

public class Main {

    public static void main(String[] args) throws IOException {

        boolean debugger = true;
        Wordle wordle_game = new Wordle();

        try (Scanner guess = new Scanner(System.in)) {
            String input;

            while (!wordle_game.isGameOver()) {
                View.cleanUp();
                View.printGameBoard(wordle_game);

                if (debugger) {
                    View.printAnswer(wordle_game.getAnswer());
                }

                View.requestInput();
                input = guess.nextLine();
                
                while (wordle_game.notInDictionary(input)) {
                    View.validating_message();
                    View.requestInput();
                    input = guess.nextLine();
                }

                wordle_game.addGuess(input);
            }

            View.cleanUp();
            View.printGameBoard(wordle_game);
            View.printAnswer(wordle_game.getAnswer());
            guess.close();

            View.result_message(wordle_game);
        }
    }
}
