import main.java.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    void testPush() {
        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");

        assertEquals(2, stack.size());
        assertEquals("B", stack.peek());
    }

    @Test
    void testPeek() {
        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");

        assertEquals("B", stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    void testPop() {
        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");

        assertEquals("B", stack.pop());
        assertEquals("A", stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void testSearchReserve() {
        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals(2, stack.searchReserve("A"));
        assertEquals(1, stack.searchReserve("B"));
        assertEquals(0, stack.searchReserve("C"));
        assertEquals(-1, stack.searchReserve("X"));

        // searchReserve tidak boleh mengubah urutan Stack
        assertEquals("C", stack.peek());
        assertEquals(3, stack.size());
    }

    @Test
    void testRestore() {
        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");

        Stack<String> sementara = new Stack<>();

        sementara.push(stack.pop());
        sementara.push(stack.pop());

        stack.restore(sementara);

        assertEquals("B", stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    void testValidateInvariant() {
        Stack<String> stack = new Stack<>();

        assertTrue(stack.validateInvariant());

        stack.push("A");
        stack.push("B");

        assertTrue(stack.validateInvariant());

        stack.pop();

        assertTrue(stack.validateInvariant());
    }
}
