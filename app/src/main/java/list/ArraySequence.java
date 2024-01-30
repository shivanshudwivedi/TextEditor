package list;

/**
 * This class implements the interface Sequence and builds upon the class ArrayBackedList to implement methods for handling a list
 * @param <E> It can store any data type
 *
 * @version 1.0.0, 18th November 2023
 * @author Shivanshu Dwivedi
 */
public class ArraySequence<E> implements Sequence<E> {

    /**
     * This private class implements the interface Position and is used in the class ArraySequence
     * @param <E> It stores any data type
     */
    private class SequenceNode<E> implements Position<E>{

        /**
         * It stores the element in the array
         */
        private E element;
        /**
         * It stores the index of the element in array
         */
        private int index;

        /**
         * It is used to create an instance of the class SequenceNode
         *
         * @param element The element to be store in the array
         * @param index The index at which the element is to be stored in the array
         */
        public SequenceNode(E element, int index){
            this.element = element;
            this.index = index;
        }

        /**
         * This method is usewd to return the element in array
         *
         * @return It returns element of the array
         * @throws IllegalStateException If the element in the array is null
         */
        public E getElement() throws IllegalStateException {
            if(element == null){
                throw new IllegalStateException("The element in the array does not exist.");
            }
            return element;
        }

        /**
         * It returns the index of the array
         *
         * @return returns the index of the element in the array
         */
        public int getIndex(){
            return index;
        }
    }

    /**
     * It declares a new instance of the class ArrayBackedList of SequenceNode
     */
    private ArrayBackedList<SequenceNode<E>> items;

