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
     * @param sideNum the number of sides for this die (>= 2)
     * @throws IllegalArgumentException if sideNum < 2
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
    final public void roll() {
        this.currentVal = (int) (Math.random() * this.sides) + 1;
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