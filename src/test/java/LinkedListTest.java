import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedListTest {

    @Test
    public void nodeHoldsIntegerData() {
        Node node = new Node(5);
        int expected = 5;
        int actual = node.data;

        assertEquals(expected, actual, "New node data value should be 5");
    }

    @Test
    public void testLLEmptiness() {
        LinkedList linkedList = new LinkedList();
        boolean expected = true;
        boolean actual = linkedList.isEmpty();

        assertEquals(expected, actual, "Linked list isEmpty returns true if linked list is empty");
    }

    @Test
    public void testAddingFirstNewNode(){

        LinkedList linkedList = new LinkedList();
        Node node = new Node(5);
        linkedList.add(node);

        Node expected = node;
        Node actual = linkedList.head;

        assertEquals(expected, actual, "Adding new node to a new list makes that node the head");
    }

    @Test
    public void testAddingNewNodeToEndOfLL(){

        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(5);
        Node node2 = new Node(7);
        linkedList.add(node1);
        linkedList.add(node2);

        Node expected = node2;
        Node actual = linkedList.tail;

        assertEquals(expected, actual, "Last node added will be tail node");
    }

    @Test
    public void testGetFirstNode(){

        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(5);
        Node node2 = new Node(7);
        linkedList.add(node1);
        linkedList.add(node2);

        Node expected = node1;
        Node actual = linkedList.getFirst();

        assertEquals(expected, actual, "GetFirst method should return head node");
    }

    @Test
    public void testGetLastNode(){

        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(5);
        Node node2 = new Node(7);
        linkedList.add(node1);
        linkedList.add(node2);

        Node expected = node2;
        Node actual = linkedList.getLast();

        assertEquals(expected, actual, "GetLast method should return tail node");
    }

    @Test
    public void testGetPositionIndex() {
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(5);
        Node node2 = new Node(7);
        Node node3 = new Node(4);
        Node node4 = new Node(7);
        Node node5 = new Node(5);
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);
        linkedList.add(node5);

        Node expected = node3;
        Node actual = linkedList.get(2);

        assertEquals(expected, actual, "Should return the node at the indexed parameter passed");
    }

    @Test
    public void testGetPositionIndexOutOfBounds() {
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(5);
        Node node2 = new Node(7);
        linkedList.add(node1);
        linkedList.add(node2);

        assertThrows(IndexOutOfBoundsException.class, () -> {linkedList.get(4);}, "Getting index out of bounds should throw exception");
    }

    @Test
    public void testContainsMethod_NodeExists(){
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(5);
        Node node2 = new Node(7);
        Node node3 = new Node(4);
        Node node4 = new Node(7);
        Node node5 = new Node(5);
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);
        linkedList.add(node5);

        int expected = 2;
        int actual = linkedList.contains(node3);

        assertEquals(expected, actual, "Returns index of node if found");
    }

    @Test
    public void testContainsMethod_NodeDoesNotExist(){
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(5);
        Node node2 = new Node(7);
        Node node3 = new Node(4);
        Node node4 = new Node(7);
        Node node5 = new Node(5);
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);
        linkedList.add(node5);

        int expected = -1;
        int actual = linkedList.contains(new Node(1));

        assertEquals(expected, actual, "Returns -1 if node not found");
    }

    @Test
    public void testDeleteMethod_NodeExists(){
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(5);
        Node node2 = new Node(7);
        Node node3 = new Node(4);
        Node node4 = new Node(7);
        Node node5 = new Node(5);
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);
        linkedList.add(node5);

        linkedList.delete(node3);

        int expected = -1;
        int actual = linkedList.contains(node3);

        assertEquals(expected, actual, "Should return -1 for successfully deleting node3");
    }

    @Test
    public void testDeletingTailNode() {
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(5);
        Node node2 = new Node(7);
        linkedList.add(node1);
        linkedList.add(node2);

        linkedList.delete(node2);

        Node expected = node1;
        Node actual = linkedList.getLast();

        assertEquals(expected, actual, "Tail should reassign to second to last node when deleted");
    }

    @Test
    public void testDeletingNthNode(){
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(5);
        Node node2 = new Node(7);
        Node node3 = new Node(9);
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);

        linkedList.delete(1);

        int expected = -1;
        int actual = linkedList.contains(node2);

        assertEquals(expected, actual, "Should return -1 after deleting specified index");
    }

    @Test
    public void testDeleteNthExceptionError() {

        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(5);
        Node node2 = new Node(7);
        Node node3 = new Node(9);
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);

        assertThrows(IndexOutOfBoundsException.class, () -> {linkedList.delete(5);}, "Using an index larger than list should throw Exception");
    }

    @Test
    public void testDeletingNodeFromOneElementList() {

        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(5);
        linkedList.add(node1);
        linkedList.delete(node1);

        Node expected = null;
        Node actual = linkedList.getLast();

        assertEquals(expected, actual, "Deleting the only node by reference in the list should return Null on getLast()");
    }

    @Test
    public void testDeletingNodeFromOneElementListByIndex() {

        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(5);
        linkedList.add(node1);
        linkedList.delete(0);

        Node expected = null;
        Node actual = linkedList.getLast();

        assertEquals(expected, actual, "Deleting the only node by index in the list should return Null on getLast()");
    }
}
