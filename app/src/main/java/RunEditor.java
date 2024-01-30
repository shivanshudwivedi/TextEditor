/**
 * A way to invoke the editor from the command line.
 *
 * @version 1.0.0, 18th November 2023
 * @author Shivanshu Dwivedi
 */
public class RunEditor {
    /**
     * The main entry point
     *
     * @param args No parameters expected.
     */
    public static void main(String[] args) {
        SimpleTextEditor editor = new MyTextEditor();
        String[] expected = EditorUtilities.readResourceFile("final.txt");
        for (String line : expected) {
            editor.insertAfterCursor(line);
        }
        System.out.println(editor);
    }
}
