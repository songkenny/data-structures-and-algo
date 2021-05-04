public class LinkedList {

    Node head;
    Node tail;
    int size = 0;

    public boolean isEmpty() {
        return head == null;
    }


    public void add(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public Node getFirst() {
        return head;
    }

    public Node getLast() {
        return tail;
    }

    public Node get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int contains(Node node) {
        Node currentNode = head;
        int index = 0;
        while (currentNode != node && currentNode != null) {
            index++;
            currentNode = currentNode.next;
        }
        return index == size ? -1 : index;
    }

    public void delete(Node node) {
        size--;
        Node currentNode = head;

        if (node == tail && node == head) {
            head = null;
            tail = null;
            return;
        }

        if (currentNode == node) {
            head = head.next;
            return;
        }
        while(currentNode.next != node && currentNode != null) {
            currentNode = currentNode.next;
        }

        if (currentNode.next == tail){
            tail = currentNode;
        }
        currentNode.next = node.next;
    }

    public void delete(int index) {
        Node currentNode = head;

        if(index >= size) {
            throw new IndexOutOfBoundsException();
        }

        size--;

        if (size == 0) {
            head = null;
            tail = null;
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }
        if (currentNode.next == tail){
            tail = currentNode;
        }
        currentNode.next = currentNode.next.next;

    }


}