    /**
     * It creates a new instance of the class ArraySequence
     */
    public ArraySequence(){
        items = new ArrayBackedList<>();
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return number of elements in the list
     */
    public int size(){
        return items.size();
    }

    /**
     * Tests whether the list is empty.
     *
     * @return true If the list is empty and false otherwise.
     */
    public boolean isEmpty(){
        return items.isEmpty();
    }

    /**
     * Returns the first Position in the list.
     *
     * @return the first Position in the list (or null, if empty).
     */
    public Position<E> first() {
        if(isEmpty()){
            return null;
        }
        return items.get(0);
    }

    /**
     * Returns the last Position in the list.
     *
     * @return the last Position in the list (or null, if empty).
     */
    public Position<E> last() {
        if(isEmpty()){
            return null;
        }
        return items.get(size()-1);
    }


    /**
     * Returns the Position immediately before the given position.
     *
     * @param position A Position of the list.
     * @return The Position of the preceding element (or null, if p is first).
     * @throws IllegalArgumentException if p is not a valid position for this
     *                                  list.
     */
    public Position<E> before(Position<E> position) throws IllegalArgumentException{
        int index = indexOf(position);

        if(index < 0 || index >= items.size()){
            throw new IllegalArgumentException("The position is not valid.");
        }

        if( index == 0 ){
            return null;
        }

        return items.get(index-1);
    }

    /**
     * Returns the Position immediately after Position p.
     *
     * @param position A Position of the list.
     * @return The Position of the following element (or null, if p is last)
     * @throws IllegalArgumentException If position is not a valid position for this
     *                                  list.
     */
    public Position<E> after(Position<E> position) throws IllegalArgumentException{
        int index = indexOf(position);

        if(index < 0 || index >= items.size()){
            throw new IllegalArgumentException("The position is not valid.");
        }

        if( index == size()-1){
            return null;
        }
        return items.get(index+1);
    }

    /**
     * Inserts an element at the front of the list.
     *
     * @param element the new element.
     * @return The Position representing the location of the new element.
     */
    public Position<E> addFirst(E element){
        this.add(0, element);
        return first();
    }

    /**
     * Inserts an element at the back of the list.
     *
     * @param element The new element.
     * @return The Position representing the location of the new element.
     */
    public Position<E> addLast(E element){
        add(size(), element);
        return last();
    }

    /**
     * Inserts an element immediately before the given Position.
     *
     * @param position The Position before which the insertion takes place.
     * @param element  The new element.
     * @return The Position representing the location of the new element.
     * @throws IllegalArgumentException if p is not a valid position for this
     *                                  list.
     */
    public Position<E> addBefore(Position<E> position, E element) throws IllegalArgumentException{
        int index = indexOf(position);
        if(index < 1 || index >size()){
            throw new IllegalArgumentException("The position is not valid.");
        }
        add(index-1 , element);
        return before(position);
    }

    /**
     * Inserts an element immediately after the given Position.
     *
     * @param position The Position after which the insertion takes place.
     * @param element  The new element.
     * @return the Position representing the location of the new element
     * @throws IllegalArgumentException If position is not a valid position for this
     *                                  list.
     */
    public Position<E> addAfter(Position<E> position, E element) throws IllegalArgumentException{
        int index = indexOf(position);
        if(index < -1 || index > size()-1){
            throw new IllegalArgumentException("Illegal index provided");
        }
        add(index+1, element);
        return after(position);
    }

    /**
     * Returns (but does not remove) the element at index i.
     *
     * @param index The index of the element to return.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException If the index is negative or greater
     *                                   than size()-1.
     */
    public E get(int index) throws IndexOutOfBoundsException{
        //trying with -1 but set to 0 again
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Illegal index provided");
        }
        return items.get(index).getElement();
    }

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
    public E set(int index, E element) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Illegal index provided");
        }
        SequenceNode<E> node = new SequenceNode<>(element,index);
        E prevElement = get(index);
        items.set(index, node);
        return prevElement;
    }

    /**
     * Inserts the given element at the specified index of the list, shifting
     * all subsequent elements in the list one position further to make room.
     *
     * @param index   The index at which the new element should be stored.
     * @param element The new element to be stored.
     * @throws IndexOutOfBoundsException If the index is negative or greater
     *                                   than size().
     */
    public void add(int index, E element) throws IndexOutOfBoundsException{
        SequenceNode<E> node = new SequenceNode<>(element, index);
        items.add(index, node);
    }

    /**
     * Removes and returns the element at the given index, shifting all
     * subsequent elements in the list one position closer to the front.
     *
     * @param index The index of the element to be removed.
     * @return The element that had be stored at the given index.
     * @throws IndexOutOfBoundsException If the index is negative or greater
     *                                   than size()-1.
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Illegal index provided");
        }

        E prevElement = get(index);
        items.remove(index);
        return prevElement;
    }

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
    public E set(Position<E> position, E element) throws IllegalArgumentException{
        SequenceNode<E> node = (SequenceNode<E>) position;
        int index = indexOf(position);

        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Illegal index provided");
        }

        E prevElement = node.getElement();
        items.set(index, node);
        return prevElement;
    }

    /**
     * Removes the element stored at the given Position and returns it.
     * The given position is invalidated as a result.
     *
     * @param position The Position of the element to be removed.
     * @return The removed element.
     * @throws IllegalArgumentException If position is not a valid position for this
     *                                  list.
     */
    public E remove(Position<E> position) throws IllegalArgumentException{
        SequenceNode<E> node = (SequenceNode<E>) position;
        int index = indexOf(position);

        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Illegal index provided");
        }

        E oldElement = node.getElement();
        items.remove(index);
        return oldElement;

    }

    /**
     * Returns the position containing the element at the given index.
     *
     * @param index The index of the element.
     * @return The position of the element at the specified index.
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()-1
     */
    public Position<E> atIndex(int index) throws IndexOutOfBoundsException{
        //trying with -1 but change to 0
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Illegal index provided");
        }
        return items.get(index);

    }

    /**
     * Returns the index of the element stored at the given Position.
     *
     * @param position The Position of the element.
     * @return The index of the element at the specified Position.
     * @throws IllegalArgumentException if position is not a valid position for this
     *                                  list.
     */
    public int indexOf(Position<E> position) throws IllegalArgumentException{
        SequenceNode<E> node = (SequenceNode<E>) position;

        for(int index = 0; index < items.size(); index++){
            if(items.get(index).equals(node)){
                return index;
            }
        }
        return -1;
    }

    /**
     * It returns a String representation of all the elements stored in the object
     *
     * @return It returns the elements in the object array as a string
     */
    public String toString(){

        if(isEmpty()){
            return "{}";
        }
        StringBuilder str = new StringBuilder("{");

        for(int i = 0; i < size() ; i++){
            Position<E> pos = atIndex(i);
            str.append("(" + i + "," + pos.getElement()+ ")");
            if(i < (size() -1)){
                str.append(",");
            }
        }
        str.append("}");
        return str.toString();
    }
}
