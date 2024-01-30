/**
 * This is a simple text editor interface, which assumes a text editor
 * is built for lines of text. Each line of text is to be viewed as a
 * separate string. In addition, this editor has a cursor associated
 * with some line in the text. Initially, the cursor is set to the
 * line -1 just before the first line in the text. The methods of the
 * text editor are designed to update and print the text file using the
 * cursor.
 *
 * @author Takunari Miyazaki
 * @see IndexOutOfBoundsException
 */
public interface SimpleTextEditor {

    /**
     * Returns true if the text is completely empty (and cursor is at line -1).
     * 
     * @return true if the text is empty and false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the current number of lines of text.
     * 
     * @return the current number of lines
     */
    int size();

    /**
     * Returns true if the cursor is at the last line in the text or the text
     * is empty.
     * 
     * @return true if the cursor is at the last line and false otherwise.
     */
    boolean isCursorAtLastLine();

    /**
     * Sets the cursor to be the text line after its current position.
     * 
     * @throws IndexOutOfBoundsException if the current line is size()-1
     */
    void cursorDown() throws IndexOutOfBoundsException;

    /**
     * Sets the cursor to be the text line before its current position.
     * 
     * @throws IndexOutOfBoundsException if the current line is 0
     */
    void cursorUp() throws IndexOutOfBoundsException;

    /**
     * Sets the cursor to be the line ranked i (the first line is line 0).
     * 
     * @param line The target line number.
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()-1
     */
    void moveCursorToLine(int line) throws IndexOutOfBoundsException;

    /**
     * Returns the line number (rank) of the current cursor line.
     */
    int cursorLineNum();

    /**
     * Inserts a given string in the line after the current cursor, moving the
     * cursor to the line inserted.
     * 
     * @param insertion The string to be inserted.
     */
    void insertAfterCursor(String insertion);

    /**
     * Inserts the given string in the line before the current cursor, moving the
     * cursor to the line inserted.
     * 
     * @param insertion The string to be inserted.
     */
    void insertBeforeCursor(String insertion);

    /**
     * Get the current line at the cursor.
     *
     * @return The line of text at the cursor.
     */
    String getAtCursor();

    /**
     * Replaces the string at the current cursor with the given string, keeping
     * the cursor at this line.
     * 
     * @param replacement The string to be inserted.
     */
    void replaceAtCursor(String replacement);

    /**
     * Removes the entire line at the current cursor, setting the cursor to now
     * be the position of the next line, unless the cursor was the last line,
     * in which case the cursor should move to the new last line.
     */
    void removeAtCursor();
}