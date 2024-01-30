import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * A collection of utility methods that help the text Editor.
 */
public class EditorUtilities {

    /**
     * Private constructor to follow the utility class pattern.
     */
    private EditorUtilities() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * Load a file that is in the classpath as a resource.
     *
     * @param resourceName The file name as a resource
     * @return The lines in the given file.
     */
    public static String[] readResourceFile(String resourceName) {
        try {
            return readDocument(Paths.get(Objects.requireNonNull(EditorUtilities.class.getResource(resourceName)).toURI()));
        } catch (URISyntaxException e) {
            // Handle exceptions if the resource file is not found
            e.printStackTrace();
            return new String[0]; // Return an empty array or throw an exception as needed
        }
    }

    /**
     * Utility method to read a document into a String array where each line is a
     * separate string.
     *
     * @param source The path to the source text file to read.
     * @return The lines of the read file.
     */
    private static String[] readDocument(Path source) {
        try {
            // Reads in pure lines without messy \r\n ending characters.
            String[] lines = Files.readAllLines(source).toArray(String[]::new);
            scrub(lines);
            return lines;
        } catch (IOException exception) {
            System.err.format("Error: File '%s' could not be read in path.%n", source);
            exception.printStackTrace();
        }

        return new String[]{};
    }

    /**
     * Purge the read is files from trailing whitespace at the end of some of the
     * lines. Technically the editor could adjust the lines to match the
     * whitespaces, but it's easier to meet the project requirements by just trimming
     * and removing whitespace. Beware some of the lines have additional spaces
     * added between characters.
     *
     * @param lines The document lines to trim.
     */
    private static void scrub(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].trim();
        }
    }

    /**
     * A utility method to dump all text in hex format to reveal hidden whitespace.
     *
     * @param text The text to dump as hex.
     * @return The hex form of the given text.
     */
    private static String toHex(String text) {
        return String.format("%040x", new java.math.BigInteger(1, text.getBytes()));
    }
}
