import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This clas is used to test the implementation of the class MyTextEditor
 *
 * @version 1.0.0, 19th November 2023
 * @author Shivanshu Dwivedi
 */
public class EditorTest {

    @Test
    void emptyEditor() {

        SimpleTextEditor edit = new MyTextEditor();

        // Verify isEmpty() and size()
        assertTrue(edit.isEmpty());
        assertEquals(edit.size(), 0);
    }

    /**
     * Load the document in the editor and verify the content matched the initial.txt content.
     */

    @Test
    void testEditor() {

       SimpleTextEditor editor = new MyTextEditor();

        applyInitialState(editor);
        assertEquals(getText("initial.txt"), editor.toString());

        System.out.format("""
            ====================
            The initial document\n
            {%s}\n
            """, editor);


        applyMiddleState(editor);
        assertEquals(getText("middle.txt"), editor.toString());

        System.out.format("""
            ====================
            The middle document\n
            {%s}\n
            """, editor);


        applyFinalState(editor);
        assertEquals(getText("final.txt"), editor.toString());

        System.out.format("""
            ====================
            The final document\n
            {%s}\n
            """, editor);
    }

    /**
     * Join the array line with newlines to make it look like a file document.
     *
     * @param content The lines of the document
     * @return The full document in a single string joined with newlines.
     */
    private String join(String[] content) {
        return String.join("\n", content).trim();
    }

    /**
     * This performs the tasks required in the initial state
     *
     * @param editor It is an object of the type SimpleTextEditor
     */
    private void applyInitialState(SimpleTextEditor editor) {

        String[] expected = EditorUtilities.readResourceFile("initial.txt");

        for(String line : expected){
            editor.insertAfterCursor(line);
        }
        System.out.println(editor);

    }

    /**
     * This performs the tasks required in the middle state
     *
     * @param editor It is an object of the type SimpleTextEditor
     */
    private void applyMiddleState(SimpleTextEditor editor) {
        editor.moveCursorToLine(0);
        editor.replaceAtCursor("Narnia... where the woods are thick and cool, where Talking Beasts are called to");
        editor.moveCursorToLine(3);
        editor.replaceAtCursor("where evil men turn into donkeys, where boys and girls go into battle.");
        editor.insertAfterCursor("");
        editor.moveCursorToLine(5);
        editor.replaceAtCursor("Narnia... the land between the lamp-post and the castle of Cair Paravel,");
        editor.moveCursorToLine(6);
        editor.replaceAtCursor("where animals talk, where magical things happen, the world of wicked deans");
        editor.moveCursorToLine(8);
        editor.insertAfterCursor("");
        editor.moveCursorToLine(10);
        editor.replaceAtCursor("Narnia... where professors are wise, where some of the giants like to");
        editor.moveCursorToLine(11);
        editor.replaceAtCursor("snack on students (and, if carefully cooked, on Marsh-wiggles, too),");
        editor.moveCursorToLine(12);
        editor.insertAfterCursor("");
        editor.moveCursorToLine(14);
        editor.replaceAtCursor("Narnia... where dwarfs are loyal and tough and strong-or are they?");

    }

    /**
     * This performs the tasks required in the final state
     *
     * @param editor It is an object of the type SimpleTextEditor
     */
    private void applyFinalState(SimpleTextEditor editor) {
        editor.moveCursorToLine(2);
        editor.replaceAtCursor("Susan, Edmund, and Lucy.");
        editor.insertAfterCursor("");
        editor.insertAfterCursor("Narnia... where horses talk and hermits like company,");
        editor.moveCursorToLine(10);
        editor.replaceAtCursor("where anything can happen (and most often does).");
        editor.moveCursorToLine(12);
        editor.replaceAtCursor("Narnia... where owls are wise, where some of the giants like to");
        editor.moveCursorToLine(16);
        editor.replaceAtCursor("Narnia... where dwarfs are loyal and tough and strong---or are they really?");
    }

    private String getText(String canonical) {
        return join(EditorUtilities.readResourceFile(canonical));
    }
}
