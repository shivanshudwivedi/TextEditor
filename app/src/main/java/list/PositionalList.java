package list;

/**
 * An interface for positional lists.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @see IllegalArgumentException
 * @see Position
 */
public interface PositionalList<E> {

    /**
     * Returns the number of elements in the list.
     * 
     * @return number of elements in the list
     */
    int size();

    /**
     * Tests whether the list is empty.
     * 
     * @return true if the list is empty and false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the first Position in the list.
     * 
     * @return the first Position in the list (or null, if empty).
     */
    Position<E> first();

    /**
     * Returns the last Position in the list.
     * 
     * @return the last Position in the list (or null, if empty).
     */
    Position<E> last();

    /**
     * Returns the Position immediately before the given position.
     * 
     * @param position A Position of the list.
     * @return The Position of the preceding element (or null, if p is first).
     * @throws IllegalArgumentException if p is not a valid position for this
     *                                  list.
     */
    Position<E> before(Position<E> position) throws IllegalArgumentException;

    /**
     * Returns the Position immediately after Position p.
     * 
     * @param position A Position of the list.
     * @return The Position of the following element (or null, if p is last)
     * @throws IllegalArgumentException If position is not a valid position for this
     *                                  list.
     */
    Position<E> after(Position<E> position) throws IllegalArgumentException;

    /**
     * Inserts an element at the front of the list.
     * 
     * @param element the new element.
     * @return The Position representing the location of the new element.
     */
    Position<E> addFirst(E element);

    /**
     * Inserts an element at the back of the list.
     * 
     * @param element The new element.
     * @return The Position representing the location of the new element.
     */
    Position<E> addLast(E element);

    /**
     * Inserts an element immediately before the given Position.
     * 
     * @param position The Position before which the insertion takes place.
     * @param element  The new element.
     * @return The Position representing the location of the new element.
     * @throws IllegalArgumentException if p is not a valid position for this
     *                                  list.
     */
    Position<E> addBefore(Position<E> position, E element) throws IllegalArgumentException;

    /**
     * Inserts an element immediately after the given Position.
     * 
     * @param position The Position after which the insertion takes place.
     * @param element  The new element.
     * @return the Position representing the location of the new element
     * @throws IllegalArgumentException If position is not a valid position for this
     *                                  list.
     */
    Position<E> addAfter(Position<E> position, E element) throws IllegalArgumentException;

    /**
     * Replaces the element stored at the given Position and returns the
     * replaced element.
     * 
     * @param position The Position of the element to be replaced.
     * @param element  The new element.
     * @return The replaced element.
     * @throws IllegalArgumentException If position is not a valid position for this
     *                                  list.
     */
    E set(Position<E> position, E element) throws IllegalArgumentException;

    /**
     * Removes the element stored at the given Position and returns it.
     * The given position is invalidated as a result.
     * 
     * @param position The Position of the element to be removed.
     * @return The removed element.
     * @throws IllegalArgumentException If position is not a valid position for this
     *                                  list.
     */
    E remove(Position<E> position) throws IllegalArgumentException;
}