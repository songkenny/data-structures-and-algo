import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StackTest {
    Stack stack;
    @BeforeEach
    public void createNewStack() {
        stack = new Stack ();
    }

    @Test
    public void nodeHoldsIntegerData() {
        Node node = new Node(5);
        int expected = 5;
        int actual = node.data;

        assertEquals(expected, actual, "New node data value should be 5");
    }

    @Test
    public void testStackEmptiness() {
        boolean expected = true;
        boolean actual = stack.isEmpty();

        assertEquals(expected, actual, "Stack isEmpty returns true if stack is empty");
    }

    @Test
    public void testAddingFirstNewNode(){
        stack.add(5);

        int expected = 5;
        int actual = stack.top.data;

        assertEquals(expected, actual, "Adding new value to a new stack put it as the head");
    }

    @Test
    public void testPeek() {
        stack.add(5);
        stack.add(4);
        stack.add(3);

        int expected = 3;
        int actual = stack.peek();

        assertEquals(expected, actual, "Peeking at stack should return last inserted value");
        assertEquals(expected, stack.top.data, "Peeking should not alter the stack");
    }

    @Test
    public void testRemoveForNonEmptyStack() {
        stack.add(6);
        stack.add(5);
        stack.add(4);
        stack.add(3);

        int expected = 3;
        int actual = stack.remove();

        assertEquals(expected, actual, "Removing from stack should return last inserted value");
        assertEquals(4, stack.top.data, "Removing from stack should make the top the second to last inserted value");
    }

    @Test
    public void testRemoveWhenStackLengthOne() {
        stack.add(5);
        stack.remove();

        assertNull(stack.top, "Stack top should be null after removing the only element");
    }
}
