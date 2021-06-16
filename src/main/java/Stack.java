public class Stack {
    Node top;

    public boolean isEmpty(){
        return top == null;
    }

    public void add(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public int peek(){
        return top.data;
    }

    public int remove(){
        Node returnNode = top;
        top = top.next;
        return returnNode.data;
    }
}
