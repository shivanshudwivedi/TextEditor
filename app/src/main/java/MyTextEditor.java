import list.ArraySequence;

/**
 * This class implements the interface SimpleTextEditor to create the editor
 *
 * @version 1.0.0, 18th November 2023
 * @author Shivanshu Dwivedi
 */
public class MyTextEditor implements SimpleTextEditor {

    /**
     * It declares an instance of the class ArraySequence
     */
    private ArraySequence<String> lineStr;
    /**
     * It stores the location of the cursor
     */
    private int cursor;

    /**
     * It creates an instance of the class MyTextEditor
     */
    public MyTextEditor(){
        lineStr = new ArraySequence<>();
        cursor = -1;
    }
    @Override
    public boolean isEmpty() {
        return (lineStr.isEmpty() && cursor == -1);
    }

    @Override
    public int size() {
        return lineStr.size();
    }

    @Override
    public boolean isCursorAtLastLine() {
        if(isEmpty()){
            return false;
        }
        return (cursor == (lineStr.size() -1));
    }

    @Override
    public void cursorDown() throws IndexOutOfBoundsException {

        if(isCursorAtLastLine()){
            throw new IndexOutOfBoundsException("Cursor is at the last line");
        }
        cursor++;
    }

    @Override
    public void cursorUp() throws IndexOutOfBoundsException {
        if(cursor <= 0){
            throw new IndexOutOfBoundsException("Cursor is at the first line or above");
        }
        cursor--;
    }

    @Override
    public void moveCursorToLine(int line) throws IndexOutOfBoundsException {
        if((line < 0) || (line > lineStr.size() -1)){
            throw new IndexOutOfBoundsException("Line does not exist");
        }
        cursor = line;
    }

    @Override
    public int cursorLineNum() {
        return cursor;
    }

    @Override
    public void insertAfterCursor(String insertion) {
        lineStr.add(cursor + 1, insertion);
        cursorDown();
    }

    @Override
    public void insertBeforeCursor(String insertion) {
        lineStr.add(cursor-1, insertion);
        cursorUp();
    }

    @Override
    public String getAtCursor() {
        return lineStr.get(cursor);
    }

    @Override
    public void replaceAtCursor(String replacement) {
        lineStr.set(cursor, replacement);
    }

    @Override
    public void removeAtCursor() {
        lineStr.remove(cursor);
        if(cursor == lineStr.size() && cursor != 0){
            cursor--;
        }


    }

    /**
     * It converts all the lines in stored arrays to String
     *
     * @return It returns the string representation of the array
     */
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int index = 0; index < lineStr.size(); index++){
            str.append(lineStr.get(index));
            if(index < lineStr.size() - 1){
                str.append("\n");
            }
        }
        return str.toString();
    }
}