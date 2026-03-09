import java.util.Scanner;

/**
 * Craps is a command line dice game.
 * The player can choose to play, read instructions, and roll the dice.
 * 
 * This class contains only the main method and uses Game and ConsoleUtil 
 * classes to manage game logic and user input.
 * 
 * @author Brandon Egna
 * @version 1.0
 */
class Craps { 
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            if (!ConsoleUtil.askYesNo(in, "Would you like to play Craps? (Y/n)", 'Y')) {
                System.out.println("Goodbye!");
                return;
            }
            
            if (ConsoleUtil.askYesNo(in, "Would you like to read the instructions before you begin? (y/N)", 'N')) {
                ConsoleUtil.viewInstruct();
            }

            Game game = new Game(in);

            do { 
                game.playGame();
            } while (ConsoleUtil.askYesNo(in, "Play again? (y/N)", 'N'));
        }
    }
}