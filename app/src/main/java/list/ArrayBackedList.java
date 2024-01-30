package list;

/**
 * Realization of a list by means of a dynamic array. This is a simplified
 * version of the java.util.ArrayList class.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @see IndexOutOfBoundsException
 * @see List
 */

public class ArrayBackedList<E> implements List<E> {

    /** Default array capacity. */
    public static final int INITIAL_CAPACITY = 16;

    /** Array storing the elements of the list. */
    private E[] elements;

    /** Number of elements stored in the list. */
    private int size = 0;

    /** Creates an array list with default initial capacity. */
    public ArrayBackedList() {
        this(INITIAL_CAPACITY);
    }

    /** Creates an array list with given initial capacity. */
    @SuppressWarnings("unchecked") // safe cast
    public ArrayBackedList(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    /**
     * Returns the number of elements in the list.
     * 
     * @return number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the array list is empty.
     * 
     * @return true if the array list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the element at index i.
     * 
     * @param index The index of the element to return.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()-1
     */
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        return elements[index];
    }

    /**
     * Replaces the element at the specified index, and returns the element
     * previously stored.
     * 
     * @param index   The index of the element to replace.
     * @param element The new element to be stored.
     * @return the previously stored element
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()-1
     */
    public E set(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        E previously = elements[index];
        elements[index] = element;

        return previously;
    }

    /**
     * Inserts the given element at the specified index of the list, shifting
     * all subsequent elements in the list one position further to make room.
     * 
     * @param index   The index at which the new element should be stored.
     * @param element the new element to be stored
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()
     */
    public void add(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index, size + 1);

        // Double capacity if out of room
        if (size == elements.length) {
            expand(2 * elements.length);
        }

        shiftUp(index);
        elements[index] = element; // ready to place the new element
    }

    /**
     * Removes and returns the element at the given index, shifting all
     * subsequent elements in the list one position closer to the front.
     * 
     * @param index The index of the element to be removed.
     * @return The element that had be stored at the given index.
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        E previously = elements[index];

        shiftDown(index);

        return previously;
    }

    /** Checks whether the given index is in the range [0, n-1]. */
    protected void checkIndex(int index, int range) throws IndexOutOfBoundsException {
        if (index < 0 || index >= range) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
    }

    /** Resizes internal array to have given capacity >= size. */
    @SuppressWarnings("unchecked") // safe cast
    protected void expand(int capacity) {
        E[] temp = (E[]) new Object[capacity]; // safe cast
        if (size >= 0) System.arraycopy(elements, 0, temp, 0, size);
        elements = temp; // start using the new array
    }

    /**
     * Shift elements up.
     * 
     * @param index Start at this index.
     */
    private void shiftUp(int index) {
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        size++;
    }

    /**
     * Shift elements down.
     * 
     * @param index Start at this index.
     */
    private void shiftDown(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null; // help garbage collection
        size--;
    }
}
