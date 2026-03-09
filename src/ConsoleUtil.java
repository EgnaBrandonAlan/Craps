import java.io.IOException;
import java.util.Scanner;

/**
 * ConsoleUtil provides utility methods for console-based input
 * and output.
 * 
 * Includes methods for yes/no promps and displaying instructions
 * from a file. All methods are static.
 * 
 * @author Brandon Egna
 * @version 1.0
 */
class ConsoleUtil {

    /**
     * Prompts the user with a yes/no question and reads their input.
     * Returns true if the answer is 'Y' or defaultValue indicates yes,
     * and false if the answer is 'N' or defaultValue indicates no.
     * 
     * If the user enters nothing, the default value is selected.
     * 
     * @param in Scanner used for reading user input
     * @param prompt The question being displayed to the user
     * @param defaultValue The default reponse for empty inputs
     * @return true if the user answers yes, false if no
     */
    public static boolean askYesNo(Scanner in, String prompt, char defaultValue) {
        defaultValue = Character.toUpperCase(defaultValue);
        
        while (true) {
            System.out.print(prompt + "\n> ");
            String input = in.nextLine().trim();

            if (input.isEmpty()) return defaultValue == 'Y';

            char c = Character.toUpperCase(input.charAt(0));

            if (c == 'Y') return true;
            if (c == 'N') return false;

            System.out.print("Please enter Y or N.\n> ");
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
            System.out.println("Could not find instructions. Please ensure that instructions.txt exists.");
        }
    }
}