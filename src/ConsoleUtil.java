import java.io.IOException;
import java.util.Scanner;

/**
 * ConsoleUtil provides utility methods for console-based input
 * and output.
 * 
 * Includes methods for yes/no prompts and displaying instructions
 * from a file. All methods are static.
 * 
 * @author Brandon Egna
 * @version 1.0
 */
public final class ConsoleUtil {
    private ConsoleUtil() throws AssertionError {
        throw new AssertionError("Utility class should not be instantiated.");
    }

    /**
     * Prompts the user with a yes/no question and reads their input.
     * Returns true if the answer is 'Y' or defaultValue indicates yes,
     * and false if the answer is 'N' or defaultValue indicates no.
     * 
     * If the user enters nothing, the default value is selected.
     * 
     * @param in Scanner used for reading user input
     * @param prompt The question being displayed to the user
     * @param defaultValue The default response for empty inputs
     * @return true if the user answers yes, false if no
     * @throws IllegalArgumentException if the defaultValue is not Y or N
     */
    public static boolean askYesNo(Scanner in, String prompt, char defaultValue) throws IllegalArgumentException {
        if (in == null) {
            throw new IllegalArgumentException("Scanner cannot be null.");
        }
        
        defaultValue = Character.toUpperCase(defaultValue);

        if (defaultValue != 'Y' && defaultValue != 'N') {
            throw new IllegalArgumentException("defaultValue must be Y or N.");
        }
        
        while (true) {
            System.out.printf("%s%n> ", prompt);
            String input = in.nextLine().trim();

            if (input.isEmpty()) return defaultValue == 'Y';

            char c = Character.toUpperCase(input.charAt(0));

            if (c == 'Y') return true;
            if (c == 'N') return false;

            System.out.printf("Please enter Y or N.%n> ");
        }
    }

    /**
     * Reads the "instructions.txt" file and displays it to the user.
     * If the file cannot be found, displays an error message.
     */
    public static void viewInstruct() {
        try {
            System.out.print(ReadFile.readFileAsString("instructions.txt"));
        } catch (IOException e) {
            System.err.println("Could not find instructions. Please ensure that instructions.txt exists.");
        }
    }
}