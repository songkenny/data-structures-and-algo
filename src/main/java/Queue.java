public class Queue {
    Node head;
    Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        }
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
    }

    public int peek() {
        return head.data;
    }

    public int remove() {
        Node returnNode = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return returnNode.data;
    }
}
