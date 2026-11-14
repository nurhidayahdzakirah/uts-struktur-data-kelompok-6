import main.java.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {

    @Test
    void testAddFirst() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addFirst("B");
        list.addFirst("A");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    void testAddLast() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addLast("A");
        list.addLast("B");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    void testInsert() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.add("A");
        list.add("C");
        list.insert(1, "B");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void testGet() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.add("A");
        list.add("B");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertNull(list.get(5));
    }

    @Test
    void testSet() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.add("A");
        list.add("B");

        list.set(1, "C");

        assertEquals("C", list.get(1));
    }

    @Test
    void testRemove() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        String hasil = list.remove(1);

        assertEquals("B", hasil);
        assertEquals(2, list.size());
        assertEquals("C", list.get(1));
    }

    @Test
    void testSearch() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(1, list.search("B"));
        assertEquals(-1, list.search("X"));
    }

    @Test
    void testContains() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.add("A");
        list.add("B");

        assertTrue(list.contains("A"));
        assertFalse(list.contains("X"));
    }

    @Test
    void testValidateInvariant() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.add("A");
        list.add("B");

        assertTrue(list.validateInvariant());

        list.remove(0);

        assertTrue(list.validateInvariant());
    }
}
