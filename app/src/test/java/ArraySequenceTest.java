import list.ArraySequence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySequenceTest {

    private ArraySequence<Character> getCollection() {
        ArraySequence<Character> as = new ArraySequence<>();

        // Verify addFirst() and add()
        as.addFirst('A');
        as.add(1, 'B');
        as.add(2, 'C');
        return as;
    }

    @Test
    void empty() {
        ArraySequence<Character> as = new ArraySequence<>();
        assertTrue(as.isEmpty(), "Initial collection state should be empty.");
    }

    @Test
    void addElements() {
        ArraySequence<Character> as = getCollection();

        assertEquals(as.toString(), "{(0,A),(1,B),(2,C)}");
        assertEquals(as.size(), 3);
    }

    @Test
    void get() {
        ArraySequence<Character> as = getCollection();
        assertEquals(as.get(1), 'B', "get(1) expecting B");
    }

    @Test
    void set() {
        ArraySequence<Character> as = getCollection();
        as.addLast('D');
        as.set(as.size() - 1, '!');

        assertEquals(as.toString(), "{(0,A),(1,B),(2,C),(3,!)}");
    }

    @Test
    void remove() {
        ArraySequence<Character> as = getCollection();
        as.addLast('D');
        as.set(as.size() - 1, '!');

        as.remove(as.size() - 1);
        assertEquals(as.toString(), "{(0,A),(1,B),(2,C)}");
    }

    @Test
    void first() {
        ArraySequence<Character> as = getCollection();
        assertEquals(as.first().getElement(), 'A');
    }

    @Test
    void last() {
        ArraySequence<Character> as = getCollection();
        assertEquals(as.last().getElement(), 'C');
    }

    @Test
    void before() {
        ArraySequence<Character> as = getCollection();
        assertEquals(as.before(as.atIndex(1)), as.first());
    }

    @Test
    void after() {
        ArraySequence<Character> as = getCollection();
        assertEquals(as.after(as.atIndex(1)), as.last());
    }

    @Test
    void atIndex() {
        ArraySequence<Character> as = getCollection();
        assertEquals(as.atIndex(0), as.first());
    }

    @Test
    void equals() {
        ArraySequence<Character> as = getCollection();
        assertEquals(as.last(), as.last());
    }

    @Test
    void removalAll() {
        ArraySequence<Character> as = getCollection();
        int size = as.size();
        for (int i = 0; i < size; i++) {
            as.remove(0);
        }
        assertTrue(as.isEmpty(), "Initial collection state should be empty.");
    }

    @Test
    void addLast() {
        ArraySequence<Character> as = new ArraySequence<>();

        as.addFirst('Y');
        assertEquals("{(0,Y)}", as.toString());

        as.addFirst('X');
        assertEquals(as.first().getElement(), 'X');

        as.addLast('Z');
        assertEquals(as.toString(), "{(0,X),(1,Y),(2,Z)}");
    }
}
