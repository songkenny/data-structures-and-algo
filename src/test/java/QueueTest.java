import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    Queue queue;
    @BeforeEach
    public void createNewQueue() {
        queue = new Queue();
    }

    @Test
    public void nodeHoldsIntegerData() {
        Node node = new Node(5);
        int expected = 5;
        int actual = node.data;

        assertEquals(expected, actual, "New node data value should be 5");
    }

    @Test
    public void testQueueEmptiness() {
        boolean expected = true;
        boolean actual = queue.isEmpty();

        assertEquals(expected, actual, "Queue isEmpty returns true if queue is empty");
    }

    @Test
    public void testAddingFirstNewNode(){
        queue.add(5);

        int expected = 5;
        int actual = queue.head.data;

        assertEquals(expected, actual, "Adding new value to a new queue put it as the head");
    }

    @Test
    public void testTailWhenAddingNewNodes(){
        queue.add(5);
        queue.add(4);
        queue.add(3);

        int expected = 3;
        int actual = queue.tail.data;

        assertEquals(expected, actual, "Last added node should be the tail");
    }

    @Test
    public void testTPeekAtFirstNode(){
        queue.add(5);
        queue.add(4);
        queue.add(3);

        int expected = 5;
        int actual = queue.peek();

        assertEquals(expected, actual, "Peeking at queue should return first node value");
        assertEquals(5, queue.head.data, "Peeking should not alter the queue");
    }

    @Test
    public void testRemoveForNonEmptyQueue() {
        queue.add(5);
        queue.add(4);
        queue.add(3);

        int expected = 5;
        int actual = queue.remove();

        assertEquals(expected, actual, "Removing from queue should return first added value");
        assertEquals(4, queue.head.data, "Removing from queue should make the second value the new head");
    }

    @Test
    public void testRemoveWhenQueueLengthOne() {
        queue.add(5);
        queue.remove();

        assertNull(queue.head, "Queue head should be null after removing the only element");
        assertNull(queue.tail, "Queue tail should be null after removing the only element");
    }
}
