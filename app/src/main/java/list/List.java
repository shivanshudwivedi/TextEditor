package list;

/**
 * A simplified version of the java.util.List interface.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @see IndexOutOfBoundsException
 */
public interface List<E> {
  /**
   * Returns the number of elements in the list.
   * 
   * @return number of elements in the list
   */
  int size();

  /**
   * Tests whether the list is empty.
   * 
   * @return true If the list is empty and false otherwise.
   */
  boolean isEmpty();

  /**
   * Returns (but does not remove) the element at index i.
   * 
   * @param index The index of the element to return.
   * @return The element at the specified index.
   * @throws IndexOutOfBoundsException If the index is negative or greater
   *                                   than size()-1.
   */
  E get(int index) throws IndexOutOfBoundsException;

  /**
   * Replaces the element at the specified index, and returns the element
   * previously stored.
   * 
   * @param index   The index of the element to replace.
   * @param element the new element to be stored.
   * @return the previously stored element.
   * @throws IndexOutOfBoundsException If the index is negative or greater
   *                                   than size()-1.
   */
  E set(int index, E element) throws IndexOutOfBoundsException;

  /**
   * Inserts the given element at the specified index of the list, shifting
   * all subsequent elements in the list one position further to make room.
   * 
   * @param index   The index at which the new element should be stored.
   * @param element The new element to be stored.
   * @throws IndexOutOfBoundsException If the index is negative or greater
   *                                   than size().
   */
  void add(int index, E element) throws IndexOutOfBoundsException;

  /**
   * Removes and returns the element at the given index, shifting all
   * subsequent elements in the list one position closer to the front.
   * 
   * @param index The index of the element to be removed.
   * @return The element that had be stored at the given index.
   * @throws IndexOutOfBoundsException If the index is negative or greater
   *                                   than size()-1.
   */
  E remove(int index) throws IndexOutOfBoundsException;
}