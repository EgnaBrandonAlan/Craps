import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * ReadFile provides a utility method for reading the contents of a file.
 * 
 * It includes a single static method to read an entire file
 * into a String.
 * 
 * @author Brandon Egna
 * @version 1.0
 */
public final class ReadFile {
    private ReadFile() throws AssertionError {
        throw new AssertionError("Utility class should not be instantiated.");
    }

    /**
     * Reads the entire contents of a file as a single String.
     * 
     * @param resourcePath the path to the file or resource to read
     * @return the contents of the file as a String
     * @throws IOException if an I/O error occurs reading from the file
     */
    public static String readFileAsString(String resourcePath) throws IOException {
        try (InputStream is = ReadFile.class.getResourceAsStream(resourcePath)) {
            if (is == null) {
                return new String(Files.readAllBytes(Paths.get(resourcePath)), StandardCharsets.UTF_8);
            }
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}