import java.util.Random;

/**
 * Die represents a single dice with a specified number of sides.
 * By default, it has 6 sides. You can roll it to get a random value
 * between 1 and the number of sides (inclusive).
 * 
 * @author Brandon Egna
 * @version 1.0
 */
public class Die {
    private final int sides;
    private int currentVal;
    private static final Random random = new Random();
    
    /**
     * Constructs a standard 6-sided die and rolls it once to
     * initialize its current value.
     */
    public Die() {
        this.sides = 6;
        roll();
    }

    /**
     * Constructs a die with a specified number of sides and
     * rolls it once to initialize its current value.
     * 
     * @param sideNum the number of sides for this die (must be >= 2)
     * @throws IllegalArgumentException if sideNum is less than 2
     */
    public Die(int sideNum) throws IllegalArgumentException{
        if (sideNum < 2) {
            throw new IllegalArgumentException();
        }
        this.sides = sideNum;
        roll();
    }

    /**
     * Rolls the die and updates its current value to a random
     * integer between 1 and the number of sides (inclusive).
     */
    public final void roll() {
        this.currentVal = random.nextInt(this.sides) + 1;
    }

    /**
     * Returns the current value of the die.
     * 
     * @return the current value of the die
     */
    public int getCurrentVal() {
        return currentVal;
    }
}