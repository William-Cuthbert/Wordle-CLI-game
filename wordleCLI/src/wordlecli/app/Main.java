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

                while (!View.validateInput(input)) {
                    System.out.println("Please use a-z A-Z characters or write 5 letters only");
                    View.requestInput();
                    input = guess.nextLine();
                }

                wordle_game.addGuess(input);
            }

            View.cleanUp();
            View.printGameBoard(wordle_game);
            View.printAnswer(wordle_game.getAnswer());
            guess.close();

            if (wordle_game.hasLost()) {
                System.out.println("==================\n     You lose!\n==================");
            } 
            
            if (wordle_game.hasWon()) {
                System.out.println("==================\n    Well done!\n==================");
            }
        }
    }
}
