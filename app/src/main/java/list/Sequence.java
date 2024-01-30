package list;

/**
 * An interface for a sequence, a data structure supporting all operations of
 * the ADTs list and positional list.
 *
 * @author Roberto Tamassia
 * @author Michael Goodrich
 *
 * @see IllegalArgumentException
 * @see IndexOutOfBoundsException
 * @see List
 * @see PositionalList
 */
public interface Sequence<E> extends List<E>, PositionalList<E> {
    /**
     * Returns the position containing the element at the given index.
     * 
     * @param index The index of the element.
     * @return The position of the element at the specified index.
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()-1
     */
    Position<E> atIndex(int index) throws IndexOutOfBoundsException;

    /**
     * Returns the index of the element stored at the given Position.
     * 
     * @param position The Position of the element.
     * @return The index of the element at the specified Position.
     * @throws IllegalArgumentException if position is not a valid position for this
     *                                  list.
     */
    int indexOf(Position<E> position) throws IllegalArgumentException;
}