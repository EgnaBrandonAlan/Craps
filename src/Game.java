import java.util.Scanner;

/**
 * Game represents a singular game of Craps. 
 * 
 * Each game involves two dice and follows standard Craps rules:
 * - First roll 7 or 11 -> win
 * - First roll 2, 3, 12 -> lose
 * - Otherwise, the first roll becomes the "point," and the player
 * tries to roll the point again before rolling a 7
 * 
 * This class handles game logic and user interaction for rolling
 * the dice and determining if they win or lose.
 * 
 * @author Brandon Egna
 * @version 1.0
 */
public class Game {
    private final Die die1;
    private final Die die2;
    private final Scanner in;

    /**
     * Constructs a Game with a given Scanner for user input.
     * 
     * @param in Scanner used to read user input
     */
    public Game(Scanner in) {
        this.in = in;
        this.die1 = new Die();
        this.die2 = new Die();
    }

    /**
     * Plays a single game of Craps.
     * 
     * @return true if the player wins, false if the player loses
     */
    public boolean playGame() {
        int sum = firstRoll();
        
        if (sum == 7 || sum == 11) {
            System.out.println("You win!");
            return true;
        } else if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("You lose!");
            return false;
        }

        System.out.println("That's your point.");
        int point = sum;
        System.out.println("Let's see if you can roll it again before you roll a 7!");
        return pointRoll(point);
    }

    private int firstRoll() {
        int sum = rollDice();
        System.out.printf("Your first roll is: %d%n", sum);
        return sum;
    }

    private boolean pointRoll(int point) {
        while (true) { 
            int sum = rollDice();
            
            System.out.printf("You rolled: %d%n", sum);

            if (sum == point) {
                System.out.println("You rolled your point! You won!");
                return true;
            } else if (sum == 7) {
                System.out.println("You rolled a 7! You lose!");
                return false;
            } else {
                System.out.println("Keep rolling...");
            }
        }
    }

    private int rollDice() {
        System.out.printf("Press `<Enter>` to roll the dice...%n> ");
        in.nextLine();

        die1.roll();
        die2.roll();

        return die1.getCurrentVal() + die2.getCurrentVal();
    }
}